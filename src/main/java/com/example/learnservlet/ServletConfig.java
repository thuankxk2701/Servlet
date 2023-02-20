package com.example.learnservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Config Servlet",urlPatterns = "/config-servlet", initParams = {
        @WebInitParam(name="name",value = "test")
})
public class ServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = super.getServletConfig().getInitParameter("name");

        resp.setContentType("text/html");
        PrintWriter  out = resp.getWriter();
        out.println("Get config in the Servlet " + name);

    }
}
