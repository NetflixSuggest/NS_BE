package main.java.view;

import main.java.controller.admin.AdminController;
import main.java.model.program.dto.ProgramDTO;
import main.java.model.user.dto.UserResponseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EndView {
    public static void successMessage(String message) {
        System.out.println(message);
    }

    public static void printUsers(ArrayList<UserResponseDTO> users) throws SQLException {
        System.out.println("------------------------------");
        for (UserResponseDTO user : users) {
            System.out.println(user);
            System.out.println("------------------------------");
        }
    }

    public static void printMovies(ArrayList<ProgramDTO> programs) throws SQLException {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (ProgramDTO program : programs) {
            System.out.println(program);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
