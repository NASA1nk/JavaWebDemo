package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取下载文件的路径
        String realPath = "C:\\Users\\AW\\Desktop\\JavaWeb\\ResponseDemo\\target\\classes\\1.png";
        System.out.println("下载文件的路径："+realPath);

//        获取下载文件的文件名，需要转义（从最后一个\\开始）
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

//        设置响应头，使得浏览器能够支持下载文件，Content-Disposition指明响应的配置信息，attachment指明包含附件
        resp.setHeader("Content-Disposition","attachment; filename="+fileName);
//        文件名有中文则要使用URLEncoder.encode编码，否则有可能乱码
//        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));

//        获取下载文件的输入流（将文件变成流）
        FileInputStream in = new FileInputStream(realPath);
//        获取outputStream对象，用于输出字符流数据或者二进制的字节流数据
        ServletOutputStream out = resp.getOutputStream();
//        创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
//        将FileInputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
