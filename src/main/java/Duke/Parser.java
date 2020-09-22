package Duke;

import Duke.Commands.*;

/**
 * Parses user input.
 */
public class Parser {

    /**
     * Parses user input into command for execution.
     * @param userInput full user input string.
     * @return the command based on the user input.
     */
    public static Command parseCommand(String userInput) {

        // trims the input of all leading and trailing spaces so that command can be captured accurately
        userInput = userInput.trim();

        // input on type of task should be case-insensitive
        String lowerCaseInput = userInput.toLowerCase();

        Command c;
        switch (lowerCaseInput) {
        case "done":
            c = new IncorrectCommand("empty done");
            return c;
        case "delete":
            c = new IncorrectCommand("empty delete");
            return c;
        case "find":
            c = new IncorrectCommand("empty find");
            return c;
        case "todo":
        case "event":
        case "deadline":
            c = new IncorrectCommand("empty task");
            return c;
        }
        String[] words = userInput.split(" ", 2);
        if(lowerCaseInput.equals("list")) {
            c = new ListCommand();
        } else if(lowerCaseInput.startsWith("find")) {
            c = new FindCommand(words[1]);
        } else if(lowerCaseInput.startsWith("done")) {
            c = new DoneCommand(words[1]);
        } else if(lowerCaseInput.startsWith("delete")) {
            c = new DeleteCommand(words[1]);
        } else if(lowerCaseInput.startsWith("todo")) {
            c = new AddCommand("todo", words[1]);
        } else if(lowerCaseInput.startsWith("event")) {
            c = new AddCommand("event", words[1]);
        } else if(lowerCaseInput.startsWith("deadline")) {
            c = new AddCommand("deadline", words[1]);
        } else if(!lowerCaseInput.equals("bye")) {
            c = new IncorrectCommand("unsure");
        } else {
            c = new ExitCommand();
        }
        return c;
    }
}
