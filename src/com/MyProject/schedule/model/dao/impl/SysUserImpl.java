package com.MyProject.schedule.model.dao.impl;

import com.MyProject.schedule.model.dao.BaseDao;
import com.MyProject.schedule.model.dao.SysUserDao;
import com.MyProject.schedule.model.pojo.SysUser;

import java.util.List;

public class SysUserImpl extends BaseDao implements SysUserDao {
    @Override
    public int addUser(SysUser user) throws Exception {
        String sql = "insert into sys_user (username,user_pwd) values (?,?)";
        int update = executeUpdate(sql,user.getUserName(),user.getUserPwd());
        return update;
    }

    @Override
    public int deleteUserByUid(int uid) throws Exception {
        String sql = "delete from sys_user where uid = ?";
        int update = executeUpdate(sql,uid);
        return update;
    }

    @Override
    public List<SysUser> queryUserAll() throws Exception {
        String sql = "select uid,username userName,user_pwd userPwd from sys_user";
        List<SysUser> list = executeQuery(SysUser.class, sql);
        return list;
    }

    @Override
    public SysUser queryUserByUid(int uid) throws Exception {
        String sql = "select uid,username userName,user_pwd userPwd from sys_user where uid = ?";
        SysUser sysUser = executeQueryBean(SysUser.class, sql,uid);
        return sysUser;
    }

    public SysUser queryUserByUsername(String username) throws Exception {
        String sql = "select uid,username userName,user_pwd userPwd from sys_user where username = ?";
        SysUser sysUser = executeQueryBean(SysUser.class, sql, username);
        return sysUser;
    }
}
