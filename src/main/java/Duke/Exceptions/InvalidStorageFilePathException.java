package Duke.Exceptions;

public class InvalidStorageFilePathException extends DukeException {
    public String getMessage() {
        return "Storage file should end with '.txt'";
    }
}
