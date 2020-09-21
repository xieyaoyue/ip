package Duke.Commands;

import Duke.Storage;
import Duke.Task.Task;
import Duke.TaskList;
import Duke.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) {
        ArrayList<Task> tasks = tasklist.findTasks(keyword);
        ui.showKeywordList(tasks);
    }
}
