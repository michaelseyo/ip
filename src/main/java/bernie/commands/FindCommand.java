package bernie.commands;

import bernie.enums.Type;
import bernie.exceptions.InvalidArgumentException;
import bernie.parser.Parser;
import bernie.storage.Storage;
import bernie.tasks.TaskList;
import bernie.ui.UiHandler;

/**
 * FindCommand is responsible for getting the TaskList to find the tasks that contain
 * the user input
 */
public class FindCommand extends Command {
    private final String[] parsedArr;

    /**
     * Constructs a FindCommand Class. The parsedArr is determined by the parser,
     * giving out the relevant arguments required to execute find.
     * @param tasks TaskList, contains all our Task we create
     * @param uiHandler UiHandler, responsible for printing out messages to the user for any action done
     * @param storage Storage, responsible for saving and loading of tasks into a text file
     * @param parser Parser, helps to parse user inputs to perform subsequent actions
     * @param input String, user input into the program
     * @throws InvalidArgumentException For a correct command with invalid arguments given by the user
     */
    public FindCommand(TaskList tasks, UiHandler uiHandler, Storage storage, Parser parser, String input)
            throws InvalidArgumentException {
        super(tasks, uiHandler, storage, parser, input);
        this.parsedArr = parser.getParams(Type.FIND, input);
    }
    /**
     * Through uiHandler, the tasksList is called to find tasks that match the user input parsed
     * by the parser.
     */
    public void execute() {
        TaskList tasks = getTasks();
        UiHandler uiHandler = getUiHandler();
        String description = parsedArr[0];
        uiHandler.showFoundTasksMsg(tasks, description);
    }
}
