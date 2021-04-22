<%@ page import="model.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<html>
<head>
    <title>LoginCheck JSP</title>
</head>
<body>
<%
    // ���ڵ� ó��
    request.setCharacterEncoding("euc-kr");

    // �α��� ȭ�鿡 �Էµ� ���̵�� ��й�ȣ�� �����´�
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");

    // DB���� ���̵�, ��й�ȣ Ȯ��
    UserDAO dao = UserDAO.getInstance();
    int check = dao.loginCheck(userID, userPW);

    // DB ���� �� �׽�Ʈ
//    int check = 0;
//    if(id.equals("test") && pw.equals("test"))
//        check = 1;

    // URL �� �α��ΰ��� ���� �޽���
    String msg = "";

    if (check == 1)    // �α��� ����
    {
        // ���ǿ� ���� ���̵� ����
        session.setAttribute("sessionID", userID); //���̵� ���� ��Ű �־���� ��
        msg = "/";
    } else if (check == 0) // ��й�ȣ�� Ʋ�����
    {
        msg = "/LoginForm.jsp?msg=0";
    } else    // ���̵� Ʋ�����
    {
        msg = "/LoginForm.jsp?msg=-1";
    }

    // sendRedirect(String URL) : �ش� URL�� �̵�
    // URL�ڿ� get��� ó�� �����͸� ���ް���
    response.sendRedirect(msg);
%>
</body>
</html>