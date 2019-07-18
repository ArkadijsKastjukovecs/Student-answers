package project.answers.teacher;

import project.answers.tests.Test;
import project.answers.tests.TestController;

import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.tomcat.util.descriptor.tld.TldRuleSet.Variable;
import org.apache.tomcat.util.net.Nio2Channel;
import org.springframework.aop.target.ThreadLocalTargetSourceStats;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class FileUploadController {
    
	
	// new middleman class instead?
	
	 private String name;
	 private String info;
	 private double ans1;
	 private double ans2;
	 
	 TestController testcont;
	 
	 @RequestMapping(value = "/doUpload", method = RequestMethod.POST,
         	consumes = {"multipart/form-data"})
	 
	public void doUpload(@RequestParam MultipartFile file) throws IOException {
		
		 String fileName = file.getOriginalFilename();
		 
		 if (file.isEmpty()) {
			System.out.println("ERROR: FILE IS EMPTY");
			return;
		 }
		
		 if (!fileName.contains(".xls")) {
			 System.out.println("ERROR: NOT EXCEL");
			 return;
		 }
		
		 //InputStream is = file.getInputStream();
		
		 File testExcel = new File(file.getOriginalFilename());
		 testExcel.createNewFile();
		 FileOutputStream fos = new FileOutputStream(testExcel);
		 fos.write(file.getBytes());
		 fos.close();
		
		 Test testObj = new Test(testExcel, name, info, ans1, ans2);
		 
		 testcont.addTest(testObj);
		 
	 }

	 
	 @RequestMapping(value = "/testName")
	 private String testName(@RequestParam String name){
		 this.name = name;
		 
		 return "Name set";
	 }
	 
	 @RequestMapping(value = "/addInfo")
	 private void addInfo(@RequestParam String info){
		 this.info = info;
	 }
	 
	 @RequestMapping(value = "/ans1")
	 private void answer1(@RequestParam float ans){
		 this.ans1 = ans;
	 }
	 
	 @RequestMapping(value = "/ans2")
	 private void answer2(@RequestParam float ans){
		 this.ans2 = ans;
	 }
	 
}

// InputStream is = file.getInputStream();

//Check tutorials below for how the fuck to do this
	// https://java2novice.com/issues/convert-excel-workbook-into-byte-array/
	// https://stackoverflow.com/questions/40253515/creating-an-excel-file-in-memory-using-java-and-pass-as-bytes-for-downloading
	// http://zetcode.com/springboot/uploadfile/
	// https://www.baeldung.com/spring-mvc-excel-files

// pseudo-code:
// open file search window, select file
// if necessary, convert to varbin or Blob type
// SQL command, insert into SQL table