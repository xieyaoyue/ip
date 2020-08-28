import java.util.Scanner;

public class Duke {

    private static Task[] tasks = new Task[100];
    private static int totalTasks = 0;

    public static void printList() {
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
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line;
        do {
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if(line.equals("list")) {
                printList();
            } else if(line.startsWith("done")) {
                String[] words = line.split(" ");
                int updateNumber = Integer.parseInt(words[1])-1;
                if(updateNumber>=0 && updateNumber<totalTasks) {
                    tasks[updateNumber].markAsDone();
                    printDone(updateNumber);
                }
            } else if(line.startsWith("todo")) {
                tasks[totalTasks] = new Todo(line.substring(5));
                printTaskUpdate();
            } else if(line.startsWith("deadline")) {
                line = line.substring(9);
                String[] words = line.split("/by");
                tasks[totalTasks] = new Deadline(words[0], words[1]);
                printTaskUpdate();
            } else if(line.startsWith("event")) {
                line = line.substring(6);
                String[] words = line.split("/at");
                tasks[totalTasks] = new Event(words[0], words[1]);
                printTaskUpdate();
            }
        } while(!line.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
}