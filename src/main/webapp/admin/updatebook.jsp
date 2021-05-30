<%--
  Created by IntelliJ IDEA.
  User: 小豆芽
  Date: 2021/5/30
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改图书</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css"
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
            <th>书名</th>
            <th>作者</th>
            <th>分类</th>
            <th>描述</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${sessionScope.books}"
                   varStatus="status">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.sort}</td>
                <td class="wrap-td">
                    <div class="wrap-div">${book.description}</div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">书名</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="update">修改</button>
        </div>
    </div>
</form>
<div id="page" style="display: flex;justify-content: center;"></div>
</body>
<script src="../layui/layui.js" charset="utf-8"></script>
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
                    url: "/admin/book/search",
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
