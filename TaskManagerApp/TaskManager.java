package TaskManagerApp;

import java.io.*;
import java.util.ArrayList;

public class TaskManager implements Storable {
    private ArrayList<Task> tasks;



    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        if (description != null && !description.trim().isEmpty()) {
            Task task = new Task(description);
            tasks.add(task);
            System.out.println("Task added: " + task.getDescription());
        } else {
            System.out.println("Task description cannot be empty.");
        }
    }

    public void completeTask(int index){
        if (index >= 0 && index < tasks.size()){
            Task task = tasks.get(index);
            task.toggleStatus();
            System.out.println("Task marked as complete: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }
    public void removeTask(int index){
        if (index >= 0 && index < tasks.size()){
            Task removedTask = tasks.remove(index);
            System.out.println("Task remove: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }


    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write(task.getDescription() + "|" + (task.isComplete() ? "1" : "0"));
                writer.newLine();
            }
            System.out.println("Tasks saved to " + filePath);
        }
    }

    @Override
    public void loadFromFile(String filePath) throws IOException {
        tasks.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String description = parts[0];
                    boolean isComplete = parts[1].equals("1");
                    Task task = new Task(description);
                    if (isComplete) task.toggleStatus();  // Set the status if complete
                    tasks.add(task);
                }
            }
            System.out.println("Tasks loaded from " + filePath);
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
