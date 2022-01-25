import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Storage class handles the loading and saving of tasks in the file
 */
public class Storage {
    String root = System.getProperty("user.dir");
    File tasksFile;
    File dataDir;
    String lineBreak = "___________________________________________________________";

    /**
     * Constructs the Storage class with the File tasksFile and dataDir
     */
    Storage() {
        this.tasksFile = new File(root + "/data", "Bernie.txt");
        this.dataDir = new File(root, "data");
    }

    /**
     * Loads the data when Bernie starts up if it exists and reads. If doesn't
     * exist, creates the required files
     */
    void loadTasks() {
        try {
            if (tasksFile.exists() && dataDir.exists()) {
                System.out.println("On the list:");
                FileReader fileReader = new FileReader(tasksFile);
                BufferedReader reader = new BufferedReader(fileReader);
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println(line);
                }
                reader.close();
                System.out.println(lineBreak);
            } else {
                // create dir and file
                dataDir.mkdir();
                tasksFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(lineBreak);
        }
    }

    /**
     * Handles the conditions for checking if the File exist before
     * saving the tasks with the save function. If File doesn't exist,
     * the required files will be created before save
     * @param tasks TaskList, takes in the current tasks
     */
    void saveTasks(TaskList tasks) {
        try {
            if (dataDir.exists() && tasksFile.exists()) {
                save(tasks);
            } else {
                // create dir and file
                dataDir.mkdir();
                tasksFile.createNewFile();
                save(tasks);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(lineBreak);
        }
    }

    /**
     * Saves the most updated tasks whenever the tasks changes upon
     * delete or add by writing the file. The file is saved to ./data/Bernie.txt
     * @params tasks TaskList, takes in the current tasks
     * @throws IOException
     */
    void save(TaskList tasks) throws IOException {
        FileWriter fileWriter = new FileWriter(tasksFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        if (tasks.isEmpty()) {
            writer.write("NOTHING! :D");
        }
        for (int i = 0; i < tasks.getSize(); i++) {
            Task currentTask = tasks.getTask(i);
            writer.write(String.format("%d. %s\n", i + 1, currentTask));
        }
        writer.close();
    }
}
