package main.j1.s.p0105;

import java.time.Year;

public class Student extends Person {

    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        this.entranceEnglishScore = 0;
    }

    @Override
    public void InputAll() {
        System.out.println("--- Input Person Info (Student) ---");
        super.InputAll();

        System.out.println("--- Input Student Specific Info ---");

        int currentYear = Year.now().getValue();
        int birthYear = this.getYearOfBirth();

        do {
            System.out.print("Year of admission: ");
            this.yearOfAdmission = Validator.getIntInput();

            if (this.yearOfAdmission > birthYear && this.yearOfAdmission <= currentYear) {
                break;
            }
            System.out.println("Data input is invalid (must be between birth year and current year)");
        } while (true);

        do {
            System.out.print("Entrance English score (0-100): ");
            this.entranceEnglishScore = Validator.getIntInput();

            if (this.entranceEnglishScore >= 0 && this.entranceEnglishScore <= 100) {
                break;
            }
            System.out.println("Data input is invalid (score must be from 0 to 100)");
        } while (true);

        System.out.println("*** Student input completed ***");
    }
    
    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
}
