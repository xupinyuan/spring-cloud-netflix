package com.fjhckj.springcloudsso.login.controller;


import com.alibaba.fastjson.JSON;
import com.fjhckj.springcloudbase.utils.CookieUtils;
import com.fjhckj.springcloudbase.utils.MapperUtils;
import com.fjhckj.springcloudsso.login.service.LoginService;
import com.fjhckj.springcloudsso.user.entity.SysUser;
import com.fjhckj.springcloudsso.user.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 登录
 */
@CrossOrigin
@RestController
public class LoginContorller {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "login")
    public Map<String, Object> login(@RequestBody SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (sysUser != null && StringUtils.isNotBlank(sysUser.getUserName()) && StringUtils.isNotBlank(sysUser.getPassword())) {
                SysUser result = sysUserService.getUserByLoginName(sysUser);
                //登录成功
                if (result != null && StringUtils.isNotBlank(result.getPassword()) && sysUser.getPassword().equals(result.getPassword())) {
                    //登录信息存入缓存
                    String token = UUID.randomUUID().toString();
                    String userJson = JSON.toJSONString(result);
                    String flag = loginService.redisPut(token, userJson, 60*60*2L);
                    if("ERROR".equals(flag)){
                        throw new RuntimeException("redis调用异常1");
                    }
                    resultMap.put("code", "1");
                    resultMap.put("data", result);
                    //返回token 值
                    resultMap.put("token",token);
                } else {
                    resultMap.put("code", "-1");
                    resultMap.put("message", "用户或密码错误");
                }
            } else {
                resultMap.put("code", "-99");
                resultMap.put("message", "参数错误");
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.clear();
            resultMap.put("code", "-999");
            resultMap.put("message", "系统错误稍后重试");
            return resultMap;
        }
    }


}
