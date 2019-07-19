package project.answers.customExceptions;

public class MultiStudentNameException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6511591641916243505L;

	public MultiStudentNameException(String e) {
		System.err.println("Dublicated students in test" + e);
	}
	
}
