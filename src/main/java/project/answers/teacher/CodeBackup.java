package project.answers.teacher;

public class CodeBackup {

}


/*

******************************BACKUP START****************************

package project.answers.teacher;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

//import net.miginfocom.demo.Test;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Properties;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import project.answers.tests.Test;
import project.answers.tests.TestController;

// Teacher webpage 


@MultipartConfig
@RestController
@RequestMapping(value = "/Teacher", produces = "text/html;charset=UTF-8")
public class Teacher {
	TestController testcont;
	
	
	@GetMapping("")
	@ResponseBody
	
	public String homePage(@RequestParam(value = "file", required = false) String name, HttpServletRequest request,
			HttpServletResponse response){
		
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("<p> <a href='/Teacher/NewTest'>New Test upload</a></p>\n"
				+ "<p><a href='/SelectTest'>Select Test File</a> <button type='button'>Send Test</button></p>"
				+ "\n \n \n"
				+ "<p><a>Current Test for students:</a>\n <a href='/getCurrentTest'></a></p>"
				);
		
		return sb.toString();
	}
	
	@PostMapping
	@RequestMapping("/NewTest")
	@ResponseBody
	public String newTestUpload(HttpServletRequest request, HttpServletResponse response){
		StringBuilder sb = new StringBuilder();
		try{
			
			
		if(!request.getParameterNames().hasMoreElements()){
			sb.append("<p><form action='' method='post' enctype='multipart/form-data'>"
					+ "<label>Enter file</label><input type='file' name='file'>"
					
					+ "<button type='submit'>Upload</button></p>"
					
					+ "<p><form action='/testName'>Test Name: <input type='text' name='name' value=''></p>"
					
					+ "<p><form action='/addInfo'>Comment: <input type='text' comment='comment' value=''></p>"
					
					+ "<p>Answer 1: <input type='text' Answer='answer1' value=''></p>"
					
					+ "<p>Answer 2: <input type='text' Answer='answer2' value=''></p>"
					
					+ "</form>"
					
					+ "<a href='/Teacher'>Back</a>\n"
					);
			return sb.toString();
		}
		else if( request.getParameter("name") != ""
				&& request.getParameter("comment") != "" && request.getParameter("answer1") != ""
				&& request.getParameter("answer2") != ""){
			
			try{
				// Upload happens here
				
				Part filePart = request.getPart("file");
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				InputStream fileContent = filePart.getInputStream();

				File testExcel = new File(System.getProperty("upload.location"));
				testExcel.createNewFile();

				Files.copy(fileContent, Paths.get(testExcel.getName()));


				double ans1 = Double.parseDouble(request.getParameter("answer1"));
				double ans2 = Double.parseDouble(request.getParameter("answer2"));

				Test test = new Test(testExcel, request.getParameter("name"), 
									request.getParameter("comment"), ans1, ans2);

				testcont.addTest(test);

				sb.append("New test uploaded!<br/>\n<a href='/Teacher'>Back</a>\n");
				return sb.toString();
				
				
			} catch (Exception e){
				sb.append("<h1>Couldnt insert test</h1>\n"
						+ e.getMessage()
						+ e.getStackTrace()
						+ e.getCause());
                response.setStatus(HttpServletResponse.SC_OK);
                return sb.toString();
			}
			
		}
		else{
            sb.append("failed<br/>\n<a href='/Teacher/NewTest'>Back</a>\n");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return sb.toString();
		}
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "";
		
		
		
		
	}
	
}



******************************BACKUP END****************************
*/