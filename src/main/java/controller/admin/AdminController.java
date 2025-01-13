package main.java.controller.admin;

import main.java.model.user.dto.UserResponseDTO;
import main.java.model.user.UserRole;
import main.java.service.user.UserService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdminController {

    private static AdminController instance = new AdminController();
    static UserService userService = UserService.getInstance();

    public static AdminController getInstance() {
        return instance;
    }

    // id에 맞는 유저 검색
    public static UserResponseDTO getUserById(String userId){
        return userService.getUserById(userId);
    }

    // AdminPw 검증
    public static UserRole checkAdminByPw(String userPw){
        return userService.checkAdminByPw(userPw);
    }

    // 모든 유저 검색
    public static ArrayList<UserResponseDTO> getUsers() throws SQLException {
        return userService.getUsers();
    }

    // 유저 삭제
    public static boolean deleteUser(String userId){
        return userService.deleteUser(userId);
    }
}
