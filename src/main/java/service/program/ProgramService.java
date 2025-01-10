package main.java.service.program;

import java.sql.SQLException;

import main.java.model.program.ProgramDAO;

public class ProgramService {
	private static ProgramService instance = new ProgramService();
	
	private ProgramService() {
	}
	
	public static ProgramService getInstance() {
		return instance;
	}
	
	// 기존 program 삭제
	public boolean deleteProgram(String showId) throws SQLException {
		return ProgramDAO.deleteProgram(showId);
	}
	
	// id로 프로그램 title 수정
	public boolean updateProgramTitle(String showId, String title) throws SQLException {
		return ProgramDAO.updateProgramTitle(showId, title);
	}

}
