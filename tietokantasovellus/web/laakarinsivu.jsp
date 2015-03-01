<%-- 
    Document   : laakarinsivu
    Created on : Dec 7, 2014, 2:15:23 PM
    Author     : Marianne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fi">
    <head>
        <title>Lääkärin sivu</title>
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
            <div>  
                <h4>Aikataulu</h4>
                <table class="table table-striped">            
                    <thead>
                        <tr>
                            <th>Päivä</th>
                            <th>Oireet</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="varaus" items="${varaukset}">
                            <tr>
                            <td ><c:out value="${varaus.paiva}"/></td>
                            <td ><c:out value="${varaus.oireet}"/></td>   
                            </tr>
                </c:forEach> 
                    </tbody>
                </table>
            </div>  
            <div class="container">     
                <form class="form-horizontal" role="form" action="laakarinsivu" method="POST">      
                    <div class="form-group">
                        <h4>Etsi potilas</h4>
                        <label for="nimi" class="col-md-2 control-label">Nimi</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="nimi" name="nimi" placeholder="Nimi">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-5">
                            <button type="submit" class="btn btn-default">Hae</button>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-xs btn-default"> Lisää raportti</button>
                    <button type="submit" class="btn btn-xs btn-default"> Lisää hoito-ohjeet</button>
                    <button type="button" class="btn btn-xs btn-default"> Potilashistoria</button>
                    <p>Tähän tulee potilaan tietoja</p>
                    <button type="submit" class="btn btn-xs btn-default"> Tallenna</button>
                    <button type="submit" class="btn btn-xs btn-default"> Muokkaa</button>
                    <button type="button" class="btn btn-xs btn-default"> Poista</button>
                </form>
            </div>
        </div>
    </body>
</html>