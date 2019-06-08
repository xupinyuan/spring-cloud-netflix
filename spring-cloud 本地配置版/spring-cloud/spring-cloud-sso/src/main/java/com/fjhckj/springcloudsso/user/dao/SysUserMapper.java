package com.fjhckj.springcloudsso.user.dao;

import com.fjhckj.springcloudcommonservice.utils.MyMapper;
import com.fjhckj.springcloudsso.user.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends MyMapper<SysUser> {
    SysUser getUserByLoginName(SysUser sysUser);
}