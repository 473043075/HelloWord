package org.example.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "AdminFilter",urlPatterns = "/login")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String role=servletRequest.getParameter("role");
        if ("0".equals(role)){
           servletRequest.getRequestDispatcher("/admin/login").forward(servletRequest,servletResponse);
        }else {
            servletRequest.getRequestDispatcher("/login").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }


}
