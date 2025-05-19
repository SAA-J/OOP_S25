package TaskManagerApp;

import java.io.*;
import java.util.ArrayList;

public class TaskManager implements hey_gil_Storable {
    private ArrayList<hey_gil_task> tasks;


    //Constructs an empty list
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    //Adds a new task to the list
    public void hey_gil_addTask(String description) {
        if (description != null && !description.trim().isEmpty()) {
            hey_gil_task task = new hey_gil_task(description);
            tasks.add(task);
            System.out.println("Task added: " + task.hey_gil_getDescription());
        } else {
            System.out.println("Task description cannot be empty.");
        }
    }

    //Mark task as completed
    public void hey_gil_completeTask(int index){
        if (index >= 0 && index < tasks.size()){
            hey_gil_task task = tasks.get(index);
            task.hey_gil_toggleStatus();
            System.out.println("Task marked as complete: " + task.hey_gil_getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    //Removes task from the list
    public void hey_gil_removeTask(int index){
        if (index >= 0 && index < tasks.size()){
            hey_gil_task removedTask = tasks.remove(index);
            System.out.println("Task remove: " + removedTask.hey_gil_getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    //Saves all tasks to a text file
    public void hey_gil_saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (hey_gil_task task : tasks) {
                writer.write(task.hey_gil_getDescription() + "|" + (task.hey_gil_isComplete() ? "1" : "0"));
                writer.newLine();
            }
            System.out.println("Tasks saved to " + filePath);
        }
    }


    //Loads tasks from the text file, replacing the current task list
    @Override
    public void hey_gil_loadFromFile(String filePath) throws IOException {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String description = parts[0];
                    boolean isComplete = parts[1].equals("1");
                    hey_gil_task task = new hey_gil_task(description);
                    if (isComplete) task.hey_gil_toggleStatus();  // Set the status if complete
                    tasks.add(task);
                }
            }
            System.out.println("Tasks loaded from " + filePath);
        }
    }
    //returns the list of tasks
    public ArrayList<hey_gil_task> hey_gil_getTasks() {
        return tasks;
    }

}
