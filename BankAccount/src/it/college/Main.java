package it.college;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму, на которою поток будет пополнять баланс");
        long add = scanner.nextLong();
        System.out.println("Введите сколько раз поток будет пополнять баланс");
	    int time = scanner.nextInt();
	    System.out.println("Введите снимаемую с баланса сумму (на балансе будет " + add*time + " $)");
	    long cost = scanner.nextLong();

        Account Vadim = new Account();

        //Создание потока, пополняющего баланс
        BalanceReplenishmentThread balanceReplenishmentThread = new BalanceReplenishmentThread(Vadim, add, time);

        balanceReplenishmentThread.start();

        //Метод, ожидающий пополнения баланса для списания
        Vadim.threadWithdrawal(cost);

        //Здесь потоку, пополняющему баланс и списывающему деньги методу, даётся время выполниться
        Thread.sleep(time* 3L);

        //Показывает, сколько осталось на балансе
        Vadim.checkBalance();
    }
}
