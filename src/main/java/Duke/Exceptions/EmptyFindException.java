package Duke.Exceptions;

/**
 * Signals that the user did not specify the keyword to search in the task list.
 */
public class EmptyFindException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know what is your search keyword :-(";
    }
}
