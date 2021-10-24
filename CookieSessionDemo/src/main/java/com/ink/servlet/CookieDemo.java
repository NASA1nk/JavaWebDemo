package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        中文乱码问题，设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("gbk");
        resp.setHeader("content-type", "text/html; charset=UTF-8");
//        获取请求中携带的cookie
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            resp.getWriter().write("这是第一次访问！");
        }
        else{
            PrintWriter writer = resp.getWriter();
            for (int i = 0; i < cookies.length; i++) {
                if("lastTime".equals(cookies[i].getName())){
                    String value = cookies[i].getValue();
//                格式化时间
                    long timevalue = Long.parseLong(value);
                    Date date = new Date(timevalue);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                    String format = simpleDateFormat.format(date);
                    writer.println("上次登录时间为："+format);
                }
            }
        }

//        服务器响应给客户端一个cookie
        Cookie cookie = new Cookie("lastTime",System.currentTimeMillis()+"");
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
