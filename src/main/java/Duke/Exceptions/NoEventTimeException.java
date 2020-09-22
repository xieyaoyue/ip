package Duke.Exceptions;

/**
 * Signals that the user did not specify the event time of an event.
 */
public class NoEventTimeException extends DukeException {
    public String getMessage() {
        return "Please specify the event time.";
    }
}
