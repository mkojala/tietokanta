<%-- 
    Document   : omasivu
    Created on : Dec 6, 2014, 2:35:06 PM
    Author     : Marianne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = fi>
    <head>
        <title>MediHome</title>
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
            <h4>Kirjaudu sisään</h4>
            <c:if test="${viesti != null}">
                <div class="alert alert-danger">Virhe! ${viesti}</div>
            </c:if>
            <form class="form-horizontal" role="form" action="login" method="POST">
                <div class="form-group">
                    <label for="ktunnus" class="col-md-2 control-label">Käyttäjätunnus</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="ktunnus" name="username" value="${kayttaja}" placeholder="Käyttäjätunnus">
                    </div>
                </div>
                <div class="form-group">
                    <label for="annaSalasana" class="col-md-2 control-label">Salasana</label>
                    <div class="col-md-5">
                        <input type="password" class="form-control" id="annaSalasana" name="password" placeholder="Salasana">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-5">
                        <button type="submit" class="btn btn-default">Kirjaudu sisään</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="container">
            <h4>Uusi asiakas? Rekisteröidy</h4>
            <form class="form-horizontal" role="form" action="login" method="POST">
                <div class="form-group">
                    <label for="annaNimi" class="col-md-2 control-label">Nimi</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="annaNimi" name="Nimi" placeholder="Nimi">
                    </div>
                </div>
                <div class="form-group">
                    <label for="annaSalasana2" class="col-md-2 control-label">Salasana</label>
                    <div class="col-md-5">
                        <input type="password" class="form-control" id="annaSalasana2" name="Salasana" placeholder="Salasana">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-5">
                        <button type="submit" class="btn btn-default">Rekisteröidy</button>
                    </div>
                </div>
            </form>
        </div>  
    </body>
</html>