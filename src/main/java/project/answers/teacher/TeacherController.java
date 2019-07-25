package project.answers.teacher;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.answers.student.Student;
import project.answers.tests.Test;
import project.answers.tests.TestController;


// Teacher webpage 

//@MultipartConfig

@Controller
public class TeacherController {
	
	TestController testcont = TestController.getInstance();
	
	@RequestMapping(value = {"/Teacher"}, method = RequestMethod.GET)
	public String teacher(Model model) {
		
		model.addAttribute("Test", new Test());
		model.addAttribute("tests", testcont.showAllTests());
		model.addAttribute("currentTest", testcont.getActiveTest());
		
		
		return "Teacher";
	}
	
	@RequestMapping(value = {"/sendTest"}, method = RequestMethod.GET)
	public String currentTestOptions(Model model) {
		
		model.addAttribute("Test", new Test());
		model.addAttribute("tests", testcont.showAllTests());
		model.addAttribute("currentTest", testcont.getActiveTest());
		
		
		return "Teacher";
	}

	
	@RequestMapping(value = {"/sendTest"}, method = RequestMethod.POST, params="action=Send")
	public String sendTest(@Valid @ModelAttribute("test") Test test, BindingResult bindingResult, Model model){
		
		
		for(Test i : testcont.showAllTests()){
			if(i.getName().equals(test.getName())) {
				testcont.SetActiveTest(i);
				model.addAttribute("currentTest", testcont.getActiveTest());
			}
		}
		
		return "sendTest";
	}
	
	@RequestMapping(value = {"/sendTest"}, method = RequestMethod.POST, params="action=Clear")
	public String clearTest(Model model){
		
		testcont.SetActiveTest(null);
		
		model.addAttribute("Test", new Test());
		model.addAttribute("tests", testcont.showAllTests());
		model.addAttribute("currentTest", testcont.getActiveTest());
		
		
		return "Teacher";

	}
	
	//***********Test Results************
	
	@RequestMapping(value = {"/TestResults"}, method = RequestMethod.GET)
	public String testResultsData(@Valid @ModelAttribute("test") Test test, BindingResult bindingResult, Model model){
		
		model.addAttribute("Students", testcont.showAllStudents());
		
		return "TestResults";

	}
	
	@RequestMapping(value = {"/sendTest"}, method = RequestMethod.POST, params="action=Results")
	public String testResults(@Valid @ModelAttribute("test") Test test, BindingResult bindingResult, Model model){
		
		List<Student> students = testcont.findStudentsByTest(test);
		for (Student i : students){
			System.out.println(i);
		}
		model.addAttribute("students", students);
		
		for (Test retrievetest : testcont.showAllTests()){
			if(retrievetest.getName().equals(test.getName())){
				model.addAttribute("filename", retrievetest.getFile().getName());
				model.addAttribute("ans1", retrievetest.getAnswer1());
				model.addAttribute("ans2", retrievetest.getAnswer2());
			}
		}
		
		return "TestResults";

	}
	
	
}



// READ THIS
// https://o7planning.org/en/11659/thymeleaf-form-select-option-example#a14065280
// AND THIS
// https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#model-attributes
// 7.5 and 5.4 points. Get tutorial version working, change to our case.

