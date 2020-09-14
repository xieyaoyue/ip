package Duke;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Duke.Exceptions.*;
import Duke.Task.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Duke {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int totalTasks = 0;

    private static final String home = System.getProperty("user.home");
    private static final String dirPath = home + File.separator + "Documents" + File.separator + "CS2113T";
    private static final String filePath = home + File.separator + "Documents" + File.separator + "CS2113T"
            + File.separator + "tasks.txt";

    private static void loadFile() {
        if(!new File(dirPath).exists()) {
            System.out.println("Folder does not exist yet.");
            File dir = new File(dirPath);
            if(dir.mkdir()) {
                System.out.println("New folder is created at this location: " + dirPath);
            } else {
                System.out.println("Oops! There's some problem in creating new folder.");
            }
        }
        try {
            readFileContents();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }
    }

    private static void readFileContents() throws FileNotFoundException {
        File f = new File(filePath);
        try {
            if(f.createNewFile()) {
                System.out.println("New file is created in the folder for storing task list.");
            }
        } catch(IOException e) {
            System.out.println("An error has occurred.");
        }
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String thisLine = s.nextLine();
            String[] words = thisLine.split("\\|", 4);
            switch(words[0].trim()) {
            case "T":
                tasks.add(new Todo(words[2].trim()));
                break;
            case "E":
                tasks.add(new Event(words[2].trim(), words[3].trim()));
                break;
            case "D":
                tasks.add(new Deadline(words[2].trim(), words[3].trim()));
                break;
            default:
                System.out.println("This line is not added to list:" + thisLine);
            }
            if(Integer.parseInt(words[1].trim())==1) {
                tasks.get(totalTasks).markAsDone();
            }
            totalTasks++;
        }
    }

    private static void saveTaskList() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for(int i = 0; i< totalTasks; ++i) {
            fw.write(tasks.get(i).storeString() + "\n");
        }
        fw.close();
    }

    private static void addTodo(String task) {
        tasks.add(new Todo(task));
    }

    private static void addEvent(String task) {
        String[] words = task.split("/at");
        tasks.add(new Event(words[0], words[1]));
    }

    private static void addDeadline(String task) {
        String[] words = task.split("/by");
        tasks.add(new Deadline(words[0], words[1]));
    }

    private static void updateDone(int updateNumber) {
        tasks.get(updateNumber).markAsDone();
    }

    private static void updateDelete(int deleteNumber) {
        tasks.remove(deleteNumber);
    }

    private static void printList() {
        if(totalTasks==0) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for(int taskNumber = 0; taskNumber < totalTasks; taskNumber++) {
            System.out.println(taskNumber + 1 + "." + tasks.get(taskNumber));
        }
    }

    private static void printDone(int updateNumber) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(updateNumber));
    }

    private static void printDelete(int deleteNumber) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.get(deleteNumber));
        totalTasks -= 1;
        System.out.println((totalTasks==1)? "Now you have 1 task in the list." : "Now you have " + totalTasks + " tasks in the list.");
    }

    private static void printUpdate() {
        System.out.println("Got it. I've added this task: ");
        System.out.println(tasks.get(totalTasks));
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
        loadFile();
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
                switch (lowerCaseCommand) {
                case "done":
                    throw new EmptyDoneException();
                case "delete":
                    throw new EmptyDeleteException();
                case "todo": case "event": case "deadline":
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
                try {
                    saveTaskList();
                } catch(IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
            } else if(lowerCaseCommand.startsWith("delete")) {
                String[] words = command.split(" ");
                int deleteNumber = Integer.parseInt(words[1]) - 1;
                try {
                    if (!(deleteNumber >= 0 && deleteNumber < totalTasks)) {
                        throw new InvalidDeleteNumberException();
                    }
                } catch (DukeException e) {
                    continue;
                }
                printDelete(deleteNumber);
                updateDelete(deleteNumber);
                try {
                    saveTaskList();
                } catch(IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
            } else if(lowerCaseCommand.startsWith("todo")) {
                addTodo(command.substring(5));
                printUpdate();
                try {
                    saveTaskList();
                } catch(IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
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
                printUpdate();
                try {
                    saveTaskList();
                } catch(IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
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
                printUpdate();
                try {
                    saveTaskList();
                } catch(IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
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