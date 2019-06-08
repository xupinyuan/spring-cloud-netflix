package com.fjhckj.springcloudsso.user.controller;

import com.fjhckj.springcloudsso.user.entity.SysUser;
import com.fjhckj.springcloudsso.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SysUserContorler {
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping(value = "findUser")
    public List<SysUser> findUser(@RequestBody (required = false) SysUser user, String id){
        return sysUserService.findUser();
    }
    @RequestMapping(value = "findUser1")
    public List<SysUser> findUser1(String id){
        return sysUserService.findUser();
    }

}
