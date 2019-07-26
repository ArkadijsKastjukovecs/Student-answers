package project.answers.student;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5995723307371367223L;
	private String[] trueAnswers = new String[2];
	private float[] studentAnswers;
	private final String studName;
	private final int score;
	private String fileName;
	private String ans1;
	private String ans2;
	
	public Student(String studName, String fileName, int score, String ans1, String ans2){
	//	this.studentAnswers = studentAnswers;
		this.studName = studName;
		this.score = score;
		this.fileName = fileName;
		this.ans1 = ans1;
		this.ans2 = ans2;
		
	}
	
	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getTrueAnswers(int place) {
		return trueAnswers[place];
	}
	
	public void setTrueAnswers(String trueAnswer, int place) {
			this.trueAnswers[place] = trueAnswer;
		
	}
	public String getFileName(){
		return fileName;
	}
	public void setTrueAnswers(){
		
	}
	
	public float[] getStudentAnswers() {
		return studentAnswers;
	}
	
	public void setStudentAnswers(float[] studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	
	public String getStudName() {
		return studName;
	}
	
/*	public void setStudName(String studName) {
		this.studName = studName;
	}*/
	
	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [studName=" + studName + ", score=" + score + ", fileName=" + fileName + 
				"Answers: " + ans1 + " " + ans2 + "]";
	}
	
/*	public void setScore(int score) {
		this.score = score;
	}*/
	
	
	
	
	
}
