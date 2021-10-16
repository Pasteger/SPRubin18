package it.college;

public class EggOrChickenThread extends Thread{

    private final boolean argumentOfTheDispute; //Значение, которое будет передаваться переключателю
    private final String word; //Слово, что будет "выкрикивать" поток

    EggOrChickenThread(String word, boolean argumentOfTheDispute){
        this.word=word;
        this.argumentOfTheDispute=argumentOfTheDispute;
    }

    @Override
    public void run(){
        Thread current = Thread.currentThread();
        while (!current.isInterrupted())
        {
            System.out.println(getWord()); //Выкрикивается слово
            Switch.setResult(argumentOfTheDispute); //И переключается переключатель
        }
    }

    public String getWord() {
        return word;
    }
}
