package javaconcepts.thread;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);
        MyRunnableThread runnable1 = new MyRunnableThread();

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);
        FutureTask<String> futureTask3 = new FutureTask(runnable1,"The Result");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        executor.execute(futureTask3);

        while (true) {
            try {
                if(futureTask1.isDone() && futureTask2.isDone() && futureTask3.isDone()){
                    System.out.println("Done");
                    //shut down executor service
                    executor.shutdown();
                    return;
                }

                if(!futureTask1.isDone()){
                    //wait indefinitely for future task to complete
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }catch(TimeoutException e){
                //do nothing
            }
        }

    }

}

class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}

class MyRunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Running Runnable Thread");
    }
}

