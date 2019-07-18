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
@RequestMapping(value = "/Teacher", produces = "text/html;charset=UTF-8")
public class Teacher {
	
	@GetMapping("")
	@ResponseBody
	
	public String homePage(@RequestParam(value = "file", required = false) String name, HttpServletRequest request,
			HttpServletResponse response){
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("<p> <a href='/Teacher/NewTest'>New Test upload</a></p>\n"
				+ "<p><a href='/SelectTest'>Select Test File</a> <button type='button'>Send Test</button></p>"
				+ "\n \n \n"
				+ "<p><a>Current Test for students:</a>\n <a href='/getCurrentTest'></a></p>"
				);
		
		return sb.toString();
	}
	
	
	@GetMapping("/NewTest")
	@ResponseBody
	public String newTestUpload(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("<p><form action='/doUpload' method='post' enctype='multipart/form-data'>"
				+ "<label>Enter file</label><input type='file' name='file'>"
				+ "<button type='submit'>Upload</button></p>"
				
				+ "<p><form action='/testName'>Test Name: <input type='text' name='name' value=''>"
				+ "<input type='submit' value='Add Test Name'></form></p>"
				
				+ "<p><form action='/addInfo'>Comment: <input type='text' comment='comment' value=''>"
				+ "<input type='submit' value='Add Comment'></form></p>"
				);
		
		sb.append("<p><a>Correct Answers:</a></p>"
				
				// Correct answer 1, need href to java method
				+ "<form action='/ans1'>Answer 1: <input type='int' Answer='answer' value=''>"
				+ "<input type='submit' value='Add'></form>"
				
				// Correct answer 2, need href to java method
				+ "<form action='/ans2'>Answer 2: <input type='int' Answer='answer' value=''>"
				+ "<input type='submit' value='Add'></form>"
				);
		
		return sb.toString();
	}
}
