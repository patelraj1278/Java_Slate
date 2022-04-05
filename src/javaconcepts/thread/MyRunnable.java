package javaconcepts.thread;

public class MyRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println(" Create Thread " + Thread.currentThread().getName());
    }

}
