<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<style>
    body {
        background-color: forestgreen;
    }
</style>
<body>
Kinda green now. Anyway, welcome: ${person}
<form action="/index" method="get">
    <input type="submit" value="Back to menu.">
</form>
</body>
</html>