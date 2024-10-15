package com.MyProject.schedule;

import com.MyProject.schedule.model.dao.impl.SysScheduleImpl;
import com.MyProject.schedule.model.dao.impl.SysUserImpl;
import com.MyProject.schedule.model.pojo.SysSchedule;
import com.MyProject.schedule.model.pojo.SysUser;
import com.MyProject.schedule.util.JDBCUtil;
import com.MyProject.schedule.util.MD5Util;
import org.junit.Test;
import com.MyProject.schedule.common.ResultCodeEnum;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class test {

    @Test
    public void test1() {
        SysSchedule sysSchedule = new SysSchedule();
        System.out.println(sysSchedule.getUid());
    }

    @Test
    public void test2() throws SQLException {
        JDBCUtil util = new JDBCUtil();
        Connection connection = util.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test3() throws Exception {
        SysSchedule sysSchedule = new SysSchedule(1, "完成日程管理项目", 1);
        SysScheduleImpl sysSchedule1 = new SysScheduleImpl();
        int update = sysSchedule1.addSchedule(sysSchedule);
        System.out.println(update);
        System.out.println(sysSchedule);
    }

    @Test
    public void test4() throws Exception {
        SysScheduleImpl sysSchedule1 = new SysScheduleImpl();
        int update = sysSchedule1.deleteScheduleBySid(8);
        System.out.println(update);
    }

    @Test
    public void test5() throws Exception {
        SysScheduleImpl sysSchedule1 = new SysScheduleImpl();
        List<SysSchedule> list = sysSchedule1.queryScheduleAll();
        for (SysSchedule sysSchedule : list) {
            System.out.println(sysSchedule);
        }
    }

    @Test
    public void test6() throws Exception {
        SysScheduleImpl sysSchedule1 = new SysScheduleImpl();
        SysSchedule sysSchedule = sysSchedule1.queryScheduleAllBySid(5);
        System.out.println(sysSchedule);
    }

    @Test
    public void addUser() throws Exception {
        SysUser sysUser = new SysUser("123456", "5678910");
        SysUserImpl sysUserIpm = new SysUserImpl();
        sysUserIpm.deleteUserByUid(15);
        sysUserIpm.deleteUserByUid(16);
        sysUserIpm.deleteUserByUid(18);
        sysUserIpm.deleteUserByUid(19);
        sysUserIpm.deleteUserByUid(20);
    }

    @Test
    public void test8() {
        String encrypt = MD5Util.encrypt("2494374494");
        System.out.println(encrypt);
    }

    @Test
    public void test9() {
        // 因为价格精确到分，所以我们将价格扩大 100 倍转化为整数进行处理，7.11 美元等于 711 美分
        for (int i = 1; i < 711; i++) {
            for (int j = 1; j < 711 - i; j++) {
                for (int k = 1; k < 711 - i - j; k++) {
                    // 根据前面三个价格计算出第四个价格
                    int l = 711 - i - j - k;
                    // 判断相乘结果是否为 711000000（7.11 * 100 * 100 * 100 * 100）
                    if (i * j * k * l == 711000000) {
                        // 输出这四个价格（需转化回美元形式，即除以 100）
                        System.out.println("价格: $" + (i / 100.0) + ", $" + (j / 100.0)
                                + ", $" + (k / 100.0) + ", $" + (l / 100.0));
                    }
                }
            }
        }
    }

    @Test
    public void test10() {

    }
}





