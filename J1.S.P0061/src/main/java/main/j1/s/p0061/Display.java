package main.j1.s.p0061;

import java.util.Scanner;

public class Display {

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("=====Calculator Shape Program=====");
    }

    public void run() {
        displayMenu();
        double rectangleWidth = getNum("Please input side width of Rectangle: ");
        double rectangleLength = getNum("Please input length of Rectangle: ");
        double circleRadius = getNum("Please input radius of Circle: ");
        double sideA = getNum("Please input side A of Triangle: ");
        double sideB = getNum("Please input side B of Triangle: ");
        double sideC = getNum("Please input side C of Triangle: ");

        Rectangle rectangle = new Rectangle(rectangleWidth, rectangleLength);
        Circle circle = new Circle(circleRadius);
        Triangle triangle = new Triangle(sideA, sideB, sideC);

        System.out.println("---Rectangle---");
        rectangle.printResult();

        System.out.println("---Circle---");
        circle.printResult();

        System.out.println("---Triangle---");
        triangle.printResult();

    }

    public double getNum(String msg) {
        double num;
        while (true) {
            System.out.print(msg);
            try {
                num = Double.parseDouble(sc.nextLine());
                if (num <= 0) {
                    System.out.println("Must be positive number. Please enter again: ");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public void showResult() {

    }

    public Display() {
    }

}
