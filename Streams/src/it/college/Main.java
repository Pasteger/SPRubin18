package it.college;

/* Эта программа создаёт и запускает 10 потоков */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FirstThreads thread_0 = new FirstThreads();
        thread_0.start();
        FirstThreads thread_1 = new FirstThreads();
        thread_1.start();
        FirstThreads thread_2 = new FirstThreads();
        thread_2.start();
        FirstThreads thread_3 = new FirstThreads();
        thread_3.start();
        FirstThreads thread_4 = new FirstThreads();
        thread_4.start();
        FirstThreads thread_5 = new FirstThreads();
        thread_5.start();
        FirstThreads thread_6 = new FirstThreads();
        thread_6.start();
        FirstThreads thread_7 = new FirstThreads();
        thread_7.start();
        FirstThreads thread_8 = new FirstThreads();
        thread_8.start();
        FirstThreads thread_9 = new FirstThreads();
        thread_9.start();
    }
}
