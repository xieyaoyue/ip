package Duke.Exceptions;

public class NoEventTimeException extends DukeException {
    public String getMessage() {
        return "Please specify the event time.";
    }
}
