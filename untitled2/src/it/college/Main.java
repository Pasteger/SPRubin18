package it.college;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Введите умножаемое число");
	    double multiplier0 = scanner.nextInt();
	    System.out.println("Введите на какое число будет умножаться");
	    double multiplier1 = scanner.nextInt();
	    System.out.println(multiplier0/(1/multiplier1));
    }
}
