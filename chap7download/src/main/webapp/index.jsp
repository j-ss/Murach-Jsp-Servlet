<!DOCTYPE html>
<%@page import="org.download.dao.SongIo" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h2>List Of Album</h2>
<%--<%--%>
    <%--SongIo productIo=new SongIo();--%>
    <%--BufferedReader reader=productIo.getProduct();--%>
    <%--String line=reader.readLine();--%>
<%--%>--%>
<%--<table>--%>
    <%--<%--%>
        <%--while(line!=null){--%>
            <%--String[] str=line.split("\\|");--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td><a href="download?action=checkUser&productCode=<%=str[0]%>>">str[1]</a></td>--%>
    <%--</tr>--%>
    <%--<%--%>
            <%--line=reader.readLine();--%>
        <%--}--%>
    <%--%>--%>
    <%--</tr>--%>
<%--</table>--%>

<p>
    <a href="download?action=checkUser&productCode=8601">86 The Band</a><br>
    <a href="download?action=checkUser&productCode=pf01">PaddleFoot one</a><br>
    <a href="download?action=checkUser&productCode=pf02">PaddleFoot second</a><br>
    <a href="download?action=checkUser&productCode=jr01">Joe Rut</a><br>
</p>
</body>
</html>
