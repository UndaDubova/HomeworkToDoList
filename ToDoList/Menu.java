package ToDoList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> tasks = new ArrayList<>();

    public Menu() {
    }

    public int startMenu() {

        System.out.println(" Hello! Welcome to your To Do list application");
        System.out.println(" Please choose one of the options: \n " +
                "1. Add a new task\n" +
                "2. Choose the status of a task\n" +
                "3. Delete a task\n" +
                "4. View all tasks\n" +
                "5. View all pending tasks\n" +
                "6. Save to file and Exit");
        int choice = scanner.nextInt();
        return choice;

    }

    public void menuSwitch(int choice) {
       // tasks = readArrayFromFile(); <-- doesn't work yet
        switch (choice) {

            case 1:
                System.out.println(addNewTask());
                break;
            case 2:
                if (tasks.size() > 0) {
                    changeTaskStatus();
                } else {
                    System.out.println(" Please add some tasks first ");
                }
                break;
            case 3:
                if (tasks.size() > 0) {
                    deleteTask();
                } else {
                    System.out.println(" Please add some tasks first ");
                }
                ;
                break;
            case 4:
                if (tasks.size() > 0) {
                    viewAllTasks();
                } else {
                    System.out.println(" Please add some tasks first ");
                }
                break;
            case 5:
                if (tasks.size() > 0) {
                    viewPendingTasks();
                } else {
                    System.out.println(" Please add some tasks first ");
                }
                break;
            case 6:
                saveAndExit();
                System.out.println("You have chosen to Exit, have a good day!");

                break;

        }

    }

    //methods for the tasks in the choice menu:

    public String addNewTask() {
        System.out.println("Please input a short name for your task");
        scanner.nextLine();
        String inputName = scanner.nextLine();

        System.out.println("Please input the description of your task");
        String inputDescription = scanner.nextLine();

        tasks.add(new Task(inputName, inputDescription, true));
        return "Task " + inputName + " added successfully";
    }

    public void changeTaskStatus() {
        System.out.println("Here are all the tasks");
        System.out.println(tasks.toString());
        System.out.println("Please enter the name of the task you want to update");
        scanner.nextLine();
        String inputName = scanner.nextLine();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(inputName)) {
                if (tasks.get(i).getPending() == true) {
                    tasks.get(i).setPending(false);
                    System.out.println("The pending status for the task " + inputName + " was changed to false");
                } else if (tasks.get(i).getPending() == false) {
                    tasks.get(i).setPending(true);
                    System.out.println("The pending status for the task " + inputName + " was changed to true");
                }
            }

        }


    }

    public void deleteTask() {
        System.out.println("Here are all the tasks");
        System.out.println(tasks.toString());
        System.out.println("Please enter the name of the task you want to remove");
        scanner.nextLine();
        String inputName = scanner.nextLine();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(inputName)) {
                tasks.remove(i);
            }
        }

    }

    public void viewAllTasks() {
        System.out.println("Here are all the tasks");
        System.out.println(tasks.toString());
    }

    public void viewPendingTasks() {
        System.out.println("Here are all the pending tasks: ");
        ArrayList<Task> pendingTasks = new ArrayList<>();
        int y = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPending() == true) {
                pendingTasks.add(y, tasks.get(i));
                y++;
            }
        }

        if (pendingTasks.size() > 0) {
            System.out.println(pendingTasks);
        } else {
            System.out.println(" There are no pending tasks!");
        }


    }

    public void saveAndExit() {
       /* createFileFromArray(tasks);*/
        System.out.println("See you next time!");
    }

    //methods to write and read the text file <-- doesn't work yet

   /* public void createFileFromArray(ArrayList<Task> tasks) {
        try {
            FileOutputStream myFile = new FileOutputStream("ToDoList.txt");
            ObjectOutputStream outStream = new ObjectOutputStream(myFile);
            outStream.writeObject(tasks);
            outStream.close();
            myFile.close();
            System.out.println("Your tasks are saved in a file in your computer's memory");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    */

   /* public ArrayList<Task> readArrayFromFile() {
        ArrayList<Task> tasks = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("ToDoList.txt"));
            Object o = in.readObject();
            tasks.add((Task) o);
            in.close();
        } catch (Exception e) {
        }
        return tasks;
    }
    */
}