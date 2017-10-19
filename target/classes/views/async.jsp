<%--
  Created by IntelliJ IDEA.
  User: hq
  Date: 17/10/19
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="/assets/js/jquery-3.2.1.js"></script>
    <script>
        deferred();
        function deferred() {
            $.get('defer', function (data) {
                console.log(data);
                deferred();
            })
        }
    </script>
</body>
</html>
