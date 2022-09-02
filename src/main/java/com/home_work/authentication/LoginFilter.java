package com.home_work.authentication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Hello from: " + getClass().getName());
        this.config = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("1. LoginFilter.doFilter");

        HttpSession session = ((HttpServletRequest) request).getSession();
        ServletContext context = config.getServletContext();
        if (((HttpServletRequest) request).getSession().getAttribute("name")==null) {
            session.setAttribute("logged-in", "no");
        } else {
            context.log("log-in status: " + session.getAttribute("logged-in"));
            filterChain.doFilter(request, response);

        }
    }

    public void destroy() {}
}
