package project.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import project.answers.student.Student;
import project.answers.tests.Test;
import project.answers.tests.TestController;
@ComponentScan
@SpringBootApplication
public class Server {
	public static TestController testController;
    public static void main(String[] args) {
    	testController = TestController.getInstance();
    	for(Test tst:testController.showAllTests())
    		System.out.println(tst);
    	for (Student std:testController.showAllStudents())
    		System.out.println(std);
        SpringApplication.run(Server.class, args);
    }
}