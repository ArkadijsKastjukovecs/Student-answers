package project.answers;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import project.answers.tests.Test;
import project.answers.tests.TestController;

//import project.answers.student.StartSite;
//import project.answers.student.*;
//import project.answers.teacher.*;

@SpringBootApplication
@ComponentScan
public class Server {
	public static TestController testController;
	public static void main(String[] args) {
		Test test = new Test();
		File file = new File("/home/student/workspace/One.odt");
		testController = TestController.getInstance();
		testController.addTest(new Test(file,"One","", 1, 1));
		testController.loadTests();
		SpringApplication.run(Server.class, args);
		
	}
}
