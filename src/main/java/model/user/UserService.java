package main.java.model.user;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public static UserResponseDTO checkUser(UserLoginDTO user) throws SQLException {
		return UserDAO.checkUser(user);
	}
	
	//id에 맞는 유저 검색 X
	public static UserResponseDTO getUserById(String userId) {
		return UserDAO.getUserById(userId);
	}
	
	//Admin pw 검증
	public static UserRole checkAdminByPw(String userPw) {
		if (userPw.equals("adminPw123456")) {
			return UserRole.ADMIN;
		}
		return UserRole.USER;
	}
	
	public static ArrayList<UserResponseDTO> getUsers() throws SQLException{
		return UserDAO.getUsers();
	}
	
	public static boolean deleteUser(String userId) {
		return UserDAO.deleteUser(userId);
	}

}
