package com.ink.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilterTest implements Filter {
//    初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncodingFilterTest执行前");
//        Chain：链
//        执行doFilter让请求继续走，否则请求就会停在filter这里
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncodingFilterTest执行后");
    }


//    销毁
    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }
}
