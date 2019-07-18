package project.answers.student;

import java.util.ArrayList;
import java.util.List;

import project.answers.tests.Test;

public class Student {
    private String[] trueAnswers = new String[2];
    private float[] studentAnswers;
    private final String studName;
    private final int score;
    private String fileName;
    private List<Test> tests;

    public Student(String studName, String fileName, int score){
        this.studName = studName;
        this.score = score;
        this.fileName = fileName;
        tests = new ArrayList<>();
    }

    public List<Test> getTests() {
		return tests;
	}
    

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public String getTrueAnswers(int place) {
        return trueAnswers[place];
    }

    public void setTrueAnswers(String trueAnswer, int place) {
            this.trueAnswers[place] = trueAnswer;

    }
    public void setTrueAnswers(){

    }
    
    public String getFiliename(){
    	return fileName;
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

/*    public void setStudName(String studName) {
        this.studName = studName;
    }/

    public int getScore() {
        return score;
    }

/    public void setScore(int score) {
        this.score = score;
    }*/





}