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
        background-color: mediumpurple;
    }
</style>
<body>
<form action="/addAMacedonian" method="post">
    Enter the name: <input type="text" name="name"><br>
    Enter the age: <input type="text" name="age"><br>
    Enter the name of the unit: <input type="text" name="unit"><br>
    <input type="submit" value="Add!">
</form>
<form action="/getMacedonians">
    <input type="submit" value="See the current squad!">
</form>
</body>
</html>