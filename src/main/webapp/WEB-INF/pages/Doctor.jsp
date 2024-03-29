<%--
  Created by IntelliJ IDEA.
  User: yanghaijia
  Date: 2020/6/24
  Time: 1:37 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>医生管理页面</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">诊室系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">功能 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">修改个人信息</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎您 ${userName}</a></li>
                <li><a href="./logout">安全退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<table class="table table-bordered">
    <thead>
    <tr>
        <c:forEach items="${head}" var="s">
            <th>
                    ${s}
            </th>

        </c:forEach>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${allstaff}" var="s">
        <tr>
        <td>${s.p_id}</td>
        <td>${s.p_name}</td>
        <td>${s.p_tel}</td>
        <td>${s.p_email}</td>
        <td>${s.p_allergic}</td>
        <td>
            <button onclick="edit('${s.p_id}')" class="btn btn-danger">添加处方</button>
        </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>

<script>
    function edit(id) {
        window.location.href="./doctor/a/"+id;
    }
</script>
</html>
