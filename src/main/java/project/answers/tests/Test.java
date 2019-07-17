package project.answers.tests;

import java.io.File;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8729209678450935222L;
	private File file;
	private String name;
	private String question;
	private double answer1;
	private double answer2;
	private double studentAnswer;
	private List<Double> answers;

	public Test(File file, String name, String question, double answer1, double answer2) {
		this.file = file;
		this.name = name;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		answers= new ArrayList<>();
	}
	
	public Test(){
		answers= new ArrayList<>();
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
		return answer1;
	}

	public void setAnswer1(double answer1) {
		this.answer1 = answer1;
	}

	public double getAnswer2() {
		return answer2;
	}

	public void setAnswer2(double answer2) {
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
