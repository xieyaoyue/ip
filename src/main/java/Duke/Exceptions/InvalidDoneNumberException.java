package Duke.Exceptions;

public class InvalidDoneNumberException extends DukeException {
    public String getMessage() {
        return "There's no such task :-(";
    }
}
