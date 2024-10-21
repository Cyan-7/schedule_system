package com.MyProject.schedule.controller.servlet;

import com.MyProject.schedule.common.Result;
import com.MyProject.schedule.common.ResultCodeEnum;
import com.MyProject.schedule.model.pojo.HomeworkUser;
import com.MyProject.schedule.model.pojo.SysUser;
import com.MyProject.schedule.model.service.impl.SysUserServiceImpl;
import com.MyProject.schedule.util.MD5Util;
import com.MyProject.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    SysUserServiceImpl userService = new SysUserServiceImpl();

    //前端作业访问的方法
    protected void homework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求成功");
        //WebUtil 为自定义的工具类，内含读取和输出 JSON 的方法
        HomeworkUser homeworkUser = WebUtil.readJson(req, HomeworkUser.class);

        System.out.println(homeworkUser);
    }

    /*
    * 业务处理接口
    * */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);

        int row =  userService.register(sysUser);

        Result result = null;
        if (row > 0){
            result = Result.ok(null);
        }else {
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);

        SysUser metaObj = userService.findByUsernam(sysUser.getUserName());

        Result result = null;
        if (metaObj == null){
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        } else if (MD5Util.encrypt(sysUser.getUserPwd()).equals(metaObj.getUserPwd())){
            result = Result.ok(null);
        }else {
            result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }

        WebUtil.writeJson(resp,result);
    }

    protected void checkUserUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");

        SysUser user = userService.findByUsernam(username);

        Result result = Result.ok(null);
        if (user != null){
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);
    }

    protected void loginHomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeworkUser homeworkUser = WebUtil.readJson(req, HomeworkUser.class);

        HomeworkUser metaObj = new HomeworkUser("2307200337","谢宇轩","学生");

        Result result = null;
        if (!metaObj.getUserName().equals(homeworkUser.getUserName())){
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        } else if (!metaObj.getUserAge().equals(homeworkUser.getUserAge())){
            result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }else {
            result = Result.ok(null);
        }

        WebUtil.writeJson(resp,result);
    }

}
