package Duke.Exceptions;

public class EmptyFindException extends DukeException {
    public String getMessage() {
        return "I'm sorry, but I don't know what is your search keyword :-(";
    }
}
