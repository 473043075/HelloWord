<%--
  Created by IntelliJ IDEA.
  User: 小豆芽
  Date: 2021/3/22
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message=request.getParameter("message");
    if (message!=null&&!message.equals(""))
%>
</body>
<script src="./layui/layer.all.js"></script>
<script>
    layer.msg("<%=message%>");
</script>
</html>
