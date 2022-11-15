package org.zgg.springboot_web_02.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns={"/css/*","/images/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 只有访问 "/css/*","/images/*"  才会打印这些日志
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter 工作");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
