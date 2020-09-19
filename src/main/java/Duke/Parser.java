package Duke;

public class Parser {
    public static Command parseCommand(String userInput) {
        Command c = new Command();

        // remove all unnecessary spaces in input
        userInput = userInput.trim();

        // input on type of task should be case-insensitive
        String lowerCaseInput = userInput.toLowerCase();
        switch (lowerCaseInput) {
        case "done":
            c.command = "empty done";
            return c;
        case "delete":
            c.command = "empty delete";
            return c;
        case "todo":
        case "event":
        case "deadline":
            c.command = "empty task";
            return c;
        }
        String[] words = userInput.split(" ", 2);
        if(lowerCaseInput.equals("list")) {
            c.command = "list";
        } else if(lowerCaseInput.startsWith("done")) {
            c.command = "done";
            c.details = words[1];
        } else if(lowerCaseInput.startsWith("delete")) {
            c.command = "delete";
            c.details = words[1];
        } else if(lowerCaseInput.startsWith("todo")) {
            c.command = "todo";
            c.details = words[1];
        } else if(lowerCaseInput.startsWith("event")) {
            c.command = "event";
            c.details = words[1];
        } else if(lowerCaseInput.startsWith("deadline")) {
            c.command = "deadline";
            c.details = words[1];
        } else if(!lowerCaseInput.equals("bye")) {
            c.command = "unsure";
        } else {
            c.command = "bye";
        }
        return c;
    }
}
