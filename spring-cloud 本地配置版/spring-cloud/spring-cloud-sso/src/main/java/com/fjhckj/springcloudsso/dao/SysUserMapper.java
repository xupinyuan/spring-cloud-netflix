package com.fjhckj.springcloudsso.dao;

import com.fjhckj.springcloudcommonservice.utils.MyMapper;
import com.fjhckj.springcloudsso.entity.SysUser;

public interface SysUserMapper extends MyMapper<SysUser> {
    SysUser getUserByLoginName(SysUser sysUser);
}