package project.answers.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {
	protected Connection conn;
	public StudentController(){
		conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&characterEncoding=utf8", "root",
					"Student007");
			//conn.setAutoCommit(false);
			System.out.println("Is connection");
			// conn = DriverManager.getConnection(
			// "database_activity","root", "Student007");
			// System.out.println("Is connection");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		
	}
	
	public Student getFullRowExcel(int rowWithFile)throws SQLException{
		String query = "select * from database.Answers where id = (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, rowWithFile);
		ResultSet rs = ps.executeQuery();
		Student student = new Student();
		while(rs.next()){
		//	for(int i = 0; i<2; i++){
				student.setTrueAnswers(Float.parseFloat(rs.getString("answer1")), 0);
				student.setTrueAnswers(Float.parseFloat(rs.getString("answer2")), 1);
		//	}
		}
		return student;
	}
	
	
	public Student submitAnswers(Student student, float answer1, float answer2)throws SQLException{
		if(student.getTrueAnswers(0) == answer1){
			student.setScore(student.getScore()+1);
		}
		if(student.getTrueAnswers(1) == answer2){
			student.setScore(student.getScore()+1);
		}
		return student;
	}
	public Student setName(Student student, String name){
		student.setStudName(name);
		return student;
	}
}
