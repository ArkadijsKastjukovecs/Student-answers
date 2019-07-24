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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String setTest(@ModelAttribute(name = "addTest") Test test, @RequestParam("file1") MultipartFile file,
			Model model, RedirectAttributes redirectAttributes) {
		File file1 = file.getOriginalFilename().trim().equalsIgnoreCase("") ? null
				: new File("./tests/" + file.getOriginalFilename());
		Test test1 = test;
		try {
			test1.setFile(file1);
			Server.testController.addTest(test1);
			System.out.println("file name: " + file.getOriginalFilename());
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get("./tests/" + file.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message",
					"Jums izdēvas izvedot jaunu testu '" + test1.getName() + "'");

		} catch (IOException e) {

			redirectAttributes.addFlashAttribute("message", "Jums izdēvas izvedot jaunu testu '" + test1.getName() + "' bez faila");

		} catch (MultiFileNameException e) {
			e.printStackTrace();
		} catch (MultiTestNameException e) {
			redirectAttributes.addFlashAttribute("message",
					"Testi ar vienādiem nosaukumiem netiek pieņemti: '" + test1.getName() + "'");
			e.printStackTrace();
		}
		return "redirect:/uploadStatus";
	}
}
