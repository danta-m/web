package com.home_work.authentication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("1. LoginFilter.doFilter");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        boolean isLoggedIn = session.getAttribute("user") != null;
        PrintWriter out = response.getWriter();

         if (isLoggedIn) {
             out.println("success");
             filterChain.doFilter(request, response);
         } else {
             HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
//             out.println(HttpServletResponse.SC_FORBIDDEN); //not working
             out.println("something wrong");
             out.println(session.getServletContext());

         }
    }

    public void destroy() {}
}
