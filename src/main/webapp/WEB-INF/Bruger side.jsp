<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 10/4/2022
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bruger side</title>
</head>
<body>

<form action="AdminServlet">

    <input type="submit" value="Admin">

</form>


<h1> Velkommen til din brugerside ${sessionScope.bruger.navn}</h1>


dit sessionId er ${sessionScope.sessionId}
<br>
activ er sat til ${sessionScope.bruger.active}
<br>




<br>
<br>
<br>


<form action="TilEmneServlet">
    <label for="emne">Emne:</label><br>
    <input type="text" id="emne" name="emne" value="Ølbong"><br>
    <input type="submit" value="tilføj">
</form>

du har nu tilføjer ${sessionScope.antal} emner til din liste
<br>

<h1>Requeste</h1>
<br>
(requste : )de tilføjede emner er følgende ${requestScope.emneListRe}

<br>
<br>
<br>
<h1>Sessionscope</h1>
(Session : )de tilføjede emner er følgende ${sessionScope.emneListe}
<br>
<br>
<h1>Contekst</h1>



her udskriver jeg listen via jstl:
<br>

<c:forEach items="${sessionScope.emneListe}" var="emne">

    ${emne}
    <br>


</c:forEach>


Her kan du se alle tilføjelser !


<h1>Contekst</h1>
<c:forEach items="${applicationScope.stringSetContext}" var="emne">

    ${emne}
    <br>


</c:forEach>

<br>
<br>
<br>
<br>


<form action="logudServlet">

    <input type="submit" value="log af">
</form>

</body>
</html>
