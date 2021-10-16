package it.college;

/*
Во время спора курица и яйцо "переключают" результат на своё значение (как счётчик времени в шахматах).
Побеждает тот, чьё значение будет в переключателе (Switch) после истечения времени.
*/

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Объектам передаются слова, что они будут выкрикивать и значения, что они будут назначать переключателю
        EggOrChickenThread egg = new EggOrChickenThread("Яйцо", true);
        EggOrChickenThread chicken = new EggOrChickenThread("Курица", false);

        egg.start();
        chicken.start();

        Thread.sleep(10000); //Время, в течение которого потоки будут спорить

        egg.interrupt();
        chicken.interrupt();

        //Побеждает тот, чьё значение будет в переключателе (Switch) после истечения времени
        System.out.println(Switch.getResult()?"Яйцо победило!":"Курица победила!");
    }
}
