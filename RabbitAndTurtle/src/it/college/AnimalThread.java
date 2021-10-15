package it.college;

public class AnimalThread extends Thread{
    private int meter = 0;

    AnimalThread(String name, int priority){ //При создании потока будет заданы его имя и приоритет
        setName(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) { //бег
            meter += 1;
            System.out.println(getName() + " пробежал " + meter +" метров");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getMeter(){
        return this.meter;
    }
}
