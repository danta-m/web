package com.home_work.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListTablesServlet", value = "/tables")
public class ListTablesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        File folder = new File("/home/dana/Documents/projects/hw/web/src/main/java/com/home_work/authentication/db");

        PrintWriter out = resp.getWriter();

        out.println("Hello from ListTablesServlet");
        List<String> filesList = new ArrayList<>();

        for (File file : folder.listFiles()) {
            filesList.add(file.getName());
            out.println("<h1>" + file.getName() + "<h1>");
        }
    }
}
