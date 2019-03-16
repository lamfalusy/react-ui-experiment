package hu.lamsoft.experiment.springmvc.taskman.dao.impl.exception;

public class RecordDoesNotExistDaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordDoesNotExistDaoException() {
		// Nothing to do here
	}
	
	public RecordDoesNotExistDaoException(String message) {
		super(message);
	}
	
}
