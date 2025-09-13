package j1.s.p0011;

import java.util.Scanner;

public class Validator {
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * Yêu cầu người dùng nhập một số nguyên trong một khoảng cho trước.
     * @param message Lời nhắn hiển thị.
     * @param min     Giá trị nhỏ nhất.
     * @param max     Giá trị lớn nhất.
     * @return Số nguyên hợp lệ.
     */
    public static int getIntInRange(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Choice must be in range [" + min + ", " + max + "].");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }
    }

    /**
     * Yêu cầu người dùng nhập một giá trị và kiểm tra nó dựa trên một mẫu regex.
     * @param message Lời nhắn hiển thị.
     * @param regex   Mẫu regex để kiểm tra.
     * @return Chuỗi giá trị hợp lệ.
     */
    public static String getInputValue(String message, String regex) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.matches(regex)) {
                return input;
            } else {
                System.err.println("Invalid input value for this base.");
            }
        }
    }
}