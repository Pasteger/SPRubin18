package it.college;

import java.util.Random;

public class FirstThreads extends Thread {
    Random random = new Random();

    @Override
    public void run() {
        int i = random.nextInt();
        System.out.println("Поток " + getName() + " принёс число " + i);
    }
}
