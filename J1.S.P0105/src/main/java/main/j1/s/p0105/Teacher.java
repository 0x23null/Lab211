package main.j1.s.p0105;

import java.time.Year;

public class Teacher extends Person {

    private int yearInTheProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInTheProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0.0;
    }

    @Override
    public void InputAll() {
        System.out.println("--- Input Person Info (Teacher) ---");
        super.InputAll();

        System.out.println("--- Input Teacher Specific Info ---");

        int currentYear = Year.now().getValue();
        int age = currentYear - this.getYearOfBirth();

        do {
            System.out.print("Year in the profession: ");
            this.yearInTheProfession = Validator.getIntInput();

            if (this.yearInTheProfession >= 0 && this.yearInTheProfession < age) {
                break;
            }
            System.out.println("Data input is invalid (0 to less than age) [cite: 35]");
        } while (true);

        do {
            System.out.print("Contract type (Long/Short): ");
            this.contractType = Validator.getStringInput();

            String normalizedInput = this.contractType.trim();
            if (normalizedInput.equalsIgnoreCase("Long") || normalizedInput.equalsIgnoreCase("Short")) {
                this.contractType = normalizedInput;
                break;
            }
            System.out.println("Data input is invalid (must be 'Long' or 'Short') [cite: 36]");
        } while (true);

        do {
            System.out.print("Salary coefficient: ");
            this.salaryCoefficient = Validator.getDoubleInput();

            if (this.salaryCoefficient >= 0) {
                break;
            }
            System.out.println("Data input is invalid (must be 0 or greater) [cite: 37]");
        } while (true);

        System.out.println("*** Teacher input completed ***");
    }
    
    public int getYearInTheProfession() {
        return yearInTheProfession;
    }
}
