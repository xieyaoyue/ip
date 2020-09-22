package Duke.Exceptions;

public class InvalidDeleteNumberException extends DukeException{
    public String getMessage() {
        return "There's no such task :-(";
    }
}
