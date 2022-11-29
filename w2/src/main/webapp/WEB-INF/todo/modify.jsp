<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify/Remove</title>
</head>
<body>
<form id="modifyForm" action="/todo/modify" method="post">
  <div>수정하려면 여기를 입력하세요 !!</div>
  <div>
    <input type="text" name="tno" value="${dto.tno}" readonly>
  </div>
  <div>
    <input type="text" name="title" value="${dto.title}">
  </div>
  <div>
    <input type="date" name="dueDate" value="${dto.dueDate}">
  </div>
  <div>
    <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}>
  </div>

  <div>
    <button type="submit">Modify</button>
  </div>

</form>
<hr>
<form id="removeForm" action="/todo/remove" method="post">
  <div>삭제하려면 여기를 클릭하세요 !!</div>
<%-- /t odo/remove로 submit(post)할 때 서버로 tno 값을 보내서 해당 tno 값에 맞는 TodoDTO 를 삭제해야 하기 때문에,
      <input type="hidden"> 으로 form 태그 전송 시 tno를 같이 보낸다 --%>
  <input type="hidden" name="tno" value="${dto.tno}" readonly>
  <div>
    <button type="submit">Remove</button>
  </div>
</form>
</body>
</html>
