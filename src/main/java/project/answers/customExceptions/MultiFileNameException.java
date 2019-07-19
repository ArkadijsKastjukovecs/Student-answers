package project.answers.customExceptions;

public class MultiFileNameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5985682578004460878L;
	
	public MultiFileNameException(String e){
		System.err.println("Dublicated file name: " + e);
	}
	
}
