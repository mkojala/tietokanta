<%-- 
    Document   : ServletJSP
    Created on : Nov 23, 2014, 1:59:47 PM
    Author     : manna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>mahdolliset virheilmoitukset:</p>
        <div class="alert alert-danger">Virhe! <c:out value="${viesti}"/></div>
        
        <c:if test="${viesti != null}">
            <div class="alert alert-danger">Virhe! ${viesti}</div>
        </c:if>
    </body>
</html>
