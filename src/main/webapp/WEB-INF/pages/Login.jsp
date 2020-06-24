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

    <form class="form-horizontal" role="form" method="post" action="./userLogin" style="width:60%;align-content: end">
        <div class="form-group">
            <label for="id">ID或电话号码</label>
            <input type="text" class="form-control" name="id" id="id" placeholder="请输入ID或电话号码">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
        </div>
        <div class="menu-item-radio">
            <label for="doctorRadio">医生</label>
            <input name="role" type="radio" value=0 id="doctorRadio">
            <label for="patientRadio">病人</label><input name="role" type="radio" value=1 id="patientRadio">
            <label for="adminRadio">管理员</label><input name="role" type="radio" value=2 id="adminRadio">
        </div>
        <div class="checkbox">
            <label>
                <input name="savecookie" type="checkbox">保存
            </label>
        </div>

        <button type="submit" class="btn btn-default">提交</button>
    </form>
</body>
</html>
