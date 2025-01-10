package main.java.service.program;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.model.program.ProgramDAO;
import main.java.model.program.dto.ProgramDTO;

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

	public boolean addProgram(ProgramDTO program) throws Exception {
		return ProgramDAO.insertProgram(program);
	}
	
	public ArrayList<ProgramDTO> getProgramByTitle(String title) throws Exception {
		return ProgramDAO.getProgrambyTitle(title);
	}
	
	public ArrayList<ProgramDTO> getProgramByDirector(String director) throws Exception {
		return ProgramDAO.getProgrambyDirector(director);
	}
	
	public ArrayList<ProgramDTO> getProgramByCountry(String country) throws Exception {
		return ProgramDAO.getProgrambyCountry(country);
	}
	
	public ArrayList<ProgramDTO> getProgramByReleaseYear(int releaseYear) throws Exception {
		return ProgramDAO.getProgrambyReleaseYear(releaseYear);
	}
	
	public ArrayList<ProgramDTO> getProgramByDuration(int duration) throws Exception {
		return ProgramDAO.getProgrambyDuration(duration);
	}
	
	public ArrayList<ProgramDTO> getProgramByGenre(String genre) throws Exception {
		return ProgramDAO.getProgrambyGenre(genre);
	}
	
	public ArrayList<ProgramDTO> getAllProgram() throws Exception {
		return ProgramDAO.getAllProgram();
	}
}
