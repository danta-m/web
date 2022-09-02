package com.home_work.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "table/{tableName}", value = "/table/{tableName}")
public class ListTablesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Login");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Success</h1>");
        out.println("</body></html>");
    }
}
