package Duke.Exceptions;

public class StorageOperationException extends DukeException {
    private String errorMessage;
    public StorageOperationException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getMessage() {
        return errorMessage;
    }
}
