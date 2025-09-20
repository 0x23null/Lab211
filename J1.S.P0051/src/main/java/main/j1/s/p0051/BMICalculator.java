package main.j1.s.p0051;

public class BMICalculator {

    public void run() {
        double weight = Validator.getNumBMI("Enter weight(kg): ");
        double height = Validator.getNumBMI("Enter height(cm): ");
        double result = weight / Math.pow(height/100, 2);
        
        
        System.out.printf("BMI Number: %.2f\n", result);
        if (result < 19) {
            System.out.println("BMI status: Under-standard");
        } else if (result >= 19 && result < 25) {
            System.out.println("BMI status: Standard");
        } else if (result >= 25 && result < 30) {
            System.out.println("BMI status: Overweight");
        } else if (result >= 30 && result <= 40) {
            System.out.println("BMI status: Fat - should lose weight");
        } else {
            System.out.println("BMI status: Very fat - should lose weight immediately");
        }

    }
}
