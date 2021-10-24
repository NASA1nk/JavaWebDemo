<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    获取项目路径--%>
<%--    以post的方式提交表单--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        username <input name="username" type="text"> <br>
        password: <input name="password" type="password"> <br>
        hobbies:
        <input name="hobbies" type="checkbox" value="女孩">女孩
        <input name="hobbies" type="checkbox" value="代码">代码
        <input name="hobbies" type="checkbox" value="电影">电影
        <input name="hobbies" type="checkbox" value="爬山">爬山
        <input type="submit">
    </form>
</body>
</html>
