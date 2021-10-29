package it.college;

public class Account implements AccountInterface{
    private long balance = 0;

    public void balanceReplenishment(long add){
        balance += add;
        System.out.println("Произошло пополнение баланса на " + add + " $");
    }

    //Простое списание денег с баланса
    public void withdrawal(long cost){
        if(balance>=cost) {
            balance -= cost;
            System.out.println("Произошло списание баланса на " + cost + " $");
        }
        else {
            System.out.println("Недостаточно средств для списания");
        }
    }

    public void checkBalance() {
        System.out.println("На балансе: " + balance + " $");
    }

    //Метод, ожидающий пополнения баланса перед списанием
    public void threadWithdrawal(long cost){
        int waitingTime = 0;
        while (true) {
            waitingTime++;
            if (balance >= cost) {
                balance -= cost;
                System.out.println("Произошло списание баланса на " + cost + " $");
                break;
            }
            else {
                System.out.println("Недостаточно средств для списания. Ожидается пополнение");
            }
            if (waitingTime > 1000000){
                System.out.println("Превышено время ожидания");
                break;
            }
        }
    }
}
