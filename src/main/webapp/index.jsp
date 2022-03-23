<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="hello-servlet" method="post">
    <label>UserName</label>
   <input type="text" placeholder="Enter Username" name="UserName" required><br>
    <label>Password</label>
    <input type="text" name="Password"  placeholder="Enter Password" name="Password" required><br>
    <button type="submit">Login</button>

</form>

</body>
</html>