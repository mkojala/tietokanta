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
                            <th>Nimi</th>
                            <th>Osoite</th>
                            <th>Päivä</th>
                            <th>Oireet</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="varaustiedot" items="${varaukset}">
                            <tr>
                                <td ><c:out value="${varaustiedot.nimi}"/></td>
                                <td ><c:out value="${varaustiedot.osoite}"/></td>  
                                <td ><c:out value="${varaustiedot.paiva}"/></td>
                                <td ><c:out value="${varaustiedot.oireet}"/></td>   
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>  
            <div class="container">     
                <form action="laakarinsivu" method="POST">      
                    <h4>Valitse potilas</h4>
                    <select name="asiakas">
                        <c:forEach var="asiakas" items="${asiakkaat}">
                            <option value="${asiakas.kayttaja_id}"><c:out value="${asiakas.nimi}"/></option>
                        </c:forEach>
                    </select>
                    <div>
                        <button type="submit" class="btn btn-default">Hae potilashistoria</button>
                    </div>
                    <h4>Potilashistoria:</h4>
                    <c:forEach var="raportti" items="${raportit}"> 
                    <br /><c:out value="${raportti.potilasraportti}"/> 
                    <br /><c:out value="${raportti.hoito_ohjeet}"/>
                </c:forEach> 
                    <div>
                        <input type="text" class="form-control" id="raportti" name="raportti" placeholder="Kirjoita asiakkaalle hoito-ohjeet">
                        
                        <button type="submit" class="btn btn-xs btn-default"> Lisää hoito-ohjeet</button>
                        <button type="button" class="btn btn-xs btn-default"> Potilashistoria</button>
                        <button type="submit" class="btn btn-xs btn-default"> Lisää raportti</button>
                        <p>Tähän tulee potilaan tietoja</p>
                        <button type="submit" class="btn btn-xs btn-default"> Tallenna</button>
                        <button type="submit" class="btn btn-xs btn-default"> Muokkaa</button>
                        <button type="button" class="btn btn-xs btn-default"> Poista</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>