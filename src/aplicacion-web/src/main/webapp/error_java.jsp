<%-- 
    Document   : error_java
    Created on : Dec 5, 2023, 4:07:05 PM
    Author     : edemb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1> Error </h1>
        <p>Sorry, Java has thrown an excepcion </p>
        <p>To continue, click the back button</p>

        <h2>Details</h2>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Message: {pageContext.exception.message}</p>
        
    </body>
</html>
