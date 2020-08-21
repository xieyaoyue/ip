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
        String[] list = new String[100];
        int listNumber = 0;
        do {
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            System.out.println(line);
            if(line.equals("list")) {
                for (int i = 0; i < listNumber; i++) {
                    System.out.println(i + 1 + ". " + list[i]);
                }
            } else if(!line.equals("bye")) {
                list[listNumber] = line;
                System.out.println("added: " + line);
                listNumber++;
            }
        } while(!line.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
}
