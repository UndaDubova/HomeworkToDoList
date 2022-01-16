import ToDoList.Menu;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        int choice;
        do {
           choice = menu.startMenu();
           menu.menuSwitch(choice);
        }
        while (choice != 6);

    }
}
