package project.answers.server;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.answers.tests.Test;

@Controller
public class Addtest {

	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String getTest() {
		return "addTest";
	}

	@RequestMapping(value = "/addTest", method = RequestMethod.POST)
	public String setTest(@ModelAttribute(name = "addTest") Test test, Model model) throws IOException {
		System.out.println(test);
		File copied = new File("/test/"+test.getFile().getName());
		 FileUtils.copyFile(test.getFile(), copied);
		return "index";
	}
}
