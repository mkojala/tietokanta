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
            <div class="container">
                <div>
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="../tietokantasovellus/omasivu">Omat tiedot</a></li>
                        <li class="active"><a href="../tietokantasovellus/varaussivu">Varaa aika</a></li>
                    </ul>
                </div>  
            </div>

            <div> <h3>Varaussivu</h3>
                
            </div>
            <div>  
                <h4>Valitse lääkäri</h4>
                <form class="form-horizontal" role="form" action="varaussivu" method="GET">
                <select>
                    <c:forEach var="laakari" items="${laakarit}"> 
                        <option value="${laakari.kayttaja_id}" name="id">${laakari.nimi}</option>
                </c:forEach> 
            </select>
                    <button type="submit">Hae vapaat ajat</button>
                    </form>
                
                
                <table class="table table-striped">            
                    <thead>
                        <tr>

                            <th>klo</th>
                            <th>ma</th>
                            <th>ti</th>
                            <th>ke</th>
                            <th>to</th>
                            <th>pe</th>                                                  
                        </tr>
                        <tr>
                            <td>08:00</td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                        </tr>
                        <tr><td>10:00</td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                            <td class=""></td>
                            
                            
                            </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Lasse Lääkäri</td>
                            <td>12:00</td>
                        </tr>
                        <tr>
                            <td>Ossi Ortopedi</td>
                            <td>14:00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="container">
                <form class="form-horizontal" role="form" action="varaussivu.html" method="POST">
                    <div class="form-group">
                        <label for="annaOireet" class="col-md-2 control-label">Oireeni:</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="annaOireet" name="Oireeni" placeholder="Oireeni">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-5">
                            <button type="submit" class="btn btn-default">Varaa</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
</html>

