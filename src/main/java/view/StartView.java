package main.java.view;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import main.java.controller.program.ProgramController;
import main.java.model.program.ProgramDAO;
import main.java.model.util.DBUtil;


public class StartView {
	public static void main(String[] args) {
		
		// 프로그램 삭제
//		ProgramController.deleteProgram("s10");
		
		// 프로그램 제목 수정
		ProgramController.updateProgramTitle("s19", "오징어게임");
		
//		try {
//			Connection conn = DBUtil.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
