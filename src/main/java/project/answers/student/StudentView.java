package project.answers.student;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.answers.Server;
import project.answers.customExceptions.MultiStudentNameException;

@RestController
@RequestMapping(value = "/student", produces = "text/html;charset=UTF-8")
public class StudentView {
//	Test test5 = Server.testController.getTest("first");
	
	String help = "";
	String hr = "<style>hr { display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;}</style>";
//	String noBack = "<script type='text/javascript'>window.history.forward();function noBack(){ window.history.forward();}</script>";
	
	@GetMapping("")
    @ResponseBody
    public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
            HttpServletResponse response) {
    StringBuilder sb = new StringBuilder();
 //   Server.testController.SetActiveTest(test5);
    if(StudentController.activeTest()){
   // sb.append("<p><font size = +2 >Ludzu, lejupieladejiet so failu: </p></font><a href='/student/excelFile' target='_blank'>  Excel File</a>\n");
    sb.append("<form action='/student/excelFile'><font size = +2 >Testa nosaukums</font><br><input type=text name=testName><br>\n "
    		+ "<button type=submit formtarget='_blank'>Lejupieladet</button></form><br/>\n");
    }else{
    	sb.append("<form action='/student/excelFile'><font size = +2 >Testa nosaukums</font>"
    			+ "<a href='/student/excelFile' target='_blank'>  Excel File</a>\n");
    }
    sb.append("<hr>\n");
    sb.append("<form action='/student/buttonSubmit'>Jusu vards<br><input type=text name=vards><br>\n"
    		+ "Ievadiet, ludzu, atbildi uz pirmo jautajumu:<br><input type=text name=answer1><br>\n"
    		+ "Ievadiet, ludzu, atbildi uz otro jautajumu:<br><input type=text name=answer2><br>\n"
    		+ "<button type=submit formtarget='_self'>Apstiprinat</button></form><br/>\n");
    
    response.setStatus(HttpServletResponse.SC_OK);
    return sb.toString();
}
	@GetMapping("/excelFile")
    @ResponseBody
    public String excelFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		StringBuilder sb2 = new StringBuilder();
		help = request.getParameter("testName");
		File file;
		try{
			System.out.println(help);
			if(StudentController.activeTest()){
				 file = Server.testController.getTest(request.getParameter("testName")).getFile();
			}else{
				 file = Server.testController.getActiveTest().getFile();
			}
			System.out.println(file.getName());
//			response.setContentType("application/ods");
			OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(file.getAbsolutePath());
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > -1){
			    out.write(buffer, 0, length);
			}
			System.out.println(file.getName());
			
			in.close();
			out.flush();
			sb2.append("<p>New Page!</p>");
			
			//System.out.println(file.getAbsolutePath());
			
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(NullPointerException e){
			System.out.println(e);
			sb2.append("<p>File don't exist</p>");
			return sb2.toString();
			}
		
//		response.setStatus(HttpServletResponse.SC_OK);
	//	sb2.append("<p>File don't exist</p>");
		return sb2.toString();
	}
	
	
	@GetMapping("/buttonSubmit")
    @ResponseBody
	public String buttonSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		StringBuilder sb1 = new StringBuilder();
		System.out.println(help+" "+request.getParameter("vards"));
		if (request.getParameter("answer1") != "" && request.getParameter("answer2") != "") {
			sb1.append("<hr>");
			sb1.append("<p>Jusu atzime ir: </p>\n");
			try {
				sb1.append(StudentController.getAnswers(request.getParameter("answer1"), 
				request.getParameter("answer2"),help, request.getParameter("vards")));
			} catch (MultiStudentNameException e) {
				e.printStackTrace();
				sb1.append("<p>Sis students ar tadu vardu jau pildija so testu</p>");
				return sb1.toString();
			}
			}

		return sb1.toString();
		}
	
}
