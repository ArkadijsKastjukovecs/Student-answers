package project.answers.teacher;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import project.answers.tests.Test;
import project.answers.tests.TestController;

// Teacher webpage 

//@MultipartConfig

@Controller
public class TeacherController {
	
	TestController testcont = TestController.getInstance();

	
	@Autowired
	@GetMapping("Teacher")
	public ModelAndView currentTestOptions() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Teacher");
		mav.addObject("activeTest", testcont.getActiveTest());
		mav.addObject("test", new Test());
		mav.addObject("tests", testcont.showAllTests());
		
		return mav;
	}
	
	@PostMapping("/sendTest")
	public String sendTest(@Valid Test test){
		
		testcont.SetActiveTest(test);
		
		return "sendTest";
		
	}
	
}



// READ THIS
// https://o7planning.org/en/11659/thymeleaf-form-select-option-example#a14065280
// AND THIS
// https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#model-attributes
// 7.5 and 5.4 points. Get tutorial version working, change to our case.
