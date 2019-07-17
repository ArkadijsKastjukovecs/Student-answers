package project.answers.student;


public class Student {
	private String[] trueAnswers = new String[2];
	private float[] studentAnswers;
	private String studName;
	private int score;
	
	public Student(float[] studentAnswers, String studName){
		this.studentAnswers = studentAnswers;
		this.studName = studName;
		score = 0;
	}
	
	public Student(){
		score = 0;
	}
	
	public String getTrueAnswers(int place) {
		return trueAnswers[place];
	}
	
	public void setTrueAnswers(String trueAnswer, int place) {
		//for(int i = 0; i<ammount; i++){
			this.trueAnswers[place] = trueAnswer;
	//	}
		
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
	
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
}
