<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
<br>
<br>
First Name: <form:input path="firstName"/>
<br>
<br>
Last Name: <form:input path="lastName"/>
<br>
<br>
Country: 
<form:select path="country">
	<form:options items="${student.countries}"/>
</form:select>
<br>
<br>
Favorite Language:-
Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C#<form:radiobutton path="favoriteLanguage" value="C#"/>
nodejs<form:radiobutton path="favoriteLanguage" value="nodejs"/>
Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
<br>
<br>
Operation System:
Linux<form:checkbox path="operatingSystem" value="linux"/>
MS Windows<form:checkbox path="operatingSystem" value="MsWindow"/>
Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>

<br>
<br>
<input type="submit" value="submit"/>
</form:form>





</body>
</html>