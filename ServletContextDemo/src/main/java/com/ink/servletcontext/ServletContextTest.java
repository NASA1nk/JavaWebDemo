package com.ink.servletcontext;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletContextTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Servlet初始化参数
//        this.getInitParameter()
//        Servlet配置
//        this.getServletConfig()
//        Servlet上下文
        ServletContext servletContext = this.getServletContext();
        String username = "ink";
//        将一个数据保存在了ServletContext中
        servletContext.setAttribute("username",username);
        System.out.println("hello");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
