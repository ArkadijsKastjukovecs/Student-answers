package project.answers.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.answers.student.*;
//import project.answers.teacher.*;

@RestController
@RequestMapping(value = "/index", produces = "text/html;charset=UTF-8")
public class ServerView {
	// Teacher teacher = new Teacher();
	
	 StudentView student = new StudentView();

	@GetMapping("")
	@ResponseBody
	public String homePage(String name, HttpServletRequest request,
			HttpServletResponse response) {

		StringBuilder sb = new StringBuilder();

		sb.append("<p> <a href='/teacher'>Teacher</a></p>\n"
				+ "<p><a href='/student'>Student</a> ");

		return sb.toString();
	}

}
