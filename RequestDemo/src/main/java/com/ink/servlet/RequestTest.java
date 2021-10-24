package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        后台接收中文乱码问题，设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
//        获取单个请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        获取多个请求参数
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("=============================");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("=============================");

        System.out.println(req.getContextPath());
//        通过请求转发
//        /代表当前的web应用
        req.getRequestDispatcher("success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
