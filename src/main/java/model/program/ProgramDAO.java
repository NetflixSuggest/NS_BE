package main.java.model.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
