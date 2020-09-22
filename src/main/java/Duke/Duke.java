package Duke;

import Duke.Commands.*;
import Duke.Exceptions.*;

public class Duke {

    private static Ui ui;
    private static Storage storage;
    private static TaskList tasklist;

    private static void run(String[] args) {
        start(args);
        runCommandLoopUntilExitCommand();
        exit();
    }
    private static void start(String[] args) {
        ui = new Ui();
        try {
            storage = initializeStorage(args);
            tasklist = storage.load();
        } catch(DukeException e) {
            ui.showError(e.getMessage());
            System.exit(0);
        }
    }

    private static void runCommandLoopUntilExitCommand() {
        ui.showWelcomeMessage(storage.filepath);
        boolean isExit = false;
        do {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parseCommand(fullCommand);
                c.execute(tasklist, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        } while(!isExit);
    }

    private static void exit() {
        System.exit(0);
    }

    private static Storage initializeStorage(String[] Args) throws InvalidStorageFilePathException, StorageOperationException {
        boolean isStorageFileSpecifiedByUser = Args.length > 0;
        return isStorageFileSpecifiedByUser? new Storage(Args[0]) : new Storage();
    }

    public static void main(String[] Args) {
        run(Args);
    }
}