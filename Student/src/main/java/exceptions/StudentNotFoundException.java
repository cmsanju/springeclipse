package exceptions;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(int id) {
		super("Could not find student with id: " + id);
	}
}
