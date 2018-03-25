<!DOCTYPE html>
<%@page import="org.cart.dao.ProductIo" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="org.cart.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<%
    ProductIo productIo=new ProductIo();
    List<Product> products=productIo.getProducts();

%>
<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
    </tr>
    <%
       for(Product product:products){
    %>
    <tr>
        <td><%=product.getDescription()%></td>
        <td class="right"><%=product.getCurencyFormat()%></td>
        <td><a href="cart?productCode=<%=product.getProductCode()%>">Add To Cart</a></td>
    </tr>
    <%
       }
    %>
   </tr>
</table>

</body>
</html>