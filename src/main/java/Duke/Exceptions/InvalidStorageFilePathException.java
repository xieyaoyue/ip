package Duke.Exceptions;

/**
 * Signals that the given file path does not fulfill the storage filepath constraints.
 */
public class InvalidStorageFilePathException extends DukeException {
    public String getMessage() {
        return "Storage file should end with '.txt'";
    }
}
