package Duke;

import Duke.Exceptions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the file used to store task list data.
 */
public class Storage {
    private static final String HOME = System.getProperty("user.home");
    private static final String DEFAULT_FILEPATH = HOME + File.separator + "Documents"
            + File.separator + "CS2113T" + File.separator + "tasks.txt";
    public String filepath;

    /**
     * @throws InvalidStorageFilePathException if the default file path is invalid
     * @throws StorageOperationException if there is error in creating the storage file
     */
    public Storage() throws InvalidStorageFilePathException, StorageOperationException {
        this(DEFAULT_FILEPATH);
    }

    /**
     * @throws InvalidStorageFilePathException if the given file path is invalid
     * @throws StorageOperationException if there is error in creating the storage file
     */
    public Storage(String filePath) throws InvalidStorageFilePathException, StorageOperationException {
        this.filepath = filePath;
        if(!isValidPath(filePath)) {
            throw new InvalidStorageFilePathException();
        }
        try {
            File file = new File(filepath);
            boolean hasParent = file.getParentFile() != null;
            if(hasParent) {
                file.getParentFile().mkdir();
            }
            file.createNewFile();
        } catch(IOException e) {
            throw new StorageOperationException("Error creating file: " + filepath);
        }
    }


    /**
     * File path is considered valid if it ends with '.txt'
     * Returns true if the given path is acceptable as a storage file.
     */
    private static boolean isValidPath(String filePath) {
        return filePath.endsWith(".txt");
    }

    /**
     * @return task list data loaded from the storage file.
     * @throws StorageOperationException if storage file is not found.
     */
    public TaskList load() throws StorageOperationException {
        TaskList tasks;
        tasks = decodeFile();
        return tasks;
    }

    /**
     * Decodes the storage file and stores data into a new task list
     * @return task list with the stored data
     * @throws StorageOperationException if storage file is not found
     */
    private TaskList decodeFile() throws StorageOperationException {
        File f = new File(filepath);
        TaskList tasklist = new TaskList();
        try {
            Scanner s = new Scanner(f);
            int totalTasks = 0;
            while (s.hasNext()) {
                String thisLine = s.nextLine();
                String[] words = thisLine.split("\\|", 4);
                switch (words[0].trim()) {
                case "T":
                    tasklist.addTodo(words[2].trim());
                    break;
                case "E":
                    tasklist.addEvent(words[2].trim(), words[3].trim());
                    break;
                case "D":
                    tasklist.addDeadline(words[2].trim(), words[3].trim());
                    break;
                default:
                    System.out.println("This line is not added to list:" + thisLine);
                }
                if (Integer.parseInt(words[1].trim()) == 1) {
                    tasklist.updateDone(totalTasks);
                }
                totalTasks++;
            }
        } catch(FileNotFoundException e) {
            throw new StorageOperationException("Error finding storage file: " + filepath);
        }
        return tasklist;
    }

    /**
     * Saves the task list data into the storage file.
     * @throws StorageOperationException if there were errors storing data to the file.
     */
    public void save(TaskList tasklist) throws StorageOperationException {
        try {
            FileWriter fw = new FileWriter(filepath);
            int totalTasks = tasklist.getTotalTasks();
            for (int i = 0; i < totalTasks; ++i) {
                fw.write(tasklist.getTask(i).storeString() + "\n");
            }
            fw.close();
        } catch(IOException e) {
            throw new StorageOperationException("Error writing to file: " + filepath);
        }
    }
}
