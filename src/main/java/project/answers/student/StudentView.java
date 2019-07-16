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
	String hr = "<style>hr { display: block;margin-top: 0.5em;margin-bottom: 0.5em;margin-left: auto;margin-right: auto;border-style: inset;border-width: 1px;}</style>";
	
	
	@GetMapping("")
    @ResponseBody
    public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
            HttpServletResponse response) {
    StringBuilder sb = new StringBuilder();
    sb.append("<p><font size = +2 >Ludzu, lejupieladejiet so failu: <a href='/excelfile'>Excel File</a></font></p>\n");
    sb.append("<hr>\n");
   // sb.append("<p>Ievadiet, ludzu, atbildi uz pirmo jautajumu:</p>\n");
    sb.append("<form action=/action_page.php>Ievadiet, ludzu, atbildi uz pirmo jautajumu:<br><input type=text name=answer1><br>");
 //   sb.append("<a href='/findTeacher'>");
   // sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
   // sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
    // Following is also redundant because status is OK by default:
    response.setStatus(HttpServletResponse.SC_OK);
    return sb.toString();
}
	@GetMapping("/excelfile")
    @ResponseBody
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		
		return "";
	}
	
}
