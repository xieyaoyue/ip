package Duke.Exceptions;

public class NoDueTimeException extends DukeException {
    public String getMessage() {
        return "Please specify the due time.";
    }
}
