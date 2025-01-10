package main.java.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.model.util.DBUtil;

public class UserDAO {
	
	// 회원 가입
	public static boolean addUser(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if(!isDuplicate(user.getId())) {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into netflix_movies (userId, userPw, userRole) values(?, ?, ?)");
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, UserService.checkAdminByPw(user.getPw()));
				int result = pstmt.executeUpdate();
				if(result == 1) {
					return true;
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// id, pw 체크 로직
	public static boolean checkUser(UserLoginDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select userPw from netflix_movies where userId=?");
			pstmt.setString(1, user.getId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				String db_pw = rset.getString(1);
				if (db_pw.equals(user.getPw())) {
					return true;
				}
			}else {
				System.out.println("해당 ID 없음");
				return false;
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return false;
	}
	
	// 아이디 중복 체크 로직
	private static boolean isDuplicate(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select userId from netflix_movies where userId=?");
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (!rset.next()) {
				return false;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return true;
	}
}
