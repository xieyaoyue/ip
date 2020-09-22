package Duke.Exceptions;

/**
 * Signals that some error has occurred while creating storage file,
 * or trying to read/write data between the application and the storage file.
 */
public class StorageOperationException extends DukeException {
    private String errorMessage;
    public StorageOperationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getMessage() {
        return errorMessage;
    }
}
