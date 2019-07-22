package project.answers.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.answers.Server;
import project.answers.customExceptions.MultiStudentNameException;
import project.answers.tests.Test;

@Controller
public class StudentController {
	Test test = Server.testController.getTest("first");
	
//	protected Connection conn;
	/*conn = null;
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
		}
		
	}
	
	public Student getFullRowExcel(int rowWithFile)throws SQLException{
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
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String helloWorld(HttpServletRequest request, HttpServletResponse response, Model model){
	//	Server.testController.SetActiveTest(test);
		String test = Server.testController.getTest("first").getName();
	
		
		model.addAttribute("test", test);
		model.addAttribute("ActiveTest", Server.testController.getActiveTest());
		return "StudentView";
	}
	@RequestMapping(value = "/student/excelFile", method = RequestMethod.GET)
	public void excelFile(HttpServletRequest request, HttpServletResponse response){
		request.getParameter("test");
	}
	
	public static int getAnswers(String one, String two, String fileName, String vards) throws MultiStudentNameException{
		
		int localScore = 0;
		Test test = Server.testController.getTest(fileName);
		//String passed = "";
		
		if(one.equals(test.getAnswer1())){
			
			//student.setScore(student.getScore()+1);
			localScore++;
		}
		if(two.equals(test.getAnswer2())){
			
			//student.setScore(student.getScore()+1);
			localScore++;
		}
		Student student = new Student(vards, fileName, localScore);
		Server.testController.AddStudent(student);
		return student.getScore();
		
	}
	public static boolean activeTest(){
		Test test = Server.testController.getActiveTest();
		if(test==null){
		return true;
		}else{
			return false;
		}
	}

}
