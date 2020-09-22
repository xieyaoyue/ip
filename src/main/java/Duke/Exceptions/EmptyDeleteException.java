package Duke.Exceptions;

public class EmptyDeleteException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know which task you want to delete :-(";
    }
}
