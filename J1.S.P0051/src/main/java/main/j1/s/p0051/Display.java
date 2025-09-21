package main.j1.s.p0051;

public class Display {

    public int displayMenu() {
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        Double opt = Validator.getNum("Please enter your choice: ");
        return opt.intValue();
    }

    public void run() {
        int opt = 0;
        while (opt != 3) {
            opt = displayMenu();
            switch (opt) {
                case 1:
                    NormalCalculator nc = new NormalCalculator();
                    nc.run();
                    break;
                case 2:
                    BMICalculator bmi = new BMICalculator();
                    bmi.run();
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

    }
}
