package Duke.Exceptions;

public class NoDueTimeException extends DukeException{
    public NoDueTimeException() {
        System.out.println("Please specify the due time.");
    }
}
