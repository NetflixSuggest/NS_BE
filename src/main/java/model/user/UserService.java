package main.java.model.user;

import java.sql.SQLException;

public class UserService {
	
	private static UserService instance = new UserService();
	
	private UserService() {
	}
	
	public static UserService getInstance() {
		return instance;
	}
	
	// 회원 가입
	public static boolean addUser(UserDTO user) throws SQLException {
		return UserDAO.addUser(user);
	}
	
	// id, pw 검증
	public static boolean checkUser(UserLoginDTO user) throws SQLException {
		return UserDAO.checkUser(user);
	}
	
	//Admin pw 검증
	public static String checkAdminByPw(String userPw) {
		if (userPw.equals("adminPw123456")) {
			return "ADMIN";
		}
		return "USER";
	}

}
