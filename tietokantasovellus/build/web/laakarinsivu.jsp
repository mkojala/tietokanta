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

                    <input type="submit" value="Hae" name="button">
                    <h4>Potilashistoria</h4>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Raportti-ID</th>
                                <th>Potilasraportti</th>
                                <th>Hoito-ohje</th>
                                <th>Valitse</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="raportti" items="${raportit}"> 
                                <tr>
                                    <td>
                                        <c:out value="${raportti.raportti_id}"/>
                                    </td>
                                    <td><c:out value="${raportti.potilasraportti}"/></td>
                                    <td><c:out value="${raportti.hoito_ohjeet}"/></td>
                                    <td>
                                     <input type="checkbox" name="checkbox" value="${raportti.raportti_id}"/></td> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        <input type="text" class="form-control" id="hoito_ohje" name="hoito_ohje" placeholder="Kirjoita asiakkaalle hoito-ohjeet">
                        <input type="text" class="form-control" id="raportti" name="raportti" placeholder="Kirjoita potilasraportti">
                        <input type="submit" class="btn btn-xs btn-default" value="Poista" name="button">
                        <input type="submit" class="btn btn-xs btn-default" value ="Tallenna" name="button">
                        <input type="submit" class="btn btn-xs btn-default" value ="Muokkaa" name ="button">
                    </div>
                </form>
            </div>
    </body>
</html>