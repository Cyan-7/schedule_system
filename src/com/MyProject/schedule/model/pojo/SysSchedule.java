package com.MyProject.schedule.model.pojo;

import java.io.Serializable;

public class SysSchedule implements Serializable {
    private int sid;
    private int uid;
    private String title;
    private int completed;

    public SysSchedule() {
    }

    public SysSchedule(int uid, String title, int completed) {
        this.uid = uid;
        this.title = title;
        this.completed = completed;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "SysSchedule{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
