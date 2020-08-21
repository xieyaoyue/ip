import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String line;
        Task[] tasks = new Task[100];
        int totalTasks=0;
        do {
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            if(line.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int taskNumber = 0; taskNumber < totalTasks; taskNumber++) {
                    System.out.println(taskNumber + 1 + ".[" + tasks[taskNumber].getStatusIcon() + "] " + tasks[taskNumber].description);
                }
            } else if(line.startsWith("done")) {
                String[] words = line.split(" ");
                int updateNumber = Integer.parseInt(words[1])-1;
                if(updateNumber>=0 && updateNumber<totalTasks) {
                    tasks[updateNumber].markAsDone();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println("[" + tasks[updateNumber].getStatusIcon() + "] " + tasks[updateNumber].description);
                }
            } else if(!line.equals("bye")){
                tasks[totalTasks] = new Task(line);
                System.out.println("added: " + line);
                totalTasks++;
            }
        } while(!line.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
}