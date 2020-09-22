package Duke.Commands;

import Duke.Exceptions.*;
import Duke.TaskList;
import Duke.Ui;
import Duke.Storage;

public abstract class Command {

    public abstract void execute(TaskList tasklist, Ui ui, Storage storage) throws
            NoEventTimeException, NoDueTimeException, InvalidDeleteNumberException,
            EmptyDoneException, EmptyDeleteException, EmptyTaskException,
            UnsureMeaningException, InvalidDoneNumberException, StorageOperationException,
            EmptyFindException;

    public boolean isExit() {
        return false;
    }
}
