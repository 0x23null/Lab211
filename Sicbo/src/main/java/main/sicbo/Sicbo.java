package main.sicbo;

import java.util.Random;

public class Sicbo {

    public static void main(String[] args) {
        sicbo();
    }

    public static void sicbo() {
        Random rand = new Random();
        int i = 0;
        int sicbo_1, sicbo_2, sicbo_3;
        int sum;
        int demT = 0; int demX = 0;
        while (i < 1000) {
            sicbo_1 = rand.nextInt(6) + 1;
            sicbo_2 = rand.nextInt(6) + 1;
            sicbo_3 = rand.nextInt(6) + 1;
            
            sum = sicbo_1 + sicbo_2 + sicbo_3;
            if (sum >= 11) {
                System.out.print(" T");
                demT +=1;
            }
            if (sum < 11) {
                System.out.print(" X");
                demX +=1;
            }
            i++;
        }
        System.out.println("\nT: " + demT);
        System.out.println("X: " + demX);
    }
}
