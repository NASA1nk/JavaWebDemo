package com.ink.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class ListenerTest implements HttpSessionListener {
//    一旦创建Session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        获取ServletContex
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println(se.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if(onlineCount == null){
            onlineCount = 1;
        }
        else{
            onlineCount++;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }

//    一旦销毁Session就会触发一次这个事件
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount = 0;
        }
        else{
            onlineCount--;
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
