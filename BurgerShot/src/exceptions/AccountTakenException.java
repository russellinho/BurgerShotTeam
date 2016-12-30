package exceptions;

public class AccountTakenException extends Exception {

	/**
	 * random serial version uid
	 */
	private static final long serialVersionUID = 474171265905734867L;
	
	public AccountTakenException() {
		super();
	}
	
	public AccountTakenException(String errorMessage) {
		super(errorMessage);
	}
	
}
