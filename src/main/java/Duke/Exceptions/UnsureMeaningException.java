package Duke.Exceptions;

/**
 * Signals that the user has keyed in a command that the application could not understand.
 */
public class UnsureMeaningException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know what that means :-(";
    }
}
