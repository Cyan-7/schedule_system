package com.MyProject.schedule.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断请求增删改查
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];

        Class aClass = this.getClass();
        try {
            //反射获取对应名的方法
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //爆破访问权限
            declaredMethod.setAccessible(true);
            //调用
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
