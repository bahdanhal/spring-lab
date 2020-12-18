<%@ page import="com.lab.triangle.Triangle" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Triangle</title>
</head>
<body>
    <form action="request" method="post">
        <label> First side</label>
        <input type="text" name="firstSide">
        <label> Second side</label>
        <input type="text" name="secondSide">
        <label> Third side</label>
        <input type="text" name="thirdSide">
        <input type="submit" value="Check">
    </form>
    ${error}
    <br/>
    ${impossible}
    <br/>
    ${equilateral}
    <br/>
    ${isosceles}
    <br/>
    ${rectangular}
</body>
</html>