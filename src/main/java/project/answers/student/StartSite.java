package project.answers.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// TODO uncomment these annotations to notify to SpringBoot framework
// that this class can be run as SpringBoot application
 //@Configuration
 //@EnableAutoConfiguration
 //@ComponentScan
@SpringBootApplication
public class StartSite {
	public static void main(String[] args) throws Exception {
		// TODO uncomment next line to start JettyApplication web app:
		 SpringApplication.run(StartSite.class, args);
		// Look at
		// http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html
		// for more information.
	}
}