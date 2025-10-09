package main.j1.s.p109_rv2;

public class CourseManagement {

    public int display() {
        System.out.println("*** Course Management *** ");
        System.out.println("1. Add online course/ offline course");
        System.out.println("2. Update course");
        System.out.println("3. Delete course");
        System.out.println("4. Print all / online course / offline course");
        System.out.println("5. Search information base on course name");
        System.out.println("6. Exit");
        System.out.print("You choose: ");
        int choice = Validator.getIntInput();
        return choice;
    }

    public void run() {
        int choice;
        while (true) {
            choice = display();
            switch (choice) {
                case 1 ->
                    addNewCourse();
                case 2 ->
                    System.out.println("function2");
                case 3 ->
                    System.out.println("function3");
                case 4 ->
                    System.out.println("function4");
                case 5 ->
                    System.out.println("function5");
                case 6 ->
                    System.exit(0);
                default ->
                    System.out.println("Invalid choice, Please try again");
            }
        }
    }

    public void addNewCourse() {
        String type = Validator.getStringInput("Online (O) or Offline (F): ");
        while (true) {
            switch (type) {
                case "O" ->
                    addOnlineCourse();
                case "F" ->
                    addOfflineCourse();
                default ->
                    System.out.println("Data input is  invalid");
            }
        }

    }

    public void addOfflineCourse() {
        
    }

    public void addOnlineCourse() {

    }
}
