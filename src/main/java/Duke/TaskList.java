package Duke;

import java.util.ArrayList;
import Duke.Task.*;

public class TaskList {

    public ArrayList<Task> tasks = new ArrayList<>();
    private int totalTasks = 0;

    public void updateDone(int doneNumber) {
        tasks.get(doneNumber).markAsDone();
    }

    public void updateDelete(int deleteNumber) {
        tasks.remove(deleteNumber);
        totalTasks--;
    }

    public void addTodo(String task) {
        tasks.add(new Todo(task));
        totalTasks++;
    }

    public void addEvent(String task, String at) {
        tasks.add(new Event(task, at));
        totalTasks++;
    }

    public void addDeadline(String task, String by) {
        tasks.add(new Deadline(task, by));
        totalTasks++;
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public int getTotalTasks() {
        return totalTasks;
    }
}
