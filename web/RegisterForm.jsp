<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<html>
<head>
    <title>회원가입 화면</title>

    <script type="text/javascript">

        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue() {
            if (!document.userInfo.userID.value) {
                alert("아이디를 입력하세요.");
                return false;
            }

            if (!document.userInfo.userPW.value) {
                alert("비밀번호를 입력하세요.");
                return false;
            }

            // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
            if (document.userInfo.userPW.value !== document.userInfo.passwordcheck.value) {
                alert("비밀번호를 동일하게 입력하세요.");
                return false;
            }
        }

        // 취소 버튼 클릭시 로그인 화면으로 이동
        function goLoginForm() {
            location.href = "LoginForm.jsp";
        }
    </script>

</head>
<body>
<!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
<div id="wrap">
    <br>
    <h2>회원가입</h2>
    <br>


    <!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
    <!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 RegisterCheck.jsp -->
    <form method="post" action="RegisterCheckServlet" name="userInfo"
          onsubmit="return checkValue()">
        <table>
            <tr>
                <td>아이디</td>
                <td>
                    <input type="text" name="userID" maxlength="50">
                    <input type="button" value="중복확인">
                </td>
            </tr>

            <tr>
                <td>비밀번호</td>
                <td>
                    <input type="password" name="userPW" maxlength="50">
                </td>
            </tr>

            <tr>
                <td>비밀번호 확인</td>
                <td>
                    <input type="password" name="passwordcheck" maxlength="50">
                </td>
            </tr>

            <tr>
                <td>이름</td>
                <td>
                    <input type="text" name="userName" maxlength="50">
                </td>
            </tr>

        </table>
        <br>
        <input type="submit" value="가입"/>
        <input type="button" value="취소" onclick="goLoginForm()">
    </form>
</div>
</body>
</html>