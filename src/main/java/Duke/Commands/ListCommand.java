package Duke.Commands;

import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

public class ListCommand extends Command {

    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        ui.showTaskList(tasklist);
    }
}
