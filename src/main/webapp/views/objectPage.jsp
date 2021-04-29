<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<style>
    body {
        background-color: cornflowerblue;
    }
</style>
<body>
Hello, person!
<form action="/createAPerson">
    Enter the first name: <input type="text" name="firstName"><br>
    Enter the last name: <input type="text" name="lastName"><br>
    <input type="submit" value="Add!">
    <input type="submit" formaction="/createAPersonButDifferently" value="Another add!">
</form>
</body>
</html>