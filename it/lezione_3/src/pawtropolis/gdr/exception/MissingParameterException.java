package pawtropolis.gdr.exception;

public class MissingParameterException extends CommandExecutionException {
	public MissingParameterException() {
		super();
	}
	public MissingParameterException(String message) {
		super(message);
	}

	public MissingParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
