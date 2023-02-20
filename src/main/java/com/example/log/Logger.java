package com.example.log;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

@WebFilter(urlPatterns = {"/login"},initParams = {
        @WebInitParam(name = "count",value = "0")
})
public class Logger implements Filter
{
    private  int count;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

        count = Integer.valueOf(filterConfig.getInitParameter("count"));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         count++;
        System.out.println(count);
        chain.doFilter(request,response);
    }
}
