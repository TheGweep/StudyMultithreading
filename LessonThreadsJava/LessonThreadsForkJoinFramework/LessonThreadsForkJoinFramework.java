package LessonsJava.LessonThreadsJava.LessonThreadsForkJoinFramework;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class LessonThreadsForkJoinFramework {


    // ForkJoinPool help to distribute all task on all threads and to increase speed

    static long numOfOperations = 10_000_000_000L;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    LessonThreadsForkJoinFramework(){
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool(numOfThreads);
        System.out.println(forkJoinPool.invoke(new MyFork(0, numOfOperations)));
        System.out.println(new Date());

    }

    static class MyFork extends RecursiveTask<Long>{
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) <= numOfOperations/numOfThreads ){
                long j = 0;
                for (long i = from; i < to; i++) {
                    j +=i;
                }
                return j;
            } else {
                long middle = (to + from)/2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;

            }
        }
    }

    public static void main(String[] args) {
        new LessonThreadsForkJoinFramework();
    }
}
