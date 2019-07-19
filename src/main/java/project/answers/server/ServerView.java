package project.answers.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.answers.student.StudentView;

@RestController
@RequestMapping(value = "", produces = "text/html;charset=UTF-8")
public class ServerView {
	
	 StudentView student = new StudentView();

	@GetMapping("/")
	@ResponseBody
	public String homePage(String name, HttpServletRequest request,
			HttpServletResponse response) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("<p> <a href='/Teacher'>Teacher</a></p>\n"
				+ "<p><a href='/student'>Student</a> ");

		return sb.toString();
	}
	
	@GetMapping("/do")
	public void myMethod(){
		
	}

}
