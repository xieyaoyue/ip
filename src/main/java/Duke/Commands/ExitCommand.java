package Duke.Commands;

import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

public class ExitCommand extends Command {

    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        ui.showGoodbyeMessage();
    }

    public boolean isExit() {
        return true;
    }
}
