package project.answers.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.answers.tests.Test;

@Controller
public class Addtest {

	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String getTest() {
		return "addTest";
	}
 
	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public String setTest(@ModelAttribute(name = "addTest") Test test, @RequestParam("file") MultipartFile file,
			Model model) throws IOException {
		System.out.println(test);
		File copied = new File("/test/" + test.getFile().getName());
		System.out.println("file name	: " + file.getName());
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
