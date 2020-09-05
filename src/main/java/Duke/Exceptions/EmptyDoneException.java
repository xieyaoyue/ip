package Duke.Exceptions;

public class EmptyDoneException extends DukeException {
    public EmptyDoneException() {
        System.out.println("I'm sorry, but I don't know which task you've completed :-(");
    }
}
