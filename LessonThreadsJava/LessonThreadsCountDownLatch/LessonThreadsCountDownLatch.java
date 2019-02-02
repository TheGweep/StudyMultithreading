package LessonsJava.LessonThreadsJava.LessonThreadsCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class LessonThreadsCountDownLatch {

    // CountDownLatch use when need wait ending set count threads and after continue work with resource
    private CountDownLatch countDownLatch = new CountDownLatch(3);



    LessonThreadsCountDownLatch() throws InterruptedException {
       // CountDownLatch countDownLatch = new CountDownLatch(3);

        new Work(countDownLatch).start();
        new Work(countDownLatch).start();
        new Work(countDownLatch).start();

        countDownLatch.await();

        System.out.println("all works completed");

    }

    public static void main(String[] args) throws InterruptedException {
        new LessonThreadsCountDownLatch();
    }
}
class Work extends Thread{
    private CountDownLatch countDownLatch;

    Work(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " work is done");
        countDownLatch.countDown(); // decrement count threads
    }
}
