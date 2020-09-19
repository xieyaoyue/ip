package Duke.Commands;

import Duke.Exceptions.NoDueTimeException;
import Duke.Exceptions.NoEventTimeException;
import Duke.Exceptions.StorageOperationException;
import Duke.Ui;
import Duke.TaskList;
import Duke.Storage;

public class AddCommand extends Command {

    private String taskType;
    private String details;

    public AddCommand(String typeTask, String details) {
        this.taskType = typeTask;
        this.details = details;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws NoEventTimeException,
            NoDueTimeException, StorageOperationException {
        String[] words;
        switch(taskType) {
        case "todo":
            tasklist.addTodo(details);
            ui.showAdd(tasklist);
            break;
        case "event":
            if (!details.matches("(.*)/at(.*)") || details.matches("(.*)/at")) {
                throw new NoEventTimeException();
            }
            words = details.split("/at");
            tasklist.addEvent(words[0], words[1]);
            ui.showAdd(tasklist);
            break;
        case "deadline":
            if (!details.matches("(.*)/by(.*)") || details.matches("(.*)/by")) {
                throw new NoDueTimeException();
            }
            words = details.split("/by");
            tasklist.addDeadline(words[0], words[1]);
            ui.showAdd(tasklist);
            break;
        }
        storage.save(tasklist);
    }
}
