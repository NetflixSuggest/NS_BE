package main.java.controller.program;

import java.sql.SQLException;

import main.java.service.program.ProgramService;

public class ProgramController {
	static ProgramService instance = ProgramService.getInstance();
	
	// 프로그램 삭제 로직
	public static boolean deleteProgram(String showId) {
		try {
			return instance.deleteProgram(showId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 프로그램 title 수정 로직
	public static boolean updateProgramTitle(String showId, String title) {
		try {
			return instance.updateProgramTitle(showId, title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
