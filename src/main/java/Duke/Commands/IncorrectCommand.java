package Duke.Commands;

import Duke.Exceptions.*;
import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

/**
 * Represents an incorrect command.
 */
public class IncorrectCommand extends Command {

    private String details;

    public IncorrectCommand(String details) {
        this.details = details;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws EmptyDoneException,
            EmptyDeleteException, EmptyTaskException, UnsureMeaningException,
            EmptyFindException {
        switch(details) {
        case "empty done":
            throw new EmptyDoneException();
        case "empty delete":
            throw new EmptyDeleteException();
        case "empty find":
            throw new EmptyFindException();
        case "empty task":
            throw new EmptyTaskException();
        case "unsure":
            throw new UnsureMeaningException();
        }
    }
}
