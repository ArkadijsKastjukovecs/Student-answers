package project.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import project.answers.tests.TestController;
@ComponentScan
@SpringBootApplication
public class Server {
	public static TestController testController;
    public static void main(String[] args) {
    	testController = TestController.getInstance();
        SpringApplication.run(Server.class, args);
    }
}