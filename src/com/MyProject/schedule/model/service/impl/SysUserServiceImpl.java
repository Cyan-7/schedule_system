package com.MyProject.schedule.model.service.impl;

import com.MyProject.schedule.model.dao.impl.SysUserImpl;
import com.MyProject.schedule.model.pojo.SysUser;
import com.MyProject.schedule.model.service.SysUserService;
import com.MyProject.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    SysUserImpl sysUserDao =  new SysUserImpl();

    @Override
    public int register(SysUser sysUser) throws Exception {
        //密码加密
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));

        return sysUserDao.addUser(sysUser);
    }

    @Override
    public SysUser findByUsernam(String username) {
        try {
            SysUser sysUser = sysUserDao.queryUserByUsername(username);
            return sysUser;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
