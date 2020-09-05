package Duke.Exceptions;

public class NoEventTimeException extends DukeException{
    public NoEventTimeException() {
        System.out.println("Please specify the event time.");
    }
}
