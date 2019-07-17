package project.answers.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestController {

	private static TestController instance = null;
	List<Test> tests;

	private TestController() {
		tests = new LinkedList<Test>();
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
		return test;
	}

	public void addTest(Test test) {
		tests.add(test);
		saveTests();
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
