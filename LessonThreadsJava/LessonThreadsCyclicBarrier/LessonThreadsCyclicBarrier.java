package LessonsJava.LessonThreadsJava.LessonThreadsCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LessonThreadsCyclicBarrier {

    // CyclicBarrier waiting set count threads while them ending works
    // and block work if threads more or less then set in CyclicBarrier
    LessonThreadsCyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MyArray());
        new MyThread(cyclicBarrier).start();
        new MyThread(cyclicBarrier).start();
        new MyThread(cyclicBarrier).start();


    }

    public static void main(String[] args) {
        new LessonThreadsCyclicBarrier();
    }

    static class MyArray extends Thread{
        @Override
        public void run() {
            System.out.println("all threads complete");
        }
    }

   static class MyThread extends Thread {
        CyclicBarrier barrier;

        public MyThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " working");
                barrier.await();
                System.out.println(this.getName() + " completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
