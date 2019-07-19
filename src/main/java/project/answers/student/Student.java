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
	
	public Student(String studName, String fileName, int score){
	//	this.studentAnswers = studentAnswers;
		this.studName = studName;
		this.score = score;
		this.fileName = fileName;
	}
	
	public String getTrueAnswers(int place) {
		return trueAnswers[place];
	}
	
	public void setTrueAnswers(String trueAnswer, int place) {
		//for(int i = 0; i<ammount; i++){
			this.trueAnswers[place] = trueAnswer;
	//	}
		
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
		return "Student [studName=" + studName + ", score=" + score + ", fileName=" + fileName + "]";
	}
	
/*	public void setScore(int score) {
		this.score = score;
	}*/
	
	
	
	
	
}
