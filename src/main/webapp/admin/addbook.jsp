<%--
  Created by IntelliJ IDEA.
  User: 小豆芽
  Date: 2021/5/30
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css"
          media="all">
</head>
<body>
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
        <label class="layui-form-label">图书馆名称</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入图书馆名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书馆说明</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入图书馆说明" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">分类</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入分类" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">分类说明</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入分类说明" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">位置</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入位置" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入状态" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书说明</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" placeholder="请输入图书说明" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
