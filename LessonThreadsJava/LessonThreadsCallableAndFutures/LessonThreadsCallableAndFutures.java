package LessonsJava.LessonThreadsJava.LessonThreadsCallableAndFutures;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class LessonThreadsCallableAndFutures {


    // interface callable override method call() and use if we can get something result while working thread
    LessonThreadsCallableAndFutures() throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get().toString());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new LessonThreadsCallableAndFutures();
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Random random = new Random();
            String s = "";
            int number;
            //int numberChar;
            for (int i = 0; i < 10;i++) {
                number = random.nextInt(100);
                /*s = Integer.toString(number);
                numberChar = Integer.parseInt(s,8);*/
               //number += number;
                System.out.print((char) number);
                Thread.sleep(200);
            }
            return s;
        }
    }
}
