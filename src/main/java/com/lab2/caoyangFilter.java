package com.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class caoyangFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("caoyangFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("caoyangFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
