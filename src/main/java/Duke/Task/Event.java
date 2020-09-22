package Duke.Task;

/**
 * Represents an event in the task list.
 */
public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    public String toString() {
        return "[E]" + super.toString() + "(at:" + at + ")";
    }

    public String storeString() {
        return "E" + super.storeString() + " |" + at;
    }
}
