package Duke.Exceptions;

public class EmptyDeleteException extends DukeException {
    public EmptyDeleteException() {
        System.out.println("I'm sorry, but I don't know which task you want to delete :-(");
    }
}
