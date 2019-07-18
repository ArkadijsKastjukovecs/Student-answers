package project.answers.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.bytebuddy.asm.Advice.This;
import project.answers.student.Student;

public class TestController {

	private static TestController instance = null;
	List<Test> tests;
	List<Student> students;

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
			if ((test = iterator.next()).getName().equals(name))
				return test;
		}
		return new Test();
	}
	
	public Student getStudent(String name) {
		Student student = null;
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			if ((student = iterator.next()).getStudName().equals(name))
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
	}

	@SuppressWarnings("unchecked")
	public void loadTests() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list"))) {
			tests = (List<Test>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveTests() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list"))) {
			oos.writeObject(tests);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
