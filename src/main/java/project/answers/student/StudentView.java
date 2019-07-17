package project.answers.student;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.answers.Server;


@RestController
@RequestMapping(value = "/student", produces = "text/html;charset=UTF-8")
public class StudentView {
	int score = 0;
	//StudentController studentController;
	String hr = "<style>hr { display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;}</style>";
	
	
	@GetMapping("")
    @ResponseBody
    public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
            HttpServletResponse response) {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><font size = +2 >Ludzu, lejupieladejiet so failu: </p></font><a href='/student/excelFile' target='_blank'>  Excel File</a>\n");
    sb.append("<hr>\n");
    sb.append("<form action='/student/buttonSubmit'>Ievadiet, ludzu, atbildi uz pirmo jautajumu:"
    		+ "<br><input type=text name=answer1><br>\n"
    		+ "Ievadiet, ludzu, atbildi uz otro jautajumu:<br><input type=text name=answer2><br>\n"
    		+ "<button type=submit formtarget='_self'>Apstiprinat</button></form><br/>\n");
    
    response.setStatus(HttpServletResponse.SC_OK);
    return sb.toString();
}
	@GetMapping("/excelFile")
    @ResponseBody
    public String excelFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuilder sb2 = new StringBuilder();
		File file = Server.testController.getTest("One").getFile();
		if(file.exists()){
			OutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(file);
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0){
			    out.write(buffer, 0, length);
			}
			in.close();
			out.flush();
			sb2.append("<p>New Page!</p>");
		//	sb2.append("<a download='"+ file +"'>");
		}
			  
		else{
			sb2.append("<p>File don't exist</p>");
		}
	//	sb2.append("<p>File don't exist</p>");
		return sb2.toString();
	}
	@GetMapping("/buttonSubmit")
    @ResponseBody
	public String buttonSubmit(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		StringBuilder sb1 = new StringBuilder();
		if (request.getParameter("answer1") != "" && request.getParameter("answer2") != "") {

			sb1.append("<hr>");
			sb1.append("<p>Jusu atzime ir: </p>\n");
			sb1.append(StudentController.getAnswers(request.getParameter("answer1"), request.getParameter("answer2")));
		}
		return sb1.toString();
	}
	
}
