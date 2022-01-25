import java.io.File;
import java.io.IOException;

/**
 * Class to deal with any interactions with the user. It is contained
 * in the Bernie class and is responsible for printing out relevant messages
 * to the user
 */
public class Ui {
    String lineBreak = "___________________________________________________________";

    /**
     * Prints out message when user starts the program
     */
    void greet() {
        System.out.println("Hello! I'm Bernie\nWhat's up?");
        System.out.println(lineBreak);
    }

    /**
     * Prints out message when user exits out of the program
     */
    void showLeaveMsg() {
        System.out.println("See ya!");
    }

    /**
     * Prints out the error message when faced with any errors
     * @param msg String, the error message
     */
    void showErrorMsg(String msg) {
        System.out.println(msg);
        System.out.println(lineBreak);
    }

    /**
     * Prints out the message whenever the user adds a new task
     * @param newTask Task, newTask added by the user
     * @param numTasksLeft int, the number of tasks left
     */
    void showAddedMsg(Task newTask, int numTasksLeft) {
        System.out.printf("Got ya. Added:\n%s\nYou got %d tasks waiting for ya!\n",
                newTask, numTasksLeft);
        System.out.println(lineBreak);
    }

    /**
     * Prints out the message whenever the user deletes a task
     * @param deletedTask Task, task deleted by the user
     * @param numTasksLeft int, the number of tasks left
     */
    void showDeleteMsg(Task deletedTask, int numTasksLeft) {
        System.out.printf("Got ya. Removed:\n%s\nYou got %d tasks waiting for ya!\n",
                deletedTask, numTasksLeft);
        System.out.println(lineBreak);
    }

    /**
     * Prints out the current taskList when the user inputs list into the program
     * @param tasks
     */
    void showListTasksMsg(TaskList tasks) {
        System.out.println("Here's what you need to do buddy:");
        if (tasks.isEmpty()) {
            System.out.println("NOTHING! :D");
        }
        tasks.listTasks();
        System.out.println(lineBreak);
    }

    /**
     * Prints out the message when a user marks a task number
     * @param markedTask Task
     */
    void showDoneMsg(Task markedTask) {
        System.out.printf("This is now done:\n%s\n", markedTask);
        System.out.println(lineBreak);
    }

    /**
     * Prints out the message when a user unmarks a task number
     * @param unmarkedTask Task
     */
    void showUndoneMsg(Task unmarkedTask) {
        System.out.printf("This is now undone:\n%s\n", unmarkedTask);
        System.out.println(lineBreak);
    }
}
