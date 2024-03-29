<%--
  Created by IntelliJ IDEA.
  User: yhjzs
  Date: 2020/6/28
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>添加医生</title>
</head>
<body>
<h1>医生添加系统</h1>
<div class="container">

    <form method="post" class="form-group" action="./savestaff" align="center">
        <label>
            用户名
            <input name="worker_name" type="text" class="form-control">
        </label>
        <br/>
        <label>
            生日
            <input type="date" name="worker_birthday" class="form-control">
        </label>
        <br/>
        <label>
            电话
            <input type="text" name="worker_phone" class="form-control">
        </label>
        <br/>
        <label>
            邮箱
            <input type="email" name="worker_email" class="form-control">
        </label>
        <br/>
        <label>
            部门
            <select name="worker_department" class="form-control">
                <option>请选择</option>
                <c:forEach items="${allDepart}" var="c">
                    <option value="${c.department}">${c.department}</option>
                </c:forEach>
            </select>
        </label>
        <br/>
        <label>

            备注
            <textarea name="worker_other_note" rows="5" class="form-control"></textarea>
        </label>
        <br/>
        <input class="btn btn-default" type="submit" title="提交">
        <input class="btn btn-danger" type="reset" title="重置">
    </form>
    <!--todo 添加医生表单-->
</div>
</body>
</html>
