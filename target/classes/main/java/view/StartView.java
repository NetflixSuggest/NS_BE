package main.java.view;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import main.java.model.user.UserDTO;
import main.java.model.user.UserLoginDTO;
import main.java.model.user.UserResponseDTO;
import main.java.model.user.UserService;
import main.java.model.util.DBUtil;

public class StartView {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		while (true) {
			System.out.println("\n메뉴를 선택하세요");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("4. 종료");
			int num = scanner.nextInt();
			scanner.nextLine();
			switch (num) {
			case 1:
				loginView();
				break;
			case 2:
				signUpView();
				break;
			case 3:
				break;
			case 4:
				return;
			}
		}
	}

	private static void loginView() throws SQLException {
		System.out.println("로그인을 시도합니다");
		System.out.print("아이디 : ");
		String userId = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();
		UserLoginDTO user = UserLoginDTO.builder().id(userId).pw(password).build();
		UserResponseDTO user_info = UserService.checkUser(user);
		if (user_info != null) {
			System.out.println("로그인 성공");
			loginSuccessView(user_info.getRole().name());
		} else {
			System.out.println("로그인 실패");
		}
	}

	private static void signUpView() throws SQLException {
		System.out.println("회원가입을 시작합니다");
		System.out.print("아이디 : ");
		String userId = scanner.nextLine();
		System.out.print("비밀번호 : ");
		String password = scanner.nextLine();

		UserDTO user = UserDTO.builder().id(userId).pw(password).build();

		if (UserService.addUser(user)) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("중복된 아이디 입니다. 다시 시도해주세요.");
		}
	}

	private static void deleteUser() {
		System.out.println("삭제할 유저의 Id를 입력해주세요");
		String deleteId = scanner.nextLine();
		UserResponseDTO user = UserService.getUserById(deleteId);
		if (user != null) {
			if (UserService.deleteUser(deleteId)) {
				System.out.println("삭제 성공했습니다.");
			}
		} else {
			System.out.println("삭제 실패했습니다.");
		}
	}

	private static void printUsers() throws SQLException {
		ArrayList<UserResponseDTO> users = UserService.getUsers();
		System.out.println("------------------------------");
		for (UserResponseDTO user : users) {
			System.out.println(user);
			System.out.println("------------------------------");
		}
	}

	private static void loginSuccessView(String role) throws SQLException {
		while (true) {
			// 검색, 여러 검색
			System.out.println("1. 제목 검색");
			System.out.println("2. 감독 검색");
			System.out.println("3. 나라 검색");
			System.out.println("4. 출시연도 검색");
			System.out.println("5. 장르 검색");
			System.out.println("6. 로그아웃");
			if (role.equals("ADMIN")) {
				System.out.println("---------어드민 기능---------");
				System.out.println("7. 전체 유저 조회");
				System.out.println("8. 유저 계정 삭제");
			}

			int num = scanner.nextInt();
			scanner.nextLine();
			if (num > 6 && !role.equals("ADMIN")) {
				System.out.println("1~6 중 하나를 입력하세요");
			} else {
				switch (num) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					return;
				case 7:
					printUsers();
					break;
				case 8:
					deleteUser();
					break;
				case 9:
					break;
				}
			}
		}
	}
}
