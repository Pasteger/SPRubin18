package it.college;

/*
                                                  !!!
Я не знаю почему, программа работает коректно, только если её выполнять последовательно через отладчик.
Если программу запустить обычным запуском, то она поведёт себя странно и не сделает, то что от неё требуется.
                                                  !!!
*/

/*
"Приоритет нити не сильно влияет на ее работу, а носит скорее рекомендательный характер.
Java-машина управляет нитями так, как посчитает нужным. Нити с низким приоритетом не будут простаивать."
(скопированно с "Приоритеты потоков" Javarush.ru)
Воистину так, высокий приоритет не гарантирует то, что поток сильно оторвётся от потока с низким приоритетом,
поэтому, получив высокий приоритет, черепаха не всегда сможет обогнать зайца.
*/

public class RabbitAndTurtle {

    public static void main(String[] args) throws InterruptedException {
        //Создание потоков и задавание им имени и приоритета
	    AnimalThread turtle = new AnimalThread("Черепаха", 1);
        AnimalThread rabbit = new AnimalThread("Заяц", 10);

        boolean start = true;
        while (rabbit.getMeter() < 100 & turtle.getMeter() < 100) {
            //потоки стартуют внутри цикла только 1 раз
            if(start){
                start = false;
                turtle.start();
                rabbit.start();
            }

            //Если rabbit отстаёт, его приоритет будет повышен, а приоритет turtle понижен
            if (turtle.getMeter() - rabbit.getMeter() > 20) {

                rabbit.setPriority(10);
                turtle.setPriority(1);
                System.out.println("\n \n \n Приоритеты поменялись! \n \n \n");
            }

            //Если turtle отстаёт, его приоритет будет повышен, а приоритет rabbit понижен
            if (rabbit.getMeter() - turtle.getMeter() > 20) {

                turtle.setPriority(10);
                rabbit.setPriority(1);
                System.out.println("\n \n \n Приоритеты поменялись! \n \n \n");
            }
        }
    }
}
