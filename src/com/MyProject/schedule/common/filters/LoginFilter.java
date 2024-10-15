package com.MyProject.schedule.common.filters;

import com.MyProject.schedule.model.pojo.SysUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/view/showSchedule.html", "/schedule/*"})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();

        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        if (sysUser == null){
            response.sendRedirect("/view/login.html");
        }else {
            chain.doFilter(request,response);
        }
    }
}
