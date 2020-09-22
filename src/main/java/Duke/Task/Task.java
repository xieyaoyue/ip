package Duke.Task;

/**
 * Represents a task in the task list.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Marks a task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * @return tick or X symbol based on whether the task is marked as done.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Stores the task in the storage file based on a given format.
     */
    public String storeString() {
        return " | " + (isDone? "1":"0") + " | " + description;
    }
}
