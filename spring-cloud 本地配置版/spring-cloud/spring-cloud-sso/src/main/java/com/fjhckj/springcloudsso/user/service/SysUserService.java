package com.fjhckj.springcloudsso.user.service;

import com.fjhckj.springcloudsso.user.dao.SysUserMapper;
import com.fjhckj.springcloudsso.user.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> findUser(){
        return sysUserMapper.selectAll();
    }

    /**
     * 根据登录名获取用户
     * @return
     */
    public SysUser getUserByLoginName(SysUser sysUser){
        return sysUserMapper.getUserByLoginName(sysUser);
    }
}
