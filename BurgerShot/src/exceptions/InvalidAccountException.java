package exceptions;

public class InvalidAccountException extends Exception {

	/**
	 * random generated serial version uid
	 */
	private static final long serialVersionUID = 6792543878168050183L;
	
	public InvalidAccountException() {
		super();
	}
	
	public InvalidAccountException(String errorMessage) {
		super(errorMessage);
	}

}
