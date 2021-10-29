package it.college;

//Поток пополняющий баланс

public class BalanceReplenishmentThread extends Thread{

    private final AccountInterface account; //На каком аккаунте будет происходить пополнение
    private final long add; //На сколько будет происходить пополнение
    private final int time; //Сколько раз будет происходить пополнение

    BalanceReplenishmentThread(AccountInterface account, long add, int time){
        this.account = account; //На каком аккаунте будет происходить пополнение
        this.add = add; //На сколько будет происходить пополнение
        this.time = time; //Сколько раз будет происходить пополнение
    }

    @Override
    public void run(){
        for (int i = this.time; i>0; i--) {
            account.balanceReplenishment(add); //Вызов метода пополнения баланса
        }
    }
}
