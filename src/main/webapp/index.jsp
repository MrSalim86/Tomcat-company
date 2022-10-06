<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - huskeappen</title>
</head>
<body>
<h1><%= "velkommen til din online huskesedel!" %>
</h1>
<br/>


<h1>Login for eksistende brugere</h1>

${requestScope.loginbesked}

<form action="LoginServlet" method="get">
    <label for="navn">Navn:</label><br>
    <input type="text" id="navn" name="navn" value="John"><br>
    <label for="kode">indtask kode:</label><br>
    <input type="text" id="kode" name="kode" value="Doe"><br><br>
    <input type="submit" value="login">
</form>

<h1>eller opret dig som brugere</h1>

${requestScope.besked}

<form action="LoginServlet" method="post">
    <label for="OpretNavn">Navn:</label><br>
    <input type="text" id="OpretNavn" name="OpretNavn" value=""><br>
    <label for="kode1">angiv kode</label><br>
    <input type="text" id="kode1" name="kode1" value=""><br><br>
    <label for="kode2">skriv koden igen</label><br>
    <input type="text" id="kode2" name="kode2" value=""><br><br>
    <input type="submit" value="opret">
</form>

<form action="/action_page.php">

    <input type="submit" value="Submit">
</form>
</body>
</html>