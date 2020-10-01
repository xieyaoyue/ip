package Duke.Task;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Represents a deadline in the task list.
 */
public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;

        // If the user keys in the due time in the form of date of a particular format,
        // a different date format will be stored.
        try {
            LocalDateTime input = LocalDateTime.parse(by.trim(), DateTimeFormatter.ofPattern
                    ("yyyy-MM-dd HHmm"));
            this.by = input.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a").
                    withLocale(Locale.ENGLISH)); //e.g. input: 2020-01-01 1800, output: Jan 1 2020 6:00 PM
        } catch(DateTimeException ignored) { //do nothing if the due time input is not in the specified format
        }
    }

    public String getBy() {
        return by;
    }

    public String toString() {
        return "[D]" + super.toString() + " " + "(by: " + by + ")";
    }

    public String storeString() {
        return "D" + super.storeString() + " |" + by;
    }
}
