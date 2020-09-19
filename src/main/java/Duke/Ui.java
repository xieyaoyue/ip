package Duke;

import java.util.Scanner;


public class Ui {

    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    private static final String MESSAGE_USING_STORAGE_FILE = "Using storage file : %1$s";
    private static final String MESSAGE_WELCOME = "Hello! I'm Duke.\nWhat can I do for you?";
    private static final String MESSAGE_GOODBYE = "Bye. Hope to see you again soon!";
    private static final String MESSAGE_ADD = "Got it. I've added this task:\n %1$s";
    private static final String MESSAGE_DONE = "Nice! I've marked this task as done:\n %1$s";
    private static final String MESSAGE_DELETE = "Noted. I've removed this task:\n %1$s";
    private static final String MESSAGE_CURRENT_STATUS = "Now you have %1$d %2$s in the list.";
    private static final String MESSAGE_EMPTY_LIST = "List is empty.";
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readCommand() {
        return in.nextLine();
    }

    public void showWelcomeMessage(String filePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, filePath);
        showToUser(LOGO, MESSAGE_WELCOME, storageFileInfo);
    }

    public void showGoodbyeMessage() {
        showToUser(MESSAGE_GOODBYE);
    }

    public void showError(String errorMessage) {
        showToUser(errorMessage);
    }

    public void showTaskList(TaskList tasklist) {
        int totalTasks = tasklist.getTotalTasks();
        if(totalTasks==0) {
            showToUser(MESSAGE_EMPTY_LIST);
        } else {
            showToUser(getTaskList(tasklist));
        }
    }

    public void showAdd(TaskList tasklist) {
        int totalTasks = tasklist.getTotalTasks();
        String addInfo = String.format(MESSAGE_ADD, tasklist.getTask(totalTasks-1));
        showToUser(addInfo);
    }

    public void showDone(TaskList tasklist, int doneNumber) {
        String doneInfo = String.format(MESSAGE_DONE, tasklist.getTask(doneNumber));
        showToUser(doneInfo);
    }

    public void showDelete(TaskList tasklist, int deleteNumber) {
        String deleteInfo = String.format(MESSAGE_DELETE, tasklist.getTask(deleteNumber));
        int totalTasks = tasklist.getTotalTasks() - 1;
        String currentStatus = String.format(MESSAGE_CURRENT_STATUS, totalTasks,
                (totalTasks==1 || totalTasks==0)? "task" : "tasks");
        showToUser(deleteInfo, currentStatus);
    }

    private String getTaskList(TaskList tasklist) {
        final StringBuilder formattedList = new StringBuilder();
        int totalTasks = tasklist.getTotalTasks();
        int taskNumber;
        for(taskNumber = 0; taskNumber < totalTasks-1; taskNumber++) {
            formattedList.append(taskNumber + 1).append(".").append(tasklist.tasks.get(taskNumber)).append("\n");
        }
        formattedList.append(taskNumber + 1).append(".").append(tasklist.tasks.get(taskNumber));
        return formattedList.toString();
    }
    public void showToUser(String... message) {
        for(String m : message) {
            System.out.println(m);
        }
    }
}
