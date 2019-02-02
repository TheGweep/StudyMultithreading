package LessonsJava.LessonThreadsJava.LessonThreadsVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class LessonThreadsVolatile {


    // data in thread write in value, which use cache memory, but not global memory
    // if we give modifier volatile for value, all threads be use this value through global memory, not cache

   static volatile int i;
   static int j;
   static AtomicInteger atomicInteger = new AtomicInteger(0); // atomic operation (use because methods can work with mistake)
    LessonThreadsVolatile() throws InterruptedException {

       // new MyThreadRead().start();
       // new MyThreadWrite().start();
        for (j = 0; j <10_000 ; j++) {
            new MyThread().start();
        }
        Thread.sleep(1_000);
        System.out.println(atomicInteger.get());
    }

    public static void main(String[] args) throws InterruptedException {
        new LessonThreadsVolatile();
    }

    static class MyThreadWrite extends Thread{
        @Override
        public void run() {
            while (i < 5){
                System.out.println("increment i : " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            super.run();
        }
    }
    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localValue = i;
            while (localValue < 5){

                // value localValue = 0 in cache memory

                if(localValue != i){
                    System.out.println("new value of i : " + i);
                    localValue = i;
                }
            }

            super.run();
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
            super.run();
        }
    }
}
