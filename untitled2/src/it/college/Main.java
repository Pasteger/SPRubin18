package it.college;

//программа умножения без оператора умножения

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
    	Multiply multiplyObject = new Multiply();
		System.out.println(multiplyObject.multiply());
    }
}
