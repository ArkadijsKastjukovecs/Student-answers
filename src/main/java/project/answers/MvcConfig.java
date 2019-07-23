package project.answers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/addTest").setViewName("addTest");
		registry.addViewController("/teacher").setViewName("Teacher");
		registry.addViewController("/Teacher2/addTest").setViewName("addTest");
		registry.addViewController("/login").setViewName("login");
		
		
		
	}

}