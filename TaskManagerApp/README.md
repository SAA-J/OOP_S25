# Task Manager Application

## 📋 Overview

The **Task Manager Application** is a simple, modern desktop application built with Java and Swing for managing tasks efficiently. This project is designed as a final project for an Object-Oriented Programming (OOP) course, featuring a clean graphical user interface (GUI) and robust backend logic for handling tasks.

## ✨ Features

• Add, remove, and complete tasks
• Save and load tasks from a text file
• Modern and responsive design
• Uses custom task classes and interfaces for clean, reusable code
• Color-coded buttons for different actions

## 📁 Project Structure

```
/src/TaskManagerApp/
├── Storable.java            # Interface for saving/loading tasks
├── Task.java                # Task model
├── TaskApp.form             # GUI layout file (IntelliJ Designer)
├── TaskApp.java             # Main application logic
├── TaskManager.java         # Task manager backend
```

## 🛠️ Installation

1. Clone the repository:

```
git clone https://github.com/SAA-J/OOP_S25.git
```

2. Open the project in IntelliJ IDEA.
3. Make sure your Java SDK is properly configured.
4. Run the **TaskApp.java** file to launch the application.

## 🚀 Running the App

To run the app from the command line:

```
cd src/TaskManagerApp
javac TaskApp.java
java TaskManagerApp.TaskApp
```

## 📝 Usage

• **Add Tasks:** Type a task description and click the **Add** button.
• **Remove Tasks:** Select a task from the list and click the **Remove** button.
• **Complete Tasks:** Select a task from the list and click the **Done** button.
• **Save Tasks:** Click the **Save** button to save all tasks to a file.
• **Load Tasks:** Click the **Load** button to load tasks from a file.

## 🎨 Customization

The app uses a modern color palette and rounded buttons for a clean, professional look. You can adjust these colors in the **TaskApp.java** file.

## 🛠️ Future Improvements

• Add task priorities
• Implement due dates
• Add a dark mode toggle
• Sync with cloud storage


