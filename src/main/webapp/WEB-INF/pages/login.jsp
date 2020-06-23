<%--
  Created by IntelliJ IDEA.
  User: yanghaijia
  Date: 2020/6/23
  Time: 3:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body class="container">
<div class="jumbotron">
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <label class="sr-only" for="name">名称</label>
            <input type="text" class="form-control" id="name" placeholder="请输入名称">
        </div>
        <div class="form-group">
            <label class="sr-only" for="inputfile">文件输入</label>
            <input type="file" id="inputfile">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox">请打勾
            </label>
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
</body>
</html>
