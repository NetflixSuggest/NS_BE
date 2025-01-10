package main.java.controller.program;

import main.java.service.program.ProgramService;
import main.java.model.program.dto.ProgramDTO;

import java.util.ArrayList;

public class ProgramController {
	static ProgramService instance = ProgramService.getInstance();

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
}
