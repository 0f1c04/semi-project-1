<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="model.UserVO" %>
<%@ page import="model.UserDAO" %>
<html>
<head>
    <title>ȸ������ ó�� JSP</title>

</head>
<body>
<%-- LoginForm.jsp���� �Է��� ������ �Ѱ� �޾� ó���Ѵ�. --%>
<%
    // �ѱ� ������ �����ϱ� ���� ���ڵ� ó��
    request.setCharacterEncoding("euc-kr");

%>

<%-- �ڹٺ� ���� �׼��±� ��� --%>
<jsp:useBean id="user" class="model.UserVO"/>
<jsp:setProperty property="*" name="user"/>

<%
    UserDAO dao = UserDAO.getInstance();

    // ȸ�������� ����ִ� memberBean�� dao�� insertMember() �޼���� �ѱ��.
    // insertMember()�� ȸ�� ������ USERS ���̺� �����Ѵ�.
    dao.insertUser(user);
%>

<div id="wrap">
    <br><br>
    <b>ȸ������ ������ Ȯ���ϼ���.</b>
    <br><br>
    <%=user.getUserName() %>�� ������ ���ϵ帳�ϴ�.
    <br><br>

    <%-- �ڹٺ󿡼� �Էµ� ���� �����Ѵ�. --%>
    <table>
        <tr>
            <td>���̵�</td>
            <td><%=user.getUserID() %></td>
        </tr>

        <tr>
            <td>��й�ȣ</td>
            <td><%=user.getUserPW() %></td>
        </tr>

        <tr>
            <td>�̸�</td>
            <td><%=user.getUserName() %></td>
        </tr>
    </table>
    <br>
    <input type="button" value="Ȯ��" onclick="location.href='/'">
</div>
</body>
</html>