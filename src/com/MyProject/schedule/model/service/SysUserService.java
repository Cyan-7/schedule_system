package com.MyProject.schedule.model.service;

import com.MyProject.schedule.model.pojo.SysUser;

/*
* 该接口定义了以sys_user表格为核心的业务处理功能
* */
public interface SysUserService {
    int register(SysUser sysUser) throws Exception;

    SysUser findByUsernam(String username);
}
