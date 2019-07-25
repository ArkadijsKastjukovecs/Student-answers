package project.answers.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.answers.customExceptions.MultiFileNameException;
import project.answers.customExceptions.MultiStudentNameException;
import project.answers.customExceptions.MultiTestNameException;
import project.answers.student.Student;

public class TestController {

	private static TestController instance = null;
	private List<Test> tests;
	private List<Student> students;
	private Test active = null;

	private TestController() {
		tests = new ArrayList<>();
		students = new ArrayList<>();
		loadTests();
	}

	public static TestController getInstance() {
		if (instance == null) {
			instance = new TestController();
			File directory = new File("./tests");
	        if (!directory.exists() && !directory.mkdirs()) {
	        	System.err.println("Map wasn't created");
	        }
		}
		return instance;

	}
	
	public Student deleteLastStudent(){
		return students.remove(students.size()-1);
	}

	public void SetActiveTest(Test test) {
		active = test;
	}

	public Test getActiveTest() {
		System.out.println(active);
		return active;
	}

	public List<Test> showAllTests() {
		return tests;
	}
	
	public List<Student> findStudentsByTest(Test test){
		List<Student>studentsInTest = new ArrayList<>();
		for (Student std:showAllStudents())
			if (test.getName().equalsIgnoreCase(std.getFileName()))
				studentsInTest.add(std);
		return studentsInTest;
	}
	
	public List<Student> findStudentsByTest(String test){
		List<Student> studentInTest = new ArrayList<>();
		for (Student std:showAllStudents())
			if (test.equalsIgnoreCase(std.getFileName()))
				studentInTest.add(std);
		return studentInTest;
				
	}
	
	
	public List<Student> showAllStudents() {
		return students;
	}

	public Test getTest(String name) {
		for (Test tst : tests)
			System.out.println(tst);
		Test test = null;
		Iterator<Test> iterator = tests.iterator();
		while (iterator.hasNext()) {
			if ((test = iterator.next()).getName().equalsIgnoreCase(name))
				return test;
		}
		return new Test();
	}

	public Student getStudent(String name) {
		Student student = null;
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			if ((student = iterator.next()).getStudName().equalsIgnoreCase(name))
				return null;
		}
		return student;
	}

	public void addTest(Test test) throws MultiFileNameException, MultiTestNameException {
		for (Test tst : tests) {
			if (test.getName().equalsIgnoreCase(tst.getName()))
				throw new MultiTestNameException(tst.getName());
//			if (test.getFile().getName().equals(tst.getFile().getName()))
//				throw new MultiFileNameException(tst.getFile().getName());
		}
		tests.add(test);
		saveTests();
		for (Test tst : tests)
			System.out.println(tst);
	}

	public void AddStudent(Student student) throws MultiStudentNameException {
		for (Student std : students)
			if (std.getStudName().equalsIgnoreCase(student.getStudName())
					&& std.getFileName().equalsIgnoreCase(student.getFileName()))
				throw new MultiStudentNameException(std.getStudName() + ":" + std.getFileName());
		students.add(student);
		saveTests();
		System.out.println(student);
	}

	@SuppressWarnings("unchecked")
	public void loadTests() {
		try (ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("list"))) {
			tests = (List<Test>) ois.readObject();
			students = (List<Student>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveTests() {
		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("list"))) {
			oos.writeObject(tests);
			oos.writeObject(students);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws MultiFileNameException, MultiTestNameException, MultiStudentNameException {
		TestController tc = TestController.getInstance();
	}

}
