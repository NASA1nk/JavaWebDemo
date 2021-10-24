package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type", "text/html; charset=UTF-8");
//        获取Session
        HttpSession session = req.getSession();
//        在Session中存储信息
        session.setAttribute("name","郑吒");
//        获取Session ID
        String id = session.getId();
        if(session.isNew()){
            resp.getWriter().write("Session创建成功 "+ id);
        }
        else{
            resp.getWriter().write("Session已经存在 "+ id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
