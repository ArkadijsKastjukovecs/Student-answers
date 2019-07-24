package project.answers.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.answers.Server;
import project.answers.customExceptions.MultiFileNameException;
import project.answers.customExceptions.MultiTestNameException;
import project.answers.tests.Test;

@Controller
public class Addtest {

	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String getTest() {
		return "addTest";
	}
	
	@PostMapping("/addTest")
	public String setTest(
			@ModelAttribute(name = "addTest") Test test,
			@RequestParam("file1") MultipartFile file,
			Model model
			) throws IOException, MultiFileNameException, MultiTestNameException {
		File file1 =  new File("./tests/"+file.getOriginalFilename());
		Test test1 = test;
		test1.setFile(file1);
		Server.testController.addTest(test1);
		System.out.println("file name: " + file.getOriginalFilename());
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get("/home/student/workspace/newProj/answers/tests/" + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "index";
	}
}
