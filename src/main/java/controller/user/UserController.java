package main.java.controller.user;

import main.java.model.user.dto.UserDTO;
import main.java.model.user.dto.UserLoginDTO;
import main.java.model.user.dto.UserResponseDTO;
import main.java.service.user.UserService;

import java.sql.SQLException;

public class UserController {
    private static UserController instance = new UserController();
    static UserService userService = UserService.getInstance();

    private UserController() {
    }

    public static UserController getInstance() {
        return instance;
    }

    // 회원 가입
    public static boolean signUp(String userId, String userPw) throws SQLException {
        UserDTO user = UserDTO.builder()
                .id(userId)
                .pw(userPw)
                .build();
        return userService.addUser(user);
    }

    // 로그인 (id, pw 검증)
    public static UserResponseDTO login(String userId, String userPw) throws SQLException {
        UserLoginDTO userRequest = UserLoginDTO.builder()
                .id(userId)
                .pw(userPw)
                .build();
        return userService.checkUser(userRequest);
    }


}
