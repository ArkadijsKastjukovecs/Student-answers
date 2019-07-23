package project.answers.teacher;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.answers.tests.Test;
import project.answers.tests.TestController;

// Teacher webpage 

//@MultipartConfig

@Controller
public class TeacherController {
	
	TestController testcont = TestController.getInstance();
	
	//@RequestMapping(value = "sendTest", method = RequestMethod.POST)
	@PostMapping("/sendTest")
	public String sendTest(Model model) throws IOException, ServletException{
		
		for(Test test : testcont.showAllTests()){
			if(test.getName().equals("selection")){
				testcont.SetActiveTest(test);
				System.out.println(testcont.getActiveTest());
				return "sendtest";
			}
		}
		return "sendTest";
	}
	
	//@RequestMapping(value = "resetCurrentTest", method = RequestMethod.POST)
	@PostMapping("/resetCurrentTest")
	public String resetCurrentTest(Model model){
		testcont.SetActiveTest(null);
		
		return "resetCurrentTest";
	}
	
	
	//@RequestMapping(value = "currentTestOptions", method = RequestMethod.GET)
	//@ModelAttribute("/currentTestOptions")
	@GetMapping("/currentTestOptions")
	public String currentTestOptions(Model model) {
		
		model.addAttribute("tests", testcont.showAllTests());
		return "currentTestOptions";
	}
	
	
	//@RequestMapping(value = "getActiveTest", method = RequestMethod.GET)
	@GetMapping("/getActiveTest")
	public String getActiveTest(){
		return testcont.getActiveTest().toString();
	}
	
	/*@ModelAttribute("allTypes")
	public List<String> populateTypes() {
	    return Arrays.asList(String.);
	}*/
	
}

// READ THIS
// https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#model-attributes
// 7.5 and 5.4 points. Get tutorial version working, change to our case.
