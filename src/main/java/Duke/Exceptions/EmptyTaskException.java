package Duke.Exceptions;

/**
 * Signals that the user didn't specify the details of the task.
 */
public class EmptyTaskException extends DukeException{
    public String getMessage() {
        return "The description of a task cannot be empty.";
    }
}
