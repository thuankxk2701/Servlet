package com.example.learnservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "Welcome",urlPatterns = "/welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        String name= "";
        Cookie[] cookies = req.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("username")){
                name = c.getValue();
            }
        }
        if(name.equals("")){
            resp.sendRedirect("/login");
        }
        out.println("welcome " + name);

    }

}
