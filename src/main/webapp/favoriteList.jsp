<%--
  Created by IntelliJ IDEA.
  User: 小豆芽
  Date: 2021/4/12
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书收藏</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"
          media="all">
</head>
<body>
<div class="layui-nav-item demoTable"
     style="display: flex;justify-content: flex-end;">
    <input type="text" class="layui-input"
           style="padding: 0;display: inline;width: 300px;"
           placeholder="请输入搜索信息..."/>
    <button class="layui-btn" data-type="getCheckLength"
            style="margin-left: 20px;">搜索
    </button>
</div>

<div class="layui-form" id="content">
    <table class="layui-table" style="table-layout:fixed">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
            <col width="180">
        </colgroup>
        <thead>
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>分类</th>
            <th>描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="favorites" items="${sessionScope.favorites}"
                   varStatus="status">
            <tr>
                <td>${favorites.favorite_id}</td>
                <td>${favorites.name}</td>
                <td>${favorites.author}</td>
                <td>${favorites.sort}</td>
                <td class="wrap-td">
                    <div class="wrap-div">${favorites.description}</div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div id="page" style="display: flex;justify-content: center;"></div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['laypage', 'layer','element'], function () {
            var laypage = layui.laypage
                , layer = layui.layer
                ,elment=layui.element;
            var $ = layui.$;
            var count = 0, current = 1, limit = 5;
            $(document).ready(function () {
                //进入页面先加载数据
                getContent(1, limit);
                //得到数量count后，渲染表格
                laypage.render({
                    elem: 'page',
                    count: count,
                    curr: current,
                    limits: [5, 10, 15, 20],
                    limit: limit,
                    layout: ['count', 'prev', 'page', 'next', 'limit'],
                    jump: function (obj, first) {
                        if (!first) {
                            getContent(obj.curr, obj.limit);
                            //更新当前页码和当前每页显示条数
                            current = obj.curr;
                            limit = obj.limit;
                        }
                    }
                });
            });

            function getContent(page, size) {
                $.ajax({
                    type: 'POST',
                    url: "/book/favoritelist",
                    async: false, //开启同步请求，为了保证先得到count再渲染表格
                    data: JSON.stringify({
                        pageNum: page,
                        pageSize: size
                    }),
                    contentType: "application/json;charset=utf-8",
                    success: function (data) {
                        $('#content').load(location.href + " #content");
                        //count从Servlet中得到
                        count = data;
                    }
                });
            }
        }
    );
</script>
</html>
