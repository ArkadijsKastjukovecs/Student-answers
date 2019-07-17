package project.answers.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.answers.Server;
import project.answers.tests.Test;

public class StudentController {
	protected Connection conn;
	public StudentController(){
		//gjk
	/*	conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.8.124:3305/?autoReconnect=true&useSSL=false&characterEncoding=utf8", "student",
					"Student007");
			//conn.setAutoCommit(false);
			System.out.println("Is connection");
			// conn = DriverManager.getConnection(
			// "database_activity","root", "Student007");
			// System.out.println("Is connection");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}*/
		
	}
	
	/*public Student getFullRowExcel(int rowWithFile)throws SQLException{
		String query = "select * from database_Tests.Tests1 where id = (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, rowWithFile);
		ResultSet rs = ps.executeQuery();
		Student student = new Student();
		while(rs.next()){
		//	for(int i = 0; i<2; i++){
				student.setTrueAnswers(rs.getString("answer1"), 0);
				student.setTrueAnswers(rs.getString("answer2"), 1);
		//	}
		}
		return student;
	}
	
	
	public int submitAnswers(Student student, String answer1, String answer2)throws SQLException{
		if(student.getTrueAnswers(0) == answer1){
			student.setScore(student.getScore()+1);
		}
		if(student.getTrueAnswers(1) == answer2){
			student.setScore(student.getScore()+1);
		}
		return student.getScore();
	}
	public Student setName(Student student, String name){
		student.setStudName(name);
		return student;
	}*/
	public void getAnswers(){
		Test test = Server.testController.getTest("first");
		
		
	}
}
