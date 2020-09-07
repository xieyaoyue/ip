package Duke.Exceptions;

public class InvalidDeleteNumberException extends DukeException{
    public InvalidDeleteNumberException() {
        System.out.println("There's no such task :-(");
    }
}
