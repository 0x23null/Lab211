package main.j1.s.p0051;

public class BMICalculator {
    
    public enum BMIStatus {
        UNDER_STANDARD("Under-standard"),
        STANDARD("Standard"),
        OVERWEIGHT("Overweight"),
        FAT("Fat - should lose weight"),
        VERY_FAT("Very fat - should lose weight immediately");
        
        private String status;

        BMIStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
    
    public BMIStatus calculateBMI(double weight, double height) {
        double result = weight / Math.pow(height / 100, 2);
        
        System.out.printf("BMI Number: %.2f\n", result);
        if (result < 19) {
            return BMIStatus.UNDER_STANDARD;
        } else if (result >= 19 && result < 25) {
            return BMIStatus.STANDARD;
        } else if (result >= 25 && result < 30) {
            return BMIStatus.OVERWEIGHT;
        } else if (result >= 30 && result <= 40) {
            return BMIStatus.FAT;
        } else {
            return BMIStatus.VERY_FAT;
        }
    }

    public void run() {
        double weight = Validator.getNumBMI("Enter weight(kg): ");
        double height = Validator.getNumBMI("Enter height(cm): ");
        
        BMIStatus status = calculateBMI(weight, height);
        System.out.println("BMI status: " + status.getStatus());
    }
}