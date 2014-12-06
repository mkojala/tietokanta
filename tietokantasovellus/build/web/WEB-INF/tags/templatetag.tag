<%-- 
    Document   : templatetag
    Created on : Dec 6, 2014, 3:26:15 PM
    Author     : Marianne
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="viesti"%>
<c:if test="${viesti != null}">
  <div class="alert alert-danger">Virhe! ${viesti}</div>
</c:if>

