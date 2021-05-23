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
        background-color: dodgerblue;
    }
</style>
<body>
    Welcome to this App which is so blue!
    <form action="/add">
        Enter the 1st number: <input type="text" name="NumberOne"><br>
        Enter the 2nd number: <input type="text" name="NumberTwo"><br>
        <input type="submit" value="Add!">
        <input type="submit" formaction="/substract" value="Substract!">
        <input type="submit" formaction="/multiply" value="Multiply!">
        <input type="submit" formaction="/divide" value="Divide!">
    </form>
    <form action="/objectPage" method="get">
        <input type="submit" value="Go to object adding page.">
    </form>
    <form action="/macedonianPage" method="get">
        <input type="submit" value="Go to the Macedonian page.">
    </form>
</body>
</html>