package project.answers.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	//@RequestMapping(value = "/currentTestOptions", method = RequestMethod.GET)
	@GetMapping("Teacher")
	public ModelAndView currentTestOptions(/*Model model*/) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("Teacher");
		mav.addObject("test", new Test());
		mav.addObject("tests", testcont.showAllTests());
		
		
		/*Test test = new Test();
		model.addAttribute("test", test);
		
		List<Test> tests = testcont.showAllTests();
		model.addAttribute("tests", tests);
		
		return "currentTestOptions";*/
		
		return mav;
		
	}
	
}



// READ THIS
// https://o7planning.org/en/11659/thymeleaf-form-select-option-example#a14065280
// AND THIS
// https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#model-attributes
// 7.5 and 5.4 points. Get tutorial version working, change to our case.
