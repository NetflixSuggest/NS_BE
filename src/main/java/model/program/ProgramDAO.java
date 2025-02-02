package main.java.model.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import main.java.model.program.dto.ProgramDTO;
import main.java.model.program.dto.ProgramRequestDTO;
import main.java.model.util.DBUtil;

public class ProgramDAO {
	
	// 프로그램 삭제
	public static boolean deleteProgram(String showId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtil.getConnection();
			
			// 해당 id 프로그램 삭제
			pstmt = con.prepareStatement("delete from netflix_movies where show_id=?");
			pstmt.setString(1, showId);
			
			// 삭제 완료시 true 반환
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}
	
	// 프로그램 id로 title 수정하기
	public static boolean updateProgramTitle(String showId, String title) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update netflix_movies set title=? where show_id=?");
			pstmt.setString(1, title);
			pstmt.setString(2, showId);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;		
	}
	
	// Select
		public static boolean insertProgram(ProgramRequestDTO dto) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into netflix_movies values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, dto.getShowId());
				pstmt.setString(2, dto.getTypes());
				pstmt.setString(3, dto.getTitle());
				pstmt.setString(4, dto.getDirector());
				pstmt.setString(5, dto.getCountry());
				pstmt.setInt(6, dto.getReleaseYear());
				pstmt.setInt(7, dto.getDuration());
				pstmt.setString(8, dto.getListedIn());
				pstmt.setString(9, dto.getDescription());
				
				int rs = pstmt.executeUpdate();
				if(rs == 1) {
					DBUtil.close(con, pstmt);
					return true;
				}
				
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyTitle(String title) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where title like '%' ? '%' ");
				pstmt.setString(1, title);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyDirector(String director) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where director like '%' ? '%'");
				pstmt.setString(1, director);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyCountry(String country) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where country like '%' ? '%'");
				pstmt.setString(1, country);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyReleaseYear(int releaseYear) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where release_year = ?");
				pstmt.setInt(1, releaseYear);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyDuration(int duration) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where duration = ?");
				pstmt.setInt(1, duration);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getProgrambyGenre(String genre) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where listed_in like '%' ? '%'");
				pstmt.setString(1, genre);
				rs = pstmt.executeQuery();
				
				int a= 0;
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
					System.out.println(list.get(a++));
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}
		
		public static ArrayList<ProgramDTO> getAllProgram() throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list;
		}

		public static ArrayList<ProgramDTO> getRecommendProgrambyGenre(String genre) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ProgramDTO> list = new ArrayList<>();
			ArrayList<ProgramDTO> recommendList = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from netflix_movies where listed_in like '%' ? '%'");
				pstmt.setString(1, genre);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					list.add(ProgramDTO.builder().showId(rs.getString(1)).types(rs.getString(2)).title(rs.getString(3))
							.director(rs.getString(4)).country(rs.getString(5)).releaseYear(rs.getInt(6))
							.duration(rs.getInt(7)).listedIn(rs.getString(8)).description(rs.getString(9)).build());
				}
			} finally {
				DBUtil.close(con, pstmt, rs);
			}
			
		    HashSet<Integer> selectedIndex = new HashSet<>();
		    int count = list.size();
		   
		    while (recommendList.size() < 3 && selectedIndex.size() < count) {
		        int rnd = (int) (Math.random() * count);
		        if (!selectedIndex.contains(rnd)) {
		            selectedIndex.add(rnd);
		            recommendList.add(list.get(rnd));
		        }
		    }
			return recommendList;
		}
}
