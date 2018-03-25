<%@page contentType="text/html" pageEncoding="utf-8"%>
<!Doctype html>
<html>
<head>
   <meta charset="UTF-8">
    <title>Practice</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css">
</head>
<p>
<h2>Join our email list!</h2>
<i>${message}</i>
</p>
<p>
    <form action="emaillist" method="post">
    <input type="hidden" name="action" value="add">
    <label class="pad_top">Email:</label>
    <input type="email" name="email" value="${user.email}" required>
    <label class="pad_top">First Name:</label>
    <input type="text" name="fname" value="${user.firstName}" required>
    <label class="pad_top">Last Name:</label>
    <input type="text" name="lname" value="${user.lastName}" required>
    <p>Contect Me Via<br>
    <input type="radio" name="contactVia" value="email">Email<br>
    <input type="radio" name="contactVia" value="phone">Phone</p>
    <p>I am interested in music<br>
    <input type="checkbox" name="rock">Rock<br>
    <input type="checkbox" name="bluegrass">bluegrass<br>
    <input type="checkbox" name="jazz">jazz</p>
    <p>select a country<br>
    <select name="country" multiple size="1"><!-- size="3" multiple -->
        <option value="IN">India</option>
        <option value="RUS">Russia</option>
        <option value="US">America</option>
        <option value="CH">China</option>
        <option value="UK">England</option>
    </select></p>
    <label>&nbsp;</label>
    <input class="margin_left" type="submit" value="Join Now" id="submit">
</form></p>
</body>
</html>
