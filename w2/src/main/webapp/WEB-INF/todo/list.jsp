<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>
<h2>로그인 정보 : ${loginInfo}</h2>
<h3>회원 이름 : ${loginInfo.mname}</h3>

<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}"> ${dto.tno} </a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE" : "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>

</body>
</html>
