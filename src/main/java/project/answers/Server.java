package project.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import project.answers.tests.TestController;

//import project.answers.student.StartSite;
//import project.answers.student.*;
//import project.answers.teacher.*;

@SpringBootApplication
@ComponentScan
public class Server {
	public static TestController testController;
	public static void main(String[] args) {
		testController = TestController.getInstance();
		testController.loadTests();
		SpringApplication.run(Server.class, args);
		
	}
}
