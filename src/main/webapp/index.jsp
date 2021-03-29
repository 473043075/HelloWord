<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layui</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <%@ page contentType="text/html;charset=UTF-8" language="java"%>
</head>
<body>
<%@include file="window.jsp"%>

<div style="width: 60%;margin-top: 16%;margin-left: 30%">
<div style="twidth: 60%;margin: 0 auto">
<form class="layui-form" action="/login" method="post" >
    <div class="layui-form-item">
        <label class="layui-form-label">用户名：</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码框：</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" >
        <div class="layui-input-block" style="margin-left: 0">
            <input type="radio" name="role" value="0"
                   title="管理员">
            <input type="radio" name="role" value="1"
                   title="用户" checked>
            <button class="layui-btn" lay-submit lay-filter="*">登陆</button>
            <button type="reset" class="layui-btn layui-btn-primary">取消</button>

        </div>
    </div>
</form>
</div>
</div>
<script>
    layui.use('form', function () {
        var form = layui.form;
        //各种基于事件的操作，下面会有进一步介绍
        form.on('switch(filter)', function(data){
            if(data.elem.check){
                <%request.getSession().setAttribute("role","admin");%>
            }else {
                <%request.getSession().setAttribute("role","user");%>
            }
        });
    });
</script>
</body>
</html>