package com.example.learnservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        out.println("<form action='/login' method='post'> ");
        out.println("Username: <input type='text' name = 'username'/> ");
        out.println("Password <input type='password' name = 'password'/> ");
        out.println("<input type='submit' value = 'login'/>  ");
        out.println("</form>  ");
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");

      String username = req.getParameter("username");
      String password = req.getParameter("password");
        System.out.println(username+password);

      if(username.equals("thuan") && password.equals("1234")){
          Cookie cookie =new Cookie("username",username);
          cookie.setMaxAge(30);
          resp.addCookie(cookie);
          resp.sendRedirect("/welcome");
      }else{
          resp.sendRedirect("/login");
      }

    }
}
