package main.j1.s.p0105;

public class Person {

    private String ID;
    private String fullName;
    private String phoneNumber;
    private int yearOfBirth;
    private String major;

    public Person() {
        this.ID = "";
        this.fullName = "";
        this.phoneNumber = "";
        this.major = "";
        this.yearOfBirth = 0;
    }

    public void InputAll() {
        int currentYear = java.time.Year.now().getValue();

        do {
            System.out.print("ID: ");
            this.ID = Validator.getStringInput();
            if (this.ID.matches("^\\d{6}$")) {
                break;
            }
            System.out.println("Data input is invalid (ID must be 6 digits)");
        } while (true);

        do {
            System.out.print("Fullname: ");
            this.fullName = Validator.getStringInput();
            if (this.fullName.matches("^[a-zA-Z ]+$")) {
                break;
            }
            System.out.println("Data input is invalid (Fullname must be alphabet and blanks)");
        } while (true);

        do {
            System.out.print("Phone number: ");
            this.phoneNumber = Validator.getStringInput();
            if (this.phoneNumber.matches("^\\d{10}$")) {
                break;
            }
            System.out.println("Data input is invalid (Phone number must be 12 digits)");
        } while (true);

        do {
            System.out.print("Year of birth: ");
            this.yearOfBirth = Validator.getIntInput(); // Giả sử Utility.getIntInput() đọc số nguyên
            if (this.yearOfBirth > 0 && this.yearOfBirth < currentYear) {
                break;
            }
            System.out.println("Data input is invalid (Year of birth must be before current year)");
        } while (true);

        do {
            System.out.print("Major: ");
            this.major = Validator.getStringInput();
            if (this.major.length() > 0 && this.major.length() <= 30) {
                break;
            }
            System.out.println("Data input is invalid (Major max 30 characters)");
        } while (true);
    }
    
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    
    public String getFullName() {
        return fullName;
    }
}
