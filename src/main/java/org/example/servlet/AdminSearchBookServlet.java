package org.example.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.example.javabean.Book;
import org.example.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AdminSearchBookServlet", urlPatterns = "/admin/book/search")
public class AdminSearchBookServlet extends HttpServlet {
    private BookService bookService = new BookService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 取参（req当前的页码, 每页的数量, 搜索）
        String paramJson = IOUtils.toString(
                req.getInputStream(), "UTF-8");
        HashMap<String, Object> parseObject =
                JSON.parseObject(paramJson,
                        HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Book> books = new ArrayList<>();
        int count = 0;
        //2.
        if (param != null) {
            //带参数查询
        } else {
            //无参查询
            books = bookService.searchAllBooks(pageNum,
                    pageSize);
            System.out.println(books);
        }

        count = bookService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("books", books);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}
