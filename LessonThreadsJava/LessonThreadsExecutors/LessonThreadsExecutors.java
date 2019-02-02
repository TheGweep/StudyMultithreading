package LessonsJava.LessonThreadsJava.LessonThreadsExecutors;

import java.util.Random;
import java.util.concurrent.*;

public class LessonThreadsExecutors {

    // Executors need for create limit for threads
    // Executors help control pool threads
    /* if we work with threads and use executors when we need solve task
     we don't create new threads and use our old threads when they free of task */
   static Random random = new Random();
    LessonThreadsExecutors() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new MyRunnable());
            Callable<String> callable = new MyCallable();
            FutureTask futureTask = new FutureTask(callable);
            new Thread(futureTask).start();
            System.out.println(futureTask.get());
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new LessonThreadsExecutors();
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(random.nextInt(10));
        }
    }

    static class MyCallable implements Callable{
        @Override
        public Object call() throws Exception {
            return random.nextInt(10);
        }
    }
}
