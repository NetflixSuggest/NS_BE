package main.java.controller.program;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.model.program.dto.ProgramDTO;
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
	
	public static boolean addProgram(String showId, String types, String title, String director, String country,
			int releaseYear, int duration, String listedIn, String description) {
		try {
			ProgramDTO program = ProgramDTO.builder().showId(showId).types(types).title(title).director(director)
					.country(country).releaseYear(releaseYear).duration(duration).listedIn(listedIn)
					.description(description).build();
			return instance.addProgram(program);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// 제목으로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByTitle(String title) {
		try {
			return instance.getProgramByTitle(title);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 감독으로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByDirector(String director) {
		try {
			return instance.getProgramByDirector(director);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 국가로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByCountry(String country) {
		try {
			return instance.getProgramByCountry(country);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 출시 연도로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByReleaseYear(int releaseYear) {
		try {
			return instance.getProgramByReleaseYear(releaseYear);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 지속 시간으로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByDuration(int duration) {
		try {
			return instance.getProgramByDuration(duration);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 장르로 프로그램 조회
	public static ArrayList<ProgramDTO> getProgramByGenre(String genre) {
		try {
			return instance.getProgramByGenre(genre);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	// 모든 프로그램 조회
	public static ArrayList<ProgramDTO> getAllProgram() {
		try {
			return instance.getAllProgram();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(); // 빈 리스트 반환
		}
	}
	
	// 장르로 프로그램 추천
		public static ArrayList<ProgramDTO> getRecommendProgramByGenre(String genre) {
			try {
				return instance.getRecommendProgrambyGenre(genre);
			} catch (Exception e) {
				e.printStackTrace();
				return new ArrayList<>(); // 빈 리스트 반환
			}
		}
}
