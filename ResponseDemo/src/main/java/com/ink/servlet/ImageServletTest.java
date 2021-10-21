package com.ink.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        让浏览器3秒自动刷新一次;
//        resp.setHeader("refresh","3");

//        使用图片类在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,40,BufferedImage.TYPE_INT_RGB);
//        创建一个笔
        Graphics2D g = (Graphics2D) image.getGraphics();
//        用笔设置图片的背景颜色
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
//        用笔给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

//        告诉浏览器，这个响应以图片的方式打开
        resp.setContentType("image/png");
//        不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

//        将图片响应给浏览器
        ImageIO.write(image,"png", resp.getOutputStream());
    }

//    生成随机数
    private String makeNum(){
        Random random = new Random();
//        生成7位的随机数
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
//        如果不足7位，用0填充
        for (int i = 0; i < 7-num.length() ; i++) {
            sb.append("0");
        }
        num = sb.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
