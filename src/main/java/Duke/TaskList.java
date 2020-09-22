package Duke;

import java.util.ArrayList;
import Duke.Task.*;

public class TaskList {

    private ArrayList<Task> tasks = new ArrayList<>();
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

    public ArrayList<Task> findTasks(String keyword) {
        boolean hasKeyword;
        ArrayList<Task> keywordTasks = new ArrayList<>();
        for(Task task: tasks) {
            hasKeyword = false;
            if(task.getDescription().contains(keyword)) {
                hasKeyword = true;
            } else if(task instanceof Event) {
                Event event = (Event) task;
                if(event.getAt().contains(keyword)) {
                    hasKeyword = true;
                }
            } else if(task instanceof Deadline) {
                Deadline deadline = (Deadline) task;
                if(deadline.getBy().contains(keyword)) {
                    hasKeyword = true;
                }
            }
            if(hasKeyword) {
                keywordTasks.add(task);
            }
        }
        return keywordTasks;
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }

    public int getTotalTasks() {
        return totalTasks;
    }
}
