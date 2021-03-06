package org.example.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.example.db.JDBCUtil;
import org.example.javabean.Book;
import org.example.javabean.Borrow;
import org.example.service.BookService;
import org.example.service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "BorrowHistoryServlet",urlPatterns = "/book/borrow")
public class BorrowHistoryServlet extends HttpServlet {
    private BorrowService borrowService=new BorrowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson= IOUtils.toString(req.getInputStream(),"UTF-8");
        HashMap<String, Object> parseObject =
                JSON.parseObject(paramJson,
                        HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Borrow> borrows = new ArrayList<>();
        int count = 0;
        //2.
        if (param != null) {
            //带参数查询
        } else {
            //无参查询
            borrows =borrowService.searchAllBorrow(pageNum,pageSize);
        }

        count = borrowService.countNum();

        //3. 将结果放入session
        System.out.println("数据的长度：" + borrows.size());
        req.getSession().setAttribute("borrows", borrows);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}
