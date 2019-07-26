package project.answers.customExceptions;

public class MultiTestNameException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3311357285223721990L;

	public MultiTestNameException(String e) {
		System.err.println("Dublicated test name: " + e);
	}
	
	
}
