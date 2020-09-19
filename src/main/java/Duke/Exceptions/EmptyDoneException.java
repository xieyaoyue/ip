package Duke.Exceptions;

public class EmptyDoneException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know which task you've completed :-(";
    }
}
