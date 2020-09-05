package Duke.Exceptions;

public class EmptyTaskException extends DukeException{
    public EmptyTaskException() {
        System.out.println("The description of a task cannot be empty.");
    }
}
