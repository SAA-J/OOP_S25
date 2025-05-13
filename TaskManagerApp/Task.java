package TaskManagerApp;

public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
    public String getDescription() {
        return description;
    }
    public boolean isComplete(){
        return isCompleted;
    }

    public void toggleStatus(){
        this.isCompleted = !this.isCompleted;
    }
    public String toString(){
        return (isCompleted ? "✔ ": "[ ] ") + description;
    }
}
