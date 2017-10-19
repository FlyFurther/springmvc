<%--
  Created by IntelliJ IDEA.
  User: hq
  Date: 17/10/18
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="请求">
    <script src="/assets/js/jquery-3.2.1.js" type="application/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url: "converter",
                data: "1-huangq",
                type: "post",
                contentType: "application/x-wisely",
                success: function(data) {
                    $("#resp").html(data);
                }
            });
        }
    </script>
</body>
</html>
