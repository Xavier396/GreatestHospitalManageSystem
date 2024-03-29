<%--
  Created by IntelliJ IDEA.
  User: yhjzs
  Date: 2020/6/28
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>添加患者</title>
</head>
<body>
<h1 align="center">病人信息添加</h1>

<form action="./saveuser" class="form-group" align="center" method="post">
    <label>
        用户名
        <input name="name" type="text" class="form-control">
    </label>
    <br/>
    <label>
        生日
        <input type="date" name="birthday" class="form-control">
    </label>
    <br/>
    <label>
        其他注意事项
        <textarea name="allergic" rows="5"></textarea>
    </label>
    <br/>
    <label>
        电话
        <input type="text" name="phone" class="form-control">
    </label>
    <br/>
    <label>
        邮箱
        <input type="email" name="email" class="form-control">
    </label>
    <br/>
    <label>
        所属科室
        <select name="depart" class="form-control">
            <option>请选择</option>
            <c:forEach items="${alldepart}" var="c">
                <option value="${c.department}">${c.department}</option>
            </c:forEach>
        </select>
    </label>
    <br/>
    <input type="submit" class="btn btn-default" title="提交">
    <input type="reset" class="btn btn-danger" title="重置">
</form>


</body>
</html>
