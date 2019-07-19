package project.answers.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import project.answers.student.Student;

public class TestController {

	private static TestController instance = null;
	public List<Test> tests;
	public List<Student> students;

	private TestController() {
		tests = new ArrayList<>();
		students = new ArrayList<>();
		loadTests();
	}

	public static TestController getInstance() {
		if (instance == null) {
			instance = new TestController();
		}
		return instance;

	}

	public Test getTest(String name) {
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

	public void addTest(Test test) {
		tests.add(test);
		saveTests();
	}
	
	public void AddStudent(Student student){
		students.add(student);
		saveTests();
	}

	@SuppressWarnings("unchecked")
	public void loadTests() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list"))) {
			tests = (List<Test>) ois.readObject();
			students= (List<Student>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveTests() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list"))) {
			oos.writeObject(tests);
			oos.writeObject(students);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestController tc = TestController.getInstance();
		tc.addTest(new Test(null, "name", "question", "123", "123"));
		tc.AddStudent(new Student("janis", "name", 2));
	}
	
	
}
