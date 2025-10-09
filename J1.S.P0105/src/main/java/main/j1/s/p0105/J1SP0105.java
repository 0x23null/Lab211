package main.j1.s.p0105;

public class J1SP0105 {

    public static void main(String[] args) {
        Management manager = new Management();
        int choice;

        do {
            showMainMenu();
            choice = Validator.getIntInput();

            switch (choice) {
                case 1:
                    handleTeacherMenu(manager);
                    break;
                case 2:
                    handleStudentMenu(manager);
                    break;
                case 3:
                    handlePersonMenu(manager);
                    break;
                case 4:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public static void showMainMenu() {
        System.out.println("\n*** Information Management ***");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Person");
        System.out.println("4. Exit");
        System.out.print("You choose: ");
    }

    public static void handleTeacherMenu(Management manager) {
        int choice;
        do {
            System.out.println("\n*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            choice = Validator.getIntInput();

            switch (choice) {
                case 1:
                    manager.inputTeachers();
                    break;
                case 2:
                    manager.printTeachers();
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void handleStudentMenu(Management manager) {
        int choice;
        do {
            System.out.println("\n*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            choice = Validator.getIntInput();

            switch (choice) {
                case 1:
                    manager.inputStudents();
                    break;
                case 2:
                    manager.printStudents();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void handlePersonMenu(Management manager) {
        int choice;
        do {
            System.out.println("\n*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            choice = Validator.getIntInput();

            switch (choice) {
                case 1:
                    manager.searchPersonByName();
                    break;
                case 2:
                    manager.printAllPeople();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}
