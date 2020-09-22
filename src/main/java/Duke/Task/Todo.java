package Duke.Task;

/**
 * Represents a 'todo' task in the task list.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String storeString() {
        return "T" + super.storeString();
    }
}
