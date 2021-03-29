package org.example.servlet;

import org.example.service.loginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private loginService loginService=new loginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        String result= loginService.login(username,password,req.getSession());
        if ("1".equals(result)){
            resp.sendRedirect("/admin/main.jsp");
            req.getSession().setAttribute("isLogin",true);
        }else {
            req.getRequestDispatcher("/index.jsp?massage="+result).forward(req,resp );
        }
    }
}
