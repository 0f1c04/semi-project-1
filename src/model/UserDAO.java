package model;

import utill.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    private static UserDAO instance;

    public UserDAO() {
    }

    public static UserDAO getInstance() {
        if(instance == null) instance = new UserDAO();
        return instance;
    }

    public void insertUser(UserVO user) {
        Connection conn =  DBUtil.getConnection();
        PreparedStatement st = null;

        try {
            conn.setAutoCommit(false);

            StringBuffer sql = new StringBuffer();
            sql.append("insert into USERS values");
            sql.append("(?, ?, ?, 0)");

            st = conn.prepareStatement(sql.toString());
            st.setString(1, user.getUserID());
            st.setString(2, user.getUserPW());
            st.setString(3, user.getUserName());

            st.executeUpdate();

            conn.commit();
        } catch (SQLException sqle) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(sqle.getMessage());
        } finally {
            DBUtil.dbClose(null, st, conn);
        }
    }

    public int loginCheck(String userID, String userPW) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement st = null;
        int result = 0;

        try {
            conn.setAutoCommit(false);

            StringBuffer sql = new StringBuffer();
            sql.append("select USER_ID, USER_PW from USERS where USER_ID=? and USER_PW=?");

            st = conn.prepareStatement(sql.toString());
            st.setString(1, userID);
            st.setString(2, userPW);

            result = st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(null, st, conn);
        }

        return result;
    }

}
