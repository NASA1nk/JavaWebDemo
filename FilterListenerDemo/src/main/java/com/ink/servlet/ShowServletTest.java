package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ShowServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        让servlet用uft-8转码，而不是用默认的ISO8859
        //        resp.setCharacterEncoding("utf-8");
        //        让浏览器用utf-8来解析返回的数据
//        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.getWriter().write("中文直接展示，会乱码");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
