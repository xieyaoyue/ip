package Duke.Commands;

import Duke.Exceptions.*;
import Duke.TaskList;
import Duke.Ui;
import Duke.Storage;

/**
 * Represents the command that the user wants the program to execute.
 */
public abstract class Command {

    /**
     * Executes a command.
     * Saves task list after a command is executed.
     * Throws exceptions if the command is invalid or there is problem saving task list.
     */
    public abstract void execute(TaskList tasklist, Ui ui, Storage storage) throws
            NoEventTimeException, NoDueTimeException, InvalidDeleteNumberException,
            EmptyDoneException, EmptyDeleteException, EmptyTaskException,
            UnsureMeaningException, InvalidDoneNumberException, StorageOperationException,
            EmptyFindException;

    /**
     * @return true if the user wants to end program, false if otherwise.
     * Default return value is false, unless the gives the 'bye' command.
     */
    public boolean isExit() {
        return false;
    }
}
