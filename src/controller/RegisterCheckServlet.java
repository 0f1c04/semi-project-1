package controller;

import model.UserDAO;
import model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterCheckServlet")
public class RegisterCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserVO user = new UserVO();
        UserDAO dao = new UserDAO();

        user.setUserID(request.getParameter("userID"));
        user.setUserPW(request.getParameter("userPW"));
        user.setUserName(request.getParameter("userName"));

        dao.insertUser(user);

        response.sendRedirect("/LoginForm.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
