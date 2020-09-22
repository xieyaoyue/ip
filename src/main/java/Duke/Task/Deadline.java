package Duke.Task;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;

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
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
            DateFormat outputFormat = new SimpleDateFormat(" MMM dd yyyy hh:mm aa");
            Date date = inputFormat.parse(by);
            this.by = outputFormat.format(date);
        } catch(ParseException ignored) {
        }
    }

    public String getBy() {
        return by;
    }

    public String toString() {
        return "[D]" + super.toString() + "(by:" + by + ")";
    }

    public String storeString() {
        return "D" + super.storeString() + " |" + by;
    }
}
