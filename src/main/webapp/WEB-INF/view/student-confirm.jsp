<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    the student is confirmed: ${student.firstName} ${student.lastName}<br/>
    country: ${student.selectedCountry}<br/>
    favorite language: ${student.favoriteLanguage}<br/>
    OS:
    <ul>
        <c:forEach var="temp" items="${student.OS}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>