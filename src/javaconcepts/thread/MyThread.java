package javaconcepts.thread;

/*
It’s not guaranteed that thread mythread will start before thread myrunnable it depends upon Thread scheduler.

 */
//implementing Thread by extending Thread class
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println(" Thread Running " + Thread.currentThread().getName());
    }

    public static void main(String [] args){
        //starting Thread in Java
        Thread mythread = new MyThread();
        //Thread created not started
        mythread.setName("T1");

        Thread myrunnable = new Thread(new MyRunnable(),"T2"); //Thread created

        mythread.start(); //Thread started now but not running - Its in runnable state now its up to thread scheduler to pick this thread & start Parallel.
        myrunnable.start(); //Thread started now but not running - Its in runnable state now its up to thread scheduler to pick this thread & start Parallel.
    }
}

