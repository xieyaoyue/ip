package Duke.Exceptions;

/**
 * Signals that the user didn't specify which task to delete.
 */
public class EmptyDeleteException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know which task you want to delete :-(";
    }
}
