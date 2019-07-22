package project.answers.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServerView {

	@RequestMapping(value = "/Teacher2")
	public String getTeacherPage(){
		return "Teacher2";
	}
	
}
