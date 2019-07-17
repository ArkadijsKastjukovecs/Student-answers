package project.answers.teacher;

import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.tomcat.util.net.Nio2Channel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class FileUploadController {
	
    //@Value("${upload.path}")
	private String path;
    
	 @RequestMapping(value = "/NewTest/doUpload", method = RequestMethod.POST,
	            	consumes = {"multipart/form-data"})
	 
	public InputStream upload(@RequestParam MultipartFile file) throws IOException {

		if (file.isEmpty()) {
			System.out.println("ERROR: FILE IS EMPTY");
		}

		String fileName = file.getOriginalFilename();

		if (fileName.contains(".xls")) {
			InputStream is = file.getInputStream();
			return is;
		}
		return null;
	 }

	 
	 public String testName(){
		 return "";
	 }
	 
	 
	 
	 public void closeStream() {

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