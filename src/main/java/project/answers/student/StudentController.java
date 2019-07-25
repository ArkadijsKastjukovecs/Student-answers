package project.answers.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
	private static Test test = null;
	private static File file;
	private boolean downloadedTest = true;
	private int switchCase = 1;
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
	@RequestMapping(value = "/student", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	public String helloWorld(HttpServletRequest request, HttpServletResponse response, Model model){
		
	//	Server.testController.SetActiveTest(test);
	//	System.out.println(Server.testController.getActiveTest());
		model.addAttribute("isActive", Server.testController.getActiveTest());
		return "StudentView";
	}

	@RequestMapping(value = "/student/excelFile", method = RequestMethod.POST)
	public String excelFile(HttpServletRequest request, HttpServletResponse response, Model model){
		response.setContentType("application/*");
		test = Server.testController.getTest(request.getParameter("testName"));
		if(StudentController.activeTest()){
			 file = Server.testController.getTest(request.getParameter("testName")).getFile();
		}else{
			file = Server.testController.getActiveTest().getFile();
		}
		if(file != null){
			
		try{
		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(file.getAbsolutePath());
		byte[] buffer = new byte[in.available()];
		int length;
		while ((length = in.read(buffer)) > -1){
		    out.write(buffer, 0, length);
		}
		System.out.println(file.getName());
		
		in.close();
		out.flush();
		model.addAttribute("IOException", "Success");
		}
		catch(IOException e){
			model.addAttribute("IOException", "Fail");
			System.out.println("Nepareizais testa nosaukums");
		}
		}else{
			model.addAttribute("IOException", "Fail");
		}
		System.out.println(request.getParameter("testName"));
		
		return "excelFile";
	}
	
	@RequestMapping(value = "/student/buttonSubmit", method = RequestMethod.POST)
	public String buttonSubmit(HttpServletRequest request, Model model) {
		switchCase = 1;
//		System.out.println(request.getParameter("answer1")+" "+ request.getParameter("answer2"));
		
		int localScore = 0;
		try {
		if(test.getName() == null){
			switchCase = 3;
			model.addAttribute("testNull", String.valueOf(switchCase));
		}
		
		System.out.println(test.getName());
		if (request.getParameter("answer1") != "" && request.getParameter("answer2") != "" &&
				request.getParameter("vards") != "" && test.getName() != null) {
	//			downloadedTest = true;
				localScore = StudentController.getAnswers(request.getParameter("answer1"), 
				request.getParameter("answer2"), request.getParameter("vards"));
				System.out.println(String.valueOf(downloadedTest));
			} 
		}
			catch(NullPointerException e){
				switchCase = 2;
				model.addAttribute("testNull", String.valueOf(switchCase));
	//			downloadedTest = false;
			}
			catch (MultiStudentNameException e) {
	//			model.addAttribute("downloadedTest", String.valueOf(downloadedTest));
				
				model.addAttribute("testNull", String.valueOf(switchCase));
				model.addAttribute("localScore", "Sis students ar tadu vardu jau pildija so testu");
				return "StudentScore";
				}
		
		model.addAttribute("testNull", String.valueOf(switchCase));
//		model.addAttribute("downloadedTest", String.valueOf(downloadedTest));
		model.addAttribute("localScore", String.valueOf(localScore));
		return "StudentScore";
	}
	
	public static int getAnswers(String one, String two, String vards) throws MultiStudentNameException{
		
		int localScore = 0;
		if(one.equals(test.getAnswer1())){
			
			localScore++;
		}
		if(two.equals(test.getAnswer2())){
			
			localScore++;
		}
		Student student = new Student(vards, test.getName(), localScore);
		System.out.println(student.toString());
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
