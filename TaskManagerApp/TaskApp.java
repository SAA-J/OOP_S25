package TaskManagerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TaskApp {
    private JPanel hey_gil_mainPanel;
    private JTextField hey_gil_taskTextField;
    private JButton hey_gil_addButton;
    private JButton hey_gil_removeButton;
    private JButton hey_gil_completeButton;
    private JButton hey_gil_saveButton;
    private JButton hey_gil_loadButton;
    private JList<String> hey_gil_taskList;
    private DefaultListModel<String> hey_gil_taskListModel;
    private TaskManager hey_gil_taskManager;

    public TaskApp() {
        // Initialize hey_gil_TaskManager
        hey_gil_taskManager = new TaskManager();
        hey_gil_taskListModel = new DefaultListModel<>();
        hey_gil_taskList.setModel(hey_gil_taskListModel);


        // Add Task Button
        hey_gil_addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = hey_gil_taskTextField.getText().trim();
                if (!description.isEmpty()) {
                    hey_gil_taskManager.addTask(description);
                    refreshTaskList();
                    hey_gil_taskTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Task description cannot be empty.");
                }
            }
        });

        // Remove Task Button
        hey_gil_removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = hey_gil_taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    hey_gil_taskManager.removeTask(selectedIndex);
                    refreshTaskList();
                } else {
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Please select a task to remove.");
                }
            }
        });

        // Mark Task as Complete Button
        hey_gil_completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = hey_gil_taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    hey_gil_taskManager.completeTask(selectedIndex);
                    refreshTaskList();
                } else {
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Please select a task to mark as complete.");
                }
            }
        });

        // Save Tasks Button
        hey_gil_saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hey_gil_taskManager.saveToFile("tasks.txt");
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Tasks saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Error saving tasks: " + ex.getMessage());
                }
            }
        });

        // Load Tasks Button
        hey_gil_loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    hey_gil_taskManager.loadFromFile("tasks.txt");
                    refreshTaskList();
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Tasks loaded successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(hey_gil_mainPanel, "Error loading tasks: " + ex.getMessage());
                }
            }
        });
    }

    // Refreshes the JList with the latest task data
    private void refreshTaskList() {
        hey_gil_taskListModel.clear();
        ArrayList<hey_gil_task> tasks = hey_gil_taskManager.getTasks();
        for (hey_gil_task task : tasks) {
            hey_gil_taskListModel.addElement(task.toString());
        }
    }

    // Main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task Manager");
        frame.setContentPane(new TaskApp().hey_gil_mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
