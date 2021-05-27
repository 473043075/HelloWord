package org.example.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.example.javabean.Favorite;
import org.example.service.FavoriteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "FavoriteListServlet",urlPatterns = "/book/favoritelist")
public class FavoriteListServlet extends HttpServlet {
    private FavoriteService favoriteService=new FavoriteService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramJson= IOUtils.toString(req.getInputStream(),"UTF-8");
        HashMap<String, Object> parseObject =
                JSON.parseObject(paramJson,
                        HashMap.class);
        String param = (String) parseObject.get("search");
        int pageNum = (int) parseObject.get("pageNum");
        int pageSize = (int) parseObject.get("pageSize");
        List<Favorite> favorites=new ArrayList<>();
        int count = 0;
        //2.
        if (param != null) {
            //带参数查询
        } else {
            //无参查询
            favorites =favoriteService.searchAllBorrow(pageNum,pageSize);
        }

        count = favoriteService.countNum();

        //3. 将结果放入session
        req.getSession().setAttribute("favorites", favorites);
        //将count直接作为ajax请求的结果返回
        resp.getWriter().print(count);
    }
}
