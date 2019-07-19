package project.answers.tests;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.answers.student.Student;

public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8729209678450935222L;
	private File file;
	private String name;
	private String question;
	private String answer1;
	private String answer2;
	private double studentAnswer;
	private List<Double> answers;
	private List<Student> students;

	public Test(File file, String name, String question, String answer1, String answer2) {
		this.file = file;
		this.name = name;
		this.question = question;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public double getAnswer1() {
		return Double.parseDouble(answer1);
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public double getAnswer2() {
		return Double.parseDouble(answer2);
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	
	
	public void addAnswer(double answer) {
		answers.add(answer);
	}
	
	public void removeAnswer(double answer){
		answers.remove(Double.valueOf(answer));
	}
	
	public List<Double> getAnswers(){
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
		return "name: "+ name +", question: "+question+", answer1: "+answer1+", answer2: "+answer2;
	}
}
