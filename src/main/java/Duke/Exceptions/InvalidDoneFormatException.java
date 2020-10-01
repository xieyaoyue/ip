package Duke.Exceptions;

/**
 * Signals that the details for the 'done' command is in the wrong format.
 */
public class InvalidDoneFormatException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but your 'done' detail is in the wrong format :-(";
    }
}
