package main.java.view;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import main.java.model.user.UserDTO;
import main.java.model.user.UserLoginDTO;
import main.java.model.user.UserService;
import main.java.model.util.DBUtil;


public class StartView {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		while(true) {
			System.out.println("\n메뉴를 선택하세요");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			int num = scanner.nextInt();
			scanner.nextLine();
			switch(num) {
			case 1:
				loginView();
				break;
			case 2:
				signUpView();
				break;
			case 3:
				return;
			}
		}
	}
	public static void loginView() throws SQLException {
		System.out.println("로그인을 시도합니다");
		System.out.print("아이디 : ");
		String userId = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();
		UserLoginDTO user = UserLoginDTO.builder()
				.id(userId)
				.pw(password)
				.build();
		if(UserService.checkUser(user)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	
	public static void signUpView() throws SQLException{
		System.out.println("회원가입을 시작합니다");
		System.out.print("아이디 : ");
		String userId = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();

		UserDTO user = UserDTO.builder()
				.id(userId)
				.pw(password)
				.build();
		
		if (UserService.addUser(user)) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("중복된 아이디 입니다. 다시 시도해주세요.");
		}
	}
}
