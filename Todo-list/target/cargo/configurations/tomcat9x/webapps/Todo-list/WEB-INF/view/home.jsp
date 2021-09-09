<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="shantanu.spring.util.Mappings" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Add Todo Items</title>
    </head>
    <body>
        <div align="center">
            <c:url var="itemsLink" value="${Mappings.ITEMS_LIST}"/>
            <h2><a href="${itemsLink}">Show Todo Items</a></h2>
        </div>
    </body>
</html>