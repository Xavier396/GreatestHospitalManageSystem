<%--
  Created by IntelliJ IDEA.
  User: yanghaijia
  Date: 2020/6/24
  Time: 1:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>管理员后台</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">后台管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="./home">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">功能 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="./admin/staffManager">员工管理</a></li>
                        <li><a href="./admin/userManager">病人信息管理</a></li>
                        <li><a href="./admin/medicineManager">药品管理</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">科室医生一览</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">

            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎您，管理员${userName}</a></li>
                <li><a href="./logout">安全退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<form action="./admin/filter" method="post" class="form-group form-inline" align="center">
    所属科室<select name="depart" class="form-control">
    <option>请选择</option>
    <c:forEach items="${alldepart}" var="c">
        <option value="${c.department}">${c.department}</option>
    </c:forEach>
</select>
    输入关键词搜索:<input type="text" class="form-control" placeholder="Search">
    <button type="submit" class="btn btn-default">搜索</button>

    每页显示<select name="limit" class="form-control">
    <option value=5>5</option>
    <option value=10>10</option>
    <option value=15 selected>15</option>
    <option value=20>20</option>
</select>
</form>
    <button class="btn btn-info" onclick="gotoAddUser()">添加病人信息</button>
    <button class="btn btn-info" onclick="gotoAddStaff()">添加医生信息</button>

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
        <%! int i = 1;%>
        <tr>
            <td><%=i++%>
            </td>
            <td>${s.workerId}</td>
            <td>${s.workerName}</td>
            <td>${s.workerDepartment}</td>
            <td>${s.workerPhone}</td>
            <td>${s.workerEmail}</td>
            <td>${s.workerOtherNote}</td>
            <td>
                <button class="btn btn-danger">删除</button>
                <button class="btn btn-info">修改数据</button>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<script>
    function gotoAddStaff() {
        window.location.href="./admin/addstaff"
    }

    function gotoAddUser() {
        window.location.href="./admin/adduser"
    }
</script>
</body>
</html>
