package com.home_work.authentication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("1. LoginFilter.doFilter");

        HttpSession session = ((HttpServletRequest) request).getSession(false);

        boolean isLoggedIn = session.getAttribute("user") != null;
        PrintWriter out = response.getWriter();
        out.println(session.getServletContext());

         if (isLoggedIn) {
             out.println("success");
             filterChain.doFilter(request, response);
         } else {
             out.println(HttpServletResponse.SC_FORBIDDEN); //not working
         }
    }

    public void destroy() {}
}
