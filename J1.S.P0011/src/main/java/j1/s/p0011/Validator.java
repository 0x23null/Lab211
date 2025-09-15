package j1.s.p0011;

import java.util.Scanner;

public class Validator {

    Scanner sc = new Scanner(System.in);

    int getBase(String mess, int min, int max, int baseIn) {
        int choice;
        int base = -1;
        String input;

        do {
            System.out.print(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Choice could not be empty");
                continue;
            } else {
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= min && choice <= max) {
                        switch (choice) {
                            case 1:
                                base = 2;
                                break;
                            case 2:
                                base = 10;
                                break;
                            case 3:
                                base = 16;
                                break;
                            case 4:
                                System.exit(0);
                        }
                        if (baseIn == base) {
                            System.out.println("Base output could not same base input");
                            continue;
                        } else {
                            return base;
                        }
                    } else {
                        System.out.println("Choice must be in range " + min + " to " + max);
                        continue;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Choice must be Integer");
                }
            }
        } while (true);
    }

    String getInput(String mess, int baseInput) {
        String input;
        String regexBase = "";
        switch (baseInput) {
            case 2:
                regexBase = "^[0-1]+$";
                break;
            case 10:
                regexBase = "^[0-9]+$";
                break;
            case 16:
                regexBase = "^[a-fA-F0-9]+$";
                break;
        }
        do {
            System.out.print(mess);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input value could not be empty");
                continue;
            } else {
                if (input.matches(regexBase)) {
                    return input.toUpperCase();
                } else {
                    System.out.println("Input is wrong format of base " + baseInput);
                    continue;
                }
            }
        } while (true);
    }

}