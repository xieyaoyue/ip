package Duke.Exceptions;

/**
 * Signals that the user didn't specify which task to mark as done.
 */
public class EmptyDoneException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know which task you've completed :-(";
    }
}
