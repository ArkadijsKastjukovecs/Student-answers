package project.answers.teacher;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Teacher webpage 

@RestController
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class Teacher {
	
	@GetMapping("")
	@ResponseBody
	
	public String homePage(@RequestParam(value = "file", required = false) String name, HttpServletRequest request,
			HttpServletResponse response){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p> <a href='/SelectExcel'>SelectExcel</a> <button type='button'>Upload</button> </p>");
		
		return sb.toString();
		
		
	}

}
