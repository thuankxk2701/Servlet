package com.example.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Session2", urlPatterns = {"/session2"})
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String name = "";

        HttpSession  httpSession= req.getSession();

        Object obj = httpSession.getAttribute("name");

        if(obj != null){
            name =String.valueOf(obj);
        }else{
            resp.sendRedirect("/session1");
        }
        out.println("Hello "+ name);
    }
}
