package com.MyProject.schedule.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 增加  /schedule/add
* 查询  /schedule/query
* 修改  /schedule/update
* 删除  /schedule/remove
* ......
* */

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("add successfully");
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("query successfully");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("update successfully");
    }
    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("remove successfully");
    }
}
