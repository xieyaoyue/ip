package Duke.Exceptions;

public class EmptyTaskException extends DukeException{
    public String getMessage() {
        return "The description of a task cannot be empty.";
    }
}
