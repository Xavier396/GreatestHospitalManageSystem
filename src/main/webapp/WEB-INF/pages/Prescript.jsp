<%--
  Created by IntelliJ IDEA.
  User: yhjzs
  Date: 2020/6/30
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加处方</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form method="post" action="/GreatestHospitalManageSystem_war_exploded/doctor/add">
    <label>处方内容<br/>
        <textarea name="context" rows="10"></textarea>
    </label>
    <input type="hidden" name="id" value="${id}">

    <input type="submit" title="提交">
    <input type="reset" title="重置">
</form>
</body>
</html>
