package project.answers.teacher;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Null;
import javax.websocket.Decoder.BinaryStream;

import java.sql.Statement;

public class TeacherTestManager {
	
	protected Connection conn;
	
	public TeacherTestManager() {
		
		conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&characterEncoding=utf8",
					"root", "Student007");
			
			//conn.setAutoCommit(false);
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	
	public boolean insertTest(int id, Blob file, String name, String info, float ans1, float ans2) throws SQLException{
		
		try{
			String sql = "insert into database_Tests (table_id, file, name, info, answer1, answer2) values (?, ?, ?, ?, ?)";
			
			PreparedStatement prepSt = conn.prepareStatement(sql);
			
			prepSt.setInt(1, id);
			prepSt.setBlob(2, file); //obtained from FileUploadController object
			prepSt.setString(3, name);
			prepSt.setFloat(4, ans1);
			prepSt.setFloat(5, ans2);
			
			int rs = prepSt.executeUpdate();
			
			if(rs > 0){
				return true;
			}
			
			
			
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		
		
		return false;
	}
	
	
}	//end
