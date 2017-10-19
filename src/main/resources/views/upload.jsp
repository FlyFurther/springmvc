<%--
  Created by IntelliJ IDEA.
  User: hq
  Date: 17/10/17
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <div class="upload">
        <form action="/upload" enctype="multipart/form-data" method="post">
            <input type="file" name="file"/>
            <input type="submit" name="上传"/>
        </form>
    </div>
</body>
</html>
