package Duke.Task;

import Duke.Duke;

public class Task {
    protected String description;
    protected boolean isDone;

    public void markAsDone() {
        this.isDone = true;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String storeString() {
        return " | " + (isDone? "1":"0") + " | " + description;
    }
}
