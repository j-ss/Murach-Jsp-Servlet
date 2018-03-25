<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach Java Servlet Jsp</title>
    <link href="styles/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Download</h1>
<h2>86(the band)- True life song</h2>
<table>
    <tr>
        <th>Song title</th>
        <th>Audio Format</th>
    </tr>
    <tr>
        <td>Dangerous</td>
        <td><a href="/music/${productCode}/Dangerous.mp3">MP3</a></td>
    </tr>
    <tr>
        <td>What I Did For Love</td>
        <td><a href="/music/${productCode}/02. What I Did For Love (feat. Emeli Sandé).mp3">MP3</a></td>
    </tr>
</table>
</body>
</html>
