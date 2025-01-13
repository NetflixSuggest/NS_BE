package main.java.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.model.user.dto.UserDTO;
import main.java.model.user.dto.UserLoginDTO;
import main.java.model.user.dto.UserResponseDTO;
import main.java.model.util.DBUtil;
import main.java.service.user.UserService;

public class UserDAO {

	// user 목록 보기
	public static ArrayList<UserResponseDTO> getUsers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 처리를 위한 ResultSet 추가
		UserResponseDTO user = null;
		ArrayList<UserResponseDTO> users = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			// 올바른 SQL 쿼리 작성
			pstmt = con.prepareStatement("SELECT userId, userRole FROM netflix_movies");
			// 쿼리 실행 및 결과 처리
			rs = pstmt.executeQuery();
			while (rs.next()){
				String role = rs.getString(2);
				user = UserResponseDTO.builder()
						.id(rs.getString(1))
						.role(role.equals("ADMIN") ? UserRole.ADMIN : UserRole.USER)
						.build();
				users.add(user);
			}
		} finally {
			// 리소스 해제
			DBUtil.close(con, pstmt, rs);
		}
		// 결과가 없으면 false 반환
		return users;
	}
	
	// id로 user 찾기
	public static UserResponseDTO getUserById(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserResponseDTO user = null;
		try {
			con = DBUtil.getConnection();
			// 올바른 SQL 쿼리 작성
			pstmt = con.prepareStatement("select userId, userRole FROM netflix_movies WHERE userId = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String role = rs.getString(2);
				user = UserResponseDTO.builder()
						.id(rs.getString(1))
						.role(role.equals("ADMIN") ? UserRole.ADMIN : UserRole.USER)
						.build();
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // 예외 로깅
		} finally {
			DBUtil.close(con, pstmt); // 리소스 해제
		}
		return user; // 예외 발생 또는 삭제 실패 시 false 반환
	}

	// user 회원 탈퇴
	public static boolean deleteUser(String userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			// 올바른 SQL 쿼리 작성
			pstmt = con.prepareStatement("DELETE FROM netflix_movies WHERE userId = ?");
			pstmt.setString(1, userId);
			// 쿼리 실행 및 결과 확인
			int rowsDeleted = pstmt.executeUpdate();
			return rowsDeleted > 0; // 삭제된 행이 있으면 true 반환
		} catch (SQLException e) {
			e.printStackTrace(); // 예외 로깅
		} finally {
			DBUtil.close(con, pstmt); // 리소스 해제
		}
		return false; // 예외 발생 또는 삭제 실패 시 false 반환
	}

	// 회원 가입
	public static boolean addUser(UserDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if (!isDuplicate(user.getId())) {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into netflix_movies (userId, userPw, userRole) values(?, ?, ?)");
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, UserService.checkAdminByPw(user.getPw()).name());
				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// id, pw 체크 로직
	public static UserResponseDTO checkUser(UserLoginDTO user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select userPw from netflix_movies where userId=?");
			pstmt.setString(1, user.getId());
			rset = pstmt.executeQuery();
			if (rset.next()) {
				String db_pw = rset.getString(1);
				if (db_pw.equals(user.getPw())) {
					return getUserById(user.getId());
				}
			} else {
				System.out.println("해당 ID 없음");
				return null;
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return null;
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
