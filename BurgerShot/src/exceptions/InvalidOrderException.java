package exceptions;

public class InvalidOrderException extends Exception {

	/**
	 * random servial version uid
	 */
	private static final long serialVersionUID = -752748794140123648L;
	
	public InvalidOrderException() {
		super();
	}
	
	public InvalidOrderException(String errorMessage) {
		super(errorMessage);
	}

}
