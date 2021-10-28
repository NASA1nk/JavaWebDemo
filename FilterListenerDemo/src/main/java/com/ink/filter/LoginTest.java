package com.ink.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取参数
        String username = req.getParameter("username");
        if("admin".equals(username)){
//            登陆成功，存入用户信息到session，用于判断
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
//            重定向到主页
            resp.sendRedirect("/sys/success.jsp");
        }
        else{
//            登陆失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
