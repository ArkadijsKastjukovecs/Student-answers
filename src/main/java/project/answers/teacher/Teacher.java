package project.answers.teacher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.answers.customExceptions.MultiTestNameException;
import project.answers.tests.Test;
import project.answers.tests.TestController;

// Teacher webpage 

@MultipartConfig
@Controller
@RequestMapping(value = "/Teacher", produces = "text/html;charset=UTF-8")
public class Teacher {
	TestController testcont = TestController.getInstance();

	@GetMapping("")
	@ResponseBody

	public String homePage(@RequestParam(value = "file", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {

		StringBuilder sb = new StringBuilder();

		sb.append("<p> <a href='/addTest'>New Test upload</a></p>\n");
		
		sb.append("<p>"
				+ "<div style='height:150px;width:400px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;'>"
				
				+ "<form action='/Teacher/sendTest' method='post'>"
				
				+ "<fieldset><p>"
				+ "<label>Select test</label>"
				+ "<select name = 'selection'>"
                + currentTestOptions() // input
                + "</select></p></fieldset>"
                + "<input type='submit' value='Submit' action='/addTest' method='post'>"
                + "</form>"
                + "</div>"
				+ "</p>");
		
		sb.append("<form action='/Teacher/resetCurrentTest' method='post'>"
				+ "<input type='submit' value='Clear' action='/Teacher/resetCurrentTest' method='post'></form>"
				+ "<p>Current Test for students: " + testcont.getActiveTest() + "</p>");
		
		sb.append(
				"<p>All available tests on server:<div style='height:200px;width:400px;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;'>"
				+ availableTestList() + "</div></p>"
				);

		return sb.toString();
	}

	@PostMapping
	@RequestMapping("/NewTest")
	@ResponseBody
	public String newTestUpload(HttpServletRequest request, HttpServletResponse response) throws MultiTestNameException {
		StringBuilder sb = new StringBuilder();
		try {

			if (!request.getParameterNames().hasMoreElements()) {
				sb.append("<p><form action='' method='post' enctype='multipart/form-data'>"
						+ "<label>Enter file</label><input type='file' name='file'>"

						+ "<button type='submit'>Upload</button></p>"

						+ "<p><form action='/testName'>Test Name: <input type='text' name='name' value=''></p>"

						+ "<p><form action='/addInfo'>Comment: <input type='text' comment='comment' value=''></p>"

						+ "<p>Answer 1: <input type='text' name='answer1' value=''></p>"

						+ "<p>Answer 2: <input type='text' name='answer2' value=''></p>"

						+ "</form>"

						+ "<a href='/Teacher'>Back</a>\n");
				return sb.toString();
			} else if (request.getParameter("name") != "" && request.getParameter("comment") != ""
					&& request.getParameter("answer1") != "" && request.getParameter("answer2") != "") {

				try {
					// This is where the magic happens
					
					Part filePart = request.getPart("file");
					String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

					InputStream fileContent = filePart.getInputStream();

					byte[] buffer = new byte[fileContent.available()];
					fileContent.read(buffer);
					
					
					
					File directory = new File("./tests");
			        if (!directory.exists() && !directory.mkdirs()) {
			            throw new IOException("Directory does not exist and could not be created");
			        }
			        
			        String filePath = "./tests" + File.separator + fileName;
			        
			        File theFile = new File(filePath);
			        if (!theFile.exists()) {
			            try {
			                theFile.createNewFile();
			            } catch (IOException e) {
			                throw new IOException("Facing issues in creating file " + filePath, e);
			            }
			        }
			        
					// OLD CODE BELOW
					//File testExcel = File.createTempFile(fileName, "", null);
					//File testExcel = new File("/tests/", fileName);
					//testExcel.createNewFile();
					//testExcel.getParentFile().mkdirs();	
					
					OutputStream outStream = new FileOutputStream(theFile);
					outStream.write(buffer);
					
					Test test = new Test(theFile, request.getParameter("name"), request.getParameter("comment"),
							request.getParameter("answer1"), request.getParameter("answer2"));
					System.out.println(test);
					
					testcont.addTest(test);
					fileContent.close();
					outStream.close();

					sb.append("New test uploaded!<br/>\n<a href='/Teacher'>Back</a>\n" + theFile.getPath()
							+ "<p>_________</p>" + test.getFile().getPath());
					return sb.toString();

				} catch (Exception e) {
					sb.append("<h1>Couldnt insert test</h1>\n" + e.getMessage() + e.getStackTrace() + e.getCause());
					response.setStatus(HttpServletResponse.SC_OK);
					e.printStackTrace();
					return sb.toString();
				}

			} else {
				sb.append("failed<br/>\n<a href='/addTest'>Back</a>\n");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return sb.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
	
	
	
	@PostMapping("/sendTest")
	@ResponseBody
	public String sendTest(HttpServletRequest request, HttpServletResponse response) 
					throws IOException, ServletException{
		
		for(Test test : testcont.showAllTests()){
			if(test.getName().equals(request.getParameter("selection"))){
				testcont.SetActiveTest(test);
				return "Test sent successfully to students! <a href='/Teacher'>Back</a>";
			}
		}
		return "Something went wrong <a href='/Teacher'>Back</a>";
	}
	
	@PostMapping("/resetCurrentTest")
	@ResponseBody
	public String resetCurrentTest(HttpServletRequest request, HttpServletResponse response){
		testcont.SetActiveTest(null);
		return "Current test for students was cleared! <a href='/Teacher'>Back</a>";
	}
	
	
	public String currentTestOptions() {
		
		StringBuilder sb = new StringBuilder();
		for(Test test : testcont.showAllTests()){
			sb.append("<option value = '" + test.getName() + "'>" + test.getName() + " - " + test.getFile().getName() + "</option>");
		}
		
		return sb.toString();
		
	}
	
	public String availableTestList(){
		StringBuilder sb = new StringBuilder();
		
		for(Test test : testcont.showAllTests()){
			sb.append("<p>" + test.getName() + " - " + test.getInfo() +"</p>");
		}
		
		return sb.toString();
	}
}
