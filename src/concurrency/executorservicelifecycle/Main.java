package concurrency.executorservicelifecycle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Taken from Simon Roberts' OCP 1Z0-829 Lesson 25.3 minute 05:25
 */
public class Main {
    public static void main(String[] args) {
        final int JOB_COUNT = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> handles = new ArrayList<>();
        
        for (int i = 0; i < JOB_COUNT; i++) {
            handles.add(executorService.submit(new MyTask()));
        }
        
        executorService.shutdown();
        
        //region awaitTermination
        //try {
        //    executorService.awaitTermination(10, TimeUnit.MINUTES);
        //} catch (InterruptedException e) {
        //    System.out.println("main thread interrupted??");
        //}
        //System.out.println("main exiting");
        //endregion
        
        //region cancel a job mid-run
        try {
            Thread.sleep(800);
            handles.get(1).cancel(true);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //endregion
        
        System.out.println("all jobs submitted to the pool");
        while (handles.size() > 0) {
            Iterator<Future<String>> iterator = handles.iterator();
            while (iterator.hasNext()) {
                Future<String> stringFuture = iterator.next();
                if (stringFuture.isDone()) {
                    iterator.remove();
                    try {
                        String jobResult = stringFuture.get();
                        System.out.println("Got a job result: " + jobResult);
                    } catch (InterruptedException ie) {
                        System.out.println("main thread interrupted??");
                    } catch (ExecutionException ee) {
                        System.out.println("Job threw an exception: " + ee.getCause());
                    } catch (CancellationException ce) {
                        System.out.println("Job was cancelled!");
                    }
                }
            }
        }
    }
}

class MyTask implements Callable<String> {
    private static int nextId = 0;
    private int jobId = nextId++;
    
    @Override
    public String call() throws Exception {
        System.out.printf("Job %d starting%n", jobId);
        
        try {
            Thread.sleep((int) (Math.random() * 2000 + 1000));
        } catch (InterruptedException interruptedException) {
            System.out.printf("Job %d received shutdown request%n", jobId);
            return "Job" + jobId + " early shutdown result";
        }
        
        if (Math.random() > 0.7) {
            System.out.printf("Job %d throwing exception%n", jobId);
            throw new SQLException("Job " + jobId + " Database broke!");
        }
        
        System.out.printf("Job %d completed normally%n", jobId);
        return "Job" + jobId + " normal result";
    }
}
