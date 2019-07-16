package project.answers.student;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
public class StudentView {
	StudentController studentController;
	
	
	@GetMapping("")
    @ResponseBody
    public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
            HttpServletResponse response) {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><font size = +5 >Ludzu, lejupieladejiet so failu: </font><a href='/findTeacher'></p>");
   // sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
   // sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
    // Following is also redundant because status is OK by default:
    response.setStatus(HttpServletResponse.SC_OK);
    return sb.toString();
}
	
}
