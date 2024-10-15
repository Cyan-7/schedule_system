package com.MyProject.schedule.model.dao.impl;

import com.MyProject.schedule.model.dao.BaseDao;
import com.MyProject.schedule.model.dao.SysScheduleDao;
import com.MyProject.schedule.model.pojo.SysSchedule;

import java.util.List;

public class SysScheduleImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule schedule) throws Exception {
        String sql = "insert into sys_schedule (uid,title,completed) values (?,?,?)";
        int update = executeUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
        return update;
    }

    @Override
    public int deleteScheduleBySid(int sid) throws Exception {
        String sql = "delete from sys_schedule where sid = ?";
        int update = executeUpdate(sql, sid);
        return update;
    }

    @Override
    public List<SysSchedule> queryScheduleAll() throws Exception {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> list = executeQuery(SysSchedule.class, sql);
        return list;
    }

    @Override
    public SysSchedule queryScheduleAllBySid(int sid) throws Exception {
        String sql = "select sid,uid,title,completed from sys_schedule where sid = ?";
        SysSchedule sysSchedule = executeQueryBean(SysSchedule.class, sql, sid);
        return sysSchedule;
    }
}
