package project.answers.tests;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.answers.student.Student;

public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8729209678450935222L;
	private File file;
	private MultipartFile multiFile;
	public MultipartFile getMultiFile() {
		return multiFile;
	}


	public void setMultiFile(MultipartFile multiFile) {
		this.multiFile = multiFile;
	}


	private String name;
	private String info;
	private String answer1;
	private String answer2;
	private double studentAnswer;
	private List<String> answers;
	private List<Student> students;

	public Test(File file, String name, String info, String answer1, String answer2) {
		this.file = file;
		this.name = name;
		this.info = info;
		this.answer1 = answer1;
		this.answer2 = answer2;
		answers= new ArrayList<>();
		students = new ArrayList<>();
	}
	
	
	public Test(){
		answers= new ArrayList<>();
		students = new ArrayList<>();
		
	}
	public void addStudent (Student student) {
		students.add(student);
	}
	
	public Student getStudent(String name){
		Student student = null;
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			if ((student = iterator.next()).getStudName().equals(name))
				return student;
		}
		return student;
	}
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
	
	public void addAnswer(String answer) {
		answers.add(answer);
	}
	
	public void removeAnswer(double answer){
		answers.remove(Double.valueOf(answer));
	}
	
	public List<String> getAnswers(){
		return answers;
	}



	public double getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(double studentAnswer) {
		this.studentAnswer = studentAnswer;
	}


	@Override
	public String toString() {
		return "Test [file=" + file + ", name=" + name + ", answer1=" + answer1 + ", answer2=" + answer2 + "]";
	}

	
}
