package com.MyProject.schedule.model.dao;

import com.MyProject.schedule.model.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    int addSchedule(SysSchedule schedule) throws Exception;
    int deleteScheduleBySid(int sid) throws Exception;
    List<SysSchedule> queryScheduleAll() throws Exception;
    SysSchedule queryScheduleAllBySid(int sid) throws Exception;
}
