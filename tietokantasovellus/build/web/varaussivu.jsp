<%-- 
    Document   : varaussivu
    Created on : Dec 6, 2014, 2:36:20 PM
    Author     : Marianne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fi">
    <head>
        <title>Varaussivu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <h1>MediHome</h1>
            <p>Käyttäjä: ${kayttaja}</p>
            <div class="container">
                <div>
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="../tietokantasovellus/omasivu">Omat tiedot</a></li>
                        <li class="active"><a href="../tietokantasovellus/varaussivu">Varaa aika</a></li>
                    </ul>
                </div>  
            </div>

            <div> <h3>Varaussivu</h3>
                <form action="varaussivu" method="POST">
                <h4>Valitse lääkäri</h4>
                <select name="laakari">
                <c:forEach var="laakari" items="${laakarit}">
                    <option value="${laakari.kayttaja_id}"><c:out value="${laakari.nimi}"/></option>
                </c:forEach>
                    </select>
                <h4>Valitse päivä</h4>
                
                <input type="text" class="form-control" id="valitsePvm" name="pvm" placeholder="yyyy-mm-dd">
                    <div class="form-group">
                        <label for="annaOireet" class="col-md-2 control-label">Oireeni:</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="annaOireet" name="oireet" placeholder="Oireeni">
                        </div>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-default">Varaa</button>
                    </div>
                </form>
            </div>
        </div>
</html>

