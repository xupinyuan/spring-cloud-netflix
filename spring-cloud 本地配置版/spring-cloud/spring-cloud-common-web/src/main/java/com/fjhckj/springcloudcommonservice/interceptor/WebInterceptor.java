package com.fjhckj.springcloudcommonservice.interceptor;

import com.fjhckj.springcloudbase.utils.MapperUtils;
import com.fjhckj.springcloudcommonservice.entity.SysUser;
import com.fjhckj.springcloudcommonservice.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 未登录请求拦截
 */
@Component
public class WebInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;
    /**
     * 未执行请求方法前拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("loginUser");
        //子系统不存在局部会话   尝试获取统一认证中心会话信息
        if(sysUser == null){
            String token = request.getParameter("token");
            //如果没有token到统一认证页获取
            if(StringUtils.isBlank(token)){
                response.sendRedirect("http://localhost:8080/ssoIndex?redirect="+request.getRequestURL());
                return false;
            }
            //如果token 等于not 说明未登录 跳转sso登录
            else if("not".equals(token)){
                response.sendRedirect("http://localhost:8080/login?redirect="+request.getRequestURL());
                return false;
            }
            //根据 token 获取redis 登录数据
            String json = redisService.redisGet(token);
            //token 有效已登录
            if(StringUtils.isNotBlank(json)){
                try {
                    SysUser user = MapperUtils.json2pojo(json,SysUser.class);
                    //创建局部会话信息
                    request.getSession().setAttribute("loginUser",user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //验证局部会话是否创建完毕
            sysUser = (SysUser) request.getSession().getAttribute("loginUser");
            //没有局部会话说明认证失效跳转sso重新认证
            if(sysUser == null){
                response.sendRedirect("http://localhost:8080/login?redirect="+request.getRequestURL());
                return false;
            }
        }
        return true;
    }

}
