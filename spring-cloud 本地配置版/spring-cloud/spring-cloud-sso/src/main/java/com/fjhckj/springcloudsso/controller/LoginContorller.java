package com.fjhckj.springcloudsso.controller;


import com.fjhckj.springcloudsso.entity.SysUser;
import com.fjhckj.springcloudsso.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 */
@CrossOrigin
@RestController
public class LoginContorller {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "login" )
    public  Map<String,Object> login(@RequestBody SysUser sysUser){
        Map<String,Object> resultMap = new HashMap<>();

        if(sysUser != null && StringUtils.isNotBlank(sysUser.getUserName()) && StringUtils.isNotBlank(sysUser.getPassword())){
            SysUser result = sysUserService.getUserByLoginName(sysUser);
            if(result != null && StringUtils.isNotBlank(result.getPassword()) && sysUser.getPassword().equals(result.getPassword())){
                resultMap.put("code","1");
                resultMap.put("data",sysUser);
            }else {
                resultMap.put("code","-1");
                resultMap.put("message","用户或密码错误");
            }
        }else {
            resultMap.put("code","-99");
            resultMap.put("message","参数错误");
        }
        return resultMap;
    }


}
