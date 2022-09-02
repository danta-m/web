package com.home_work.authentication;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String json = getBody(req);
        System.out.println(json);
        session.setAttribute("name", req.getParameter("name"));

        PrintWriter out = resp.getWriter();
        out.println("<h1>Success from PostLogin</h1>");

        Gson gson = new Gson();
        Map<String, UserAccount> userMap = gson.fromJson(json, Map.class);
        System.out.println(userMap);

        session.setAttribute("user", userMap);
    }
    public static String getBody(HttpServletRequest request) {
        StringBuilder bodyBuilder = new StringBuilder();
        try (InputStream inputStream = request.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                bodyBuilder.append(charBuffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            System.err.println("Cannot read body");
        }
        return bodyBuilder.toString();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(true);
//        session.setAttribute("name", req.getParameter("name"));
//
//        System.out.println("Login");
//
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Success</h1>");
//        out.println("</body></html>");

    }
}
