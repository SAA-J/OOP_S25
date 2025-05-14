package TaskManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TaskApp {
    private JPanel mainPanel;
    private JTextField taskTextField;
    private JButton addButton;
    private JButton removeButton;
    private JButton completeButton;
    private JButton saveButton;
    private JButton loadButton;
    private JList<String> taskList;
    private DefaultListModel<String> taskListModel;
    private TaskManager taskManager;

    public TaskApp() {
        // Initialize TaskManager
        taskManager = new TaskManager();
        taskListModel = new DefaultListModel<>();
        taskList.setModel(taskListModel);


        // Add Task Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = taskTextField.getText().trim();
                if (!description.isEmpty()) {
                    taskManager.addTask(description);
                    refreshTaskList();
                    taskTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Task description cannot be empty.");
                }
            }
        });

        // Remove Task Button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskManager.removeTask(selectedIndex);
                    refreshTaskList();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please select a task to remove.");
                }
            }
        });

        // Mark Task as Complete Button
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskManager.completeTask(selectedIndex);
                    refreshTaskList();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please select a task to mark as complete.");
                }
            }
        });

        // Save Tasks Button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taskManager.saveToFile("tasks.txt");
                    JOptionPane.showMessageDialog(mainPanel, "Tasks saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Error saving tasks: " + ex.getMessage());
                }
            }
        });

        // Load Tasks Button
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    taskManager.loadFromFile("tasks.txt");
                    refreshTaskList();
                    JOptionPane.showMessageDialog(mainPanel, "Tasks loaded successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Error loading tasks: " + ex.getMessage());
                }
            }
        });
    }

    // Refreshes the JList with the latest task data
    private void refreshTaskList() {
        taskListModel.clear();
        ArrayList<Task> tasks = taskManager.getTasks();
        for (Task task : tasks) {
            taskListModel.addElement(task.toString());
        }
    }

    // Main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task Manager");
        frame.setContentPane(new TaskApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
