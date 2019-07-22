package project.answers.server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.answers.tests.Test;

@Controller
public class Addtest {

	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String getTest(){
		return "addTest";
	}
	
	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public String setTest(@ModelAttribute(name="addTest") Test test, Model model){
		System.out.println(test.getName());
		
		return "index";
	}
}
