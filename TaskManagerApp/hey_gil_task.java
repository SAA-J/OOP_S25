package TaskManagerApp;

public class hey_gil_task {
    private String description;
    private boolean isCompleted;

    //Constructs a new task with a given description
    public hey_gil_task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
    //returns the description of the task
    public String hey_gil_getDescription() {
        return description;
    }
    //checks if the task is completed
    public boolean hey_gil_isComplete(){
        return isCompleted;
    }
    //Toggle the status of the task
    public void hey_gil_toggleStatus(){
        this.isCompleted = !this.isCompleted;
    }
    public String toString(){
        return (isCompleted ? "✔ ": "[ ] ") + description;
    }
}
