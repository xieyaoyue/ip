package Duke.Exceptions;

/**
 * Signals that the user has wrongly declared the index of the task to delete.
 */
public class InvalidDeleteNumberException extends DukeException{
    public String getMessage() {
        return "There's no such task :-(";
    }
}
