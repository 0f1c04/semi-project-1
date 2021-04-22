<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="model.UserVO" %>
<%@ page import="model.UserDAO" %>
<html>
<head>
    <title>회원가입 처리 JSP</title>

</head>
<body>
<%-- LoginForm.jsp에서 입력한 정보를 넘겨 받아 처리한다. --%>
<%
    // 한글 깨짐을 방지하기 위한 인코딩 처리
    request.setCharacterEncoding("euc-kr");

%>

<%-- 자바빈 관련 액션태그 사용 --%>
<jsp:useBean id="user" class="model.UserVO"/>
<jsp:setProperty property="*" name="user"/>

<%
    UserDAO dao = UserDAO.getInstance();

    // 회원정보를 담고있는 memberBean을 dao의 insertMember() 메서드로 넘긴다.
    // insertMember()는 회원 정보를 USERS 테이블에 저장한다.
    dao.insertUser(user);
%>

<div id="wrap">
    <br><br>
    <b>회원가입 정보를 확인하세요.</b>
    <br><br>
    <%=user.getUserName() %>님 가입을 축하드립니다.
    <br><br>

    <%-- 자바빈에서 입력된 값을 추출한다. --%>
    <table>
        <tr>
            <td>아이디</td>
            <td><%=user.getUserID() %></td>
        </tr>

        <tr>
            <td>비밀번호</td>
            <td><%=user.getUserPW() %></td>
        </tr>

        <tr>
            <td>이름</td>
            <td><%=user.getUserName() %></td>
        </tr>
    </table>
    <br>
    <input type="button" value="확인" onclick="location.href='/'">
</div>
</body>
</html>