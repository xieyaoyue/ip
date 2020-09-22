package Duke.Commands;

import Duke.Exceptions.InvalidDeleteNumberException;
import Duke.Exceptions.StorageOperationException;
import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

public class DeleteCommand extends Command {

    private String details;

    public DeleteCommand(String details) {
        this.details = details;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws InvalidDeleteNumberException,
            StorageOperationException {
        int deleteNumber = Integer.parseInt(details) - 1;
        int totalTasks = tasklist.getTotalTasks();
        if (!(deleteNumber >= 0 && deleteNumber < totalTasks)) {
            throw new InvalidDeleteNumberException();
        }
        ui.showDelete(tasklist, deleteNumber);
        tasklist.updateDelete(deleteNumber);
        storage.save(tasklist);
    }
}
