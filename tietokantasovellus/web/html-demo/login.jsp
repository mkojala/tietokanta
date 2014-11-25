<%-- 
    Document   : login
    Created on : Nov 23, 2014, 11:35:17 PM
    Author     : manna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <title>MediHome</title>
    </head>
    <body>
        <div class="container">
            <h1>MediHome</h1>
            <h4>Kirjaudu sisään</h4>
            <form class="form-horizontal" role="form" action="login.html" method="POST">
                <div class="form-group">
                    <label for="ktunnus" class="col-md-2 control-label">Käyttäjätunnus</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="ktunnus" name="käyttäjätunnus" placeholder="Käyttäjätunnus">
                    </div>
                </div>
                <div class="form-group">
                    <label for="annaSalasana" class="col-md-2 control-label">Salasana</label>
                    <div class="col-md-5">
                        <input type="password" class="form-control" id="annaSalasana" name="salasana" placeholder="Salasana">
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
            <form class="form-horizontal" role="form" action="login.html" method="POST">
                <div class="form-group">
                    <label for="annaEtunimi" class="col-md-2 control-label">Etunimi</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="annaEtunimi" name="Etunimi" placeholder="Etunimi">
                    </div>
                </div>
                <div class="form-group">
                    <label for="annaSukunimi" class="col-md-2 control-label">Sukunimi</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" id="annaSukunimi" name="Sukunimi" placeholder="Sukunimi">
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
