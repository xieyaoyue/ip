package Duke;

import Duke.Exceptions.*;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.util.Scanner;

public class Duke {

    public static final int MAX_TASK = 100;
    private static Task[] tasks = new Task[MAX_TASK];
    private static int totalTasks = 0;

    public static void addTodo(String task) {
        tasks[totalTasks] = new Todo(task);
    }

    public static void addEvent(String task) {
        String[] words = task.split("/at");
        tasks[totalTasks] = new Event(words[0], words[1]);
    }

    public static void addDeadline(String task) {
        String[] words = task.split("/by");
        tasks[totalTasks] = new Deadline(words[0], words[1]);
    }

    public static void updateDone(int updateNumber) {
        tasks[updateNumber].markAsDone();
    }

    public static void printList() {
        if(totalTasks==0) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for(int taskNumber = 0; taskNumber < totalTasks; taskNumber++) {
            System.out.println(taskNumber + 1 + "." + tasks[taskNumber]);
        }
    }

    public static void printDone(int updateNumber) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks[updateNumber]);
    }

    public static void printTaskUpdate() {
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks[totalTasks]);
        totalTasks++;
        System.out.println((totalTasks==1)? "Now you have 1 task in the list." : "Now you have " + totalTasks + " tasks in the list.");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        System.out.println("Hello! I'm Duke.");
        System.out.println("What can I do for you?");
        String command;
        String lowerCaseCommand;
        do {
            Scanner in = new Scanner(System.in);
            command = in.nextLine();

            // remove all unnecessary spaces in input
            command = command.trim();

            // input on type of task should be case-insensitive
            lowerCaseCommand = command.toLowerCase();

            try {
                if(lowerCaseCommand.equals("done")) {
                    throw new EmptyDoneException();
                } else if (lowerCaseCommand.equals("todo") || lowerCaseCommand.equals("event") || lowerCaseCommand.equals("deadline")) {
                    throw new EmptyTaskException();
                }
            } catch (DukeException e) {
                continue;
            }
            if(lowerCaseCommand.equals("list")) {
                printList();
            } else if(lowerCaseCommand.startsWith("done")) {
                String[] words = command.split(" ");
                int updateNumber = Integer.parseInt(words[1]) - 1;
                try {
                    if (!(updateNumber >= 0 && updateNumber < totalTasks)) {
                        throw new InvalidDoneNumberException();
                    }
                } catch (DukeException e) {
                    continue;
                }
                updateDone(updateNumber);
                printDone(updateNumber);
            } else if(lowerCaseCommand.startsWith("todo")) {
                addTodo(command.substring(5));
                printTaskUpdate();
            } else if(lowerCaseCommand.startsWith("deadline")) {
                String task = command.substring(9);
                try {
                    if (!command.matches("(.*)/by(.*)") || command.matches("(.*)/by")) {
                        throw new NoDueTimeException();
                    }
                } catch(DukeException e) {
                    continue;
                }
                addDeadline(task);
                printTaskUpdate();
            } else if(lowerCaseCommand.startsWith("event")) {
                String task = command.substring(6);
                try {
                    if (!command.matches("(.*)/at(.*)") || command.matches("(.*)/at")) {
                        throw new NoEventTimeException();
                    }
                } catch(DukeException e){
                    continue;
                }
                addEvent(task);
                printTaskUpdate();
            } else if(!lowerCaseCommand.equals("bye")) {
                try {
                    throw new UnsureMeaningException();
                } catch(DukeException ignored) {
                }
            }
        } while(!lowerCaseCommand.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
}