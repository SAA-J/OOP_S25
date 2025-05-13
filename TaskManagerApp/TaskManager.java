package TaskManagerApp;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;



    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        if (task != null) {
            tasks.add(task);
            System.out.println("Task added: " + task.getDescription());
        } else {
            System.out.println("Task cannot be null.");
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

    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
