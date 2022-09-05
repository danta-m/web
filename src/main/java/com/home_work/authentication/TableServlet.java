package com.home_work.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/*
GET /table/{tableName} - return content of file/table
DELETE /table/{tableName} - deletes file
PUT /table/{tableName} - update existing file
POST /table/{tableName} - creates new file
 */
@WebServlet(name = "tableServlet", value = "/tables/*")
public class TableServlet extends HttpServlet {

    String direction = "/home/dana/Documents/projects/hw/web/src/main/java/com/home_work/authentication/db";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("tableServlet.doGet");

        String pathInfo = req.getPathInfo();
        out.println(pathInfo);

        try (BufferedReader reader = new BufferedReader(new FileReader(direction + pathInfo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("TableServlet.doPost");

        String dir = req.getPathInfo();
        out.println(dir);

        File newFile = new File(direction + dir);
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        out.println(newFile.getAbsolutePath());
        out.println(newFile.getName() + " successfully created");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("TableServlet.doPut");

        String pathInfo = req.getPathInfo();
        out.println(pathInfo);

        File updatingFile = new File(direction + pathInfo);
            Writer output;
            output = new BufferedWriter(new FileWriter(updatingFile, true));
            output.write("new information + \n");
            output.close();
            out.println(updatingFile.getName() + " successfully updated");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("TableServlet.doDelete");

        String pathInfo = req.getPathInfo();
        out.println(pathInfo);

        File deleteFile = new File(direction + pathInfo);
        if(deleteFile.exists()) {
            deleteFile.delete();
            out.println(deleteFile.getName() + " successfully deleted");
        }
    }
}
