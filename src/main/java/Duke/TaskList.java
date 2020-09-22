package Duke;

import java.util.ArrayList;
import Duke.Task.*;

/**
 * Represents the entire task list.
 * Contains data of the task list.
 */
public class TaskList {

    public ArrayList<Task> tasks;
    private int totalTasks;

    /**
     * Creates an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
        totalTasks = 0;
    }

    /**
     * Marks a task as done.
     */
    public void updateDone(int doneNumber) {
        tasks.get(doneNumber).markAsDone();
    }

    /**
     * Deletes a task from the task list.
     */
    public void updateDelete(int deleteNumber) {
        tasks.remove(deleteNumber);
        totalTasks--;
    }

    /**
     * Adds a todo task into the task list.
     */
    public void addTodo(String task) {
        tasks.add(new Todo(task));
        totalTasks++;
    }

    /**
     * Adds an event into the task list.
     */
    public void addEvent(String task, String at) {
        tasks.add(new Event(task, at));
        totalTasks++;
    }

    /**
     * Adds a deadline into the task list.
     */
    public void addDeadline(String task, String by) {
        tasks.add(new Deadline(task, by));
        totalTasks++;
    }

    /**
     * @return the details of a task based on its latest index in the task list.
     */
    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    /**
     * @return the total number of tasks in the task list.
     */
    public int getTotalTasks() {
        return totalTasks;
    }
}
