package Duke.Commands;

import Duke.Exceptions.EmptyDeleteException;
import Duke.Exceptions.EmptyDoneException;
import Duke.Exceptions.EmptyTaskException;
import Duke.Exceptions.UnsureMeaningException;
import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

public class IncorrectCommand extends Command {

    private String details;

    public IncorrectCommand(String details) {
        this.details = details;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws EmptyDoneException,
            EmptyDeleteException, EmptyTaskException, UnsureMeaningException {
        switch(details) {
        case "empty done":
            throw new EmptyDoneException();
        case "empty delete":
            throw new EmptyDeleteException();
        case "empty task":
            throw new EmptyTaskException();
        case "unsure":
            throw new UnsureMeaningException();
        }
    }
}
