package com.example.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Session1" ,urlPatterns = {"/session1"})
public class Session1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        httpSession.setAttribute("name","thuan");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("Welcome to lecture session");
    }
}
