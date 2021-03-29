package org.example.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String role=(String) servletRequest.getAttribute("role");
        if ("admin".equals(role)){
            ((HttpServletRequest)servletRequest).getRequestDispatcher("admin/login.jsp").forward(servletRequest,servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect("main.jsp");
        }
    }
}
