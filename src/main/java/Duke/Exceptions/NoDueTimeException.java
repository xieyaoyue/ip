package Duke.Exceptions;

/**
 * Signals that the user did not specify the due time of a deadline.
 */
public class NoDueTimeException extends DukeException {
    public String getMessage() {
        return "Please specify the due time.";
    }
}
