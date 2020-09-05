package Duke.Exceptions;

public class InvalidDoneNumberException extends DukeException {
    public InvalidDoneNumberException() {
        System.out.println("There's no such task :-(");
    }
}
