package Duke.Commands;

import Duke.Exceptions.InvalidDoneFormatException;
import Duke.Exceptions.InvalidDoneNumberException;
import Duke.Exceptions.StorageOperationException;
import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

/**
 * Marks a task as done using its last displayed index from the task list.
 */
public class DoneCommand extends Command {

    private String details;

    public DoneCommand(String details) {
        this.details = details;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws InvalidDoneNumberException,
            StorageOperationException, InvalidDoneFormatException {
        int doneNumber;
        try {
            doneNumber = Integer.parseInt(details) - 1;
        } catch(NumberFormatException e) {
            throw new InvalidDoneFormatException();
        }
        int totalTasks = tasklist.getTotalTasks();
        if (!(doneNumber >= 0 && doneNumber < totalTasks)) {
            throw new InvalidDoneNumberException();
        }
        tasklist.updateDone(doneNumber);
        ui.showDone(tasklist, doneNumber);
        storage.save(tasklist);
    }
}
