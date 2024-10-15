package com.MyProject.schedule.model.pojo;

import java.io.Serializable;

public class SysUser implements Serializable {
    private int uid;
    private String userName;
    private String userPwd;

    public SysUser() {
    }

    public SysUser(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
