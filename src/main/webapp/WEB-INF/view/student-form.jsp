<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        firstName: <form:input path="firstName"/><br><br/>
        lastName: <form:input path="lastName"/><br><br/>
        <form:select path="selectedCountry">
            <form:options items="${student.country}"/>
        </form:select>
        <br><br>
        Favorite Language:<br/>
       java <form:radiobutton path="favoriteLanguage" value="java"/>
        php <form:radiobutton path="favoriteLanguage" value="php"/>
        C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
        python <form:radiobutton path="favoriteLanguage" value="python"/>
        <br/><br/>
        Operating System:
        windows<form:checkbox path="OS" value="windows"/>
        mac<form:checkbox path="OS" value="max"/>
        linux<form:checkbox path="OS" value="linux"/>
        <br/><br/>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>