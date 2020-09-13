package Duke.Task;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + "(at:" + at + ")";
    }

    public String storeString() {
        return "E" + super.storeString() + " |" + at;
    }
}
