package com.MyProject.schedule.model.dao;

import com.MyProject.schedule.model.pojo.SysUser;

import java.util.List;

public interface SysUserDao {
    int addUser(SysUser user) throws Exception;
    int deleteUserByUid(int uid) throws Exception;
    List<SysUser> queryUserAll() throws Exception;
    SysUser queryUserByUid(int uid) throws Exception;
}
