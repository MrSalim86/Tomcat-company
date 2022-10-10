<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 10/9/2022
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Velkommen til adminsiden</h1>

 ${requestScope.besked}

<form action="AdminServlet" method="post">
    <label for="fname">angiv navn på bruger der skal sættes til inactiv</label><br>
    <input type="text" id="fname" name="navn" value="John"><br>

    <input type="submit" value="inactiver">
</form>

</body>
</html>
