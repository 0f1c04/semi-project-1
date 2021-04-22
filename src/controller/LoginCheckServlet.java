package controller;

import model.UserDAO;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");

        // DB에서 아이디, 비밀번호 확인
        UserDAO dao = UserDAO.getInstance();
        int check = dao.loginCheck(userID, userPW);

        // DB 생성 전 테스트
//    int check = 0;
//    if(id.equals("test") && pw.equals("test"))
//        check = 1;

        // URL 및 로그인관련 전달 메시지
        String msg = "";

        if (check == 1)    // 로그인 성공
        {
            // 세션에 현재 아이디 세팅
//            HttpSession session = null;
//            session.setAttribute("sessionID", userID); //아이디 말고 쿠키 넣어야할 듯
            msg = "/";
        } else if (check == 0) // 비밀번호가 틀릴경우
        {
            msg = "/LoginForm.jsp?msg=0";
        } else    // 아이디가 틀릴경우
        {
            msg = "/LoginForm.jsp?msg=-1";
        }

        // sendRedirect(String URL) : 해당 URL로 이동
        // URL뒤에 get방식 처럼 데이터를 전달가능
        response.sendRedirect(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
