package org.example.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.example.javabean.Book;
import org.example.javabean.BorrowList;
import org.example.service.BorrowListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "BorrowListServlet",urlPatterns = "/book/borrowlist")
public class BorrowListServlet extends HttpServlet {
    private BorrowListService borrowListService=new BorrowListService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson= IOUtils.toString(req.getInputStream(),"UTF-8");
        HashMap<String, Object> parseObject =
                JSON.parseObject(paramJson,
                        HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<BorrowList> borrowLists = new ArrayList<>();
        int count = 0;
        //2.
        if (param != null) {
            //带参数查询
        } else {
            //无参查询
            borrowLists =borrowListService.searchAllBorrowList(pageNum,pageSize);
        }

        count = borrowListService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("borrowLists", borrowLists);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}
