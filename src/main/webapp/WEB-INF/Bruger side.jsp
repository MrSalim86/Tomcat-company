<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 10/4/2022
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bruger side</title>
</head>
<body>
<h1> Velkommen til din brugerside ${requestScope.navn}</h1>

dit sessionId er ${requestScope.sessionId}

<br>
llbongbong<br>
<br>


<form action="TilføjEmneServlet">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" value="Ølbong"><br>

    <input type="submit" value="tilføj">
</form>

du har nu tilføjer ${sessionScope.antal} emner til din liste
<br>

de tilføjede emner er følgende ${sessionScope.emneListe}

<br>
<br>
<br>



<form action="logudServlet">

    <input type="submit" value="log af">
</form>

</body>
</html>
