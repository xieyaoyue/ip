package Duke;

import Duke.Exceptions.*;

public class Command {

    public String command;
    public String details;

    public Command() {
        command = null;
        details = null;
    }

//    public void setCommand(String command) {
//        this.command = command;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }

    public void execute(TaskList tasklist, Ui ui, Storage storage) throws InvalidDoneNumberException,
            InvalidDeleteNumberException, UnsureMeaningException, EmptyDoneException,
            EmptyDeleteException, EmptyTaskException, NoDueTimeException, NoEventTimeException,
            StorageOperationException {
        int totalTasks = tasklist.getTotalTasks();
        String[] words;
        switch(command) {
        case "list":
            ui.showTaskList(tasklist);
            break;
        case "empty done":
            throw new EmptyDoneException();
        case "empty delete":
            throw new EmptyDeleteException();
        case "empty task":
            throw new EmptyTaskException();
        case "done":
            int doneNumber = Integer.parseInt(details) - 1;
            if (!(doneNumber >= 0 && doneNumber < totalTasks)) {
                throw new InvalidDoneNumberException();
            }
            tasklist.updateDone(doneNumber);
            ui.showDone(tasklist, doneNumber);
            break;
        case "delete":
            int deleteNumber = Integer.parseInt(details) - 1;
            if (!(deleteNumber >= 0 && deleteNumber < totalTasks)) {
                throw new InvalidDeleteNumberException();
            }
            ui.showDelete(tasklist, deleteNumber);
            tasklist.updateDelete(deleteNumber);
            break;
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
        case "bye":
            ui.showGoodbyeMessage();
            break;
        case "unsure":
            throw new UnsureMeaningException();
        }
        storage.save(tasklist);
    }

    public boolean isExit() {
        return command.equals("bye");
    }
}
