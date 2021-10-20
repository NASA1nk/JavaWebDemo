package com.ink.servletcontext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletForwardTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();

        System.out.println("进入了ServletForwardTest");
//        转发的请求路径
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/getcontext");
//        调用forward实现请求转发
        requestDispatcher.forward(req,resp);
//        servletContext.getRequestDispatcher("/getcontext").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
