package LessonsJava.LessonThreadsJava.LessonThreadsPhaser;


import java.util.concurrent.Phaser;

public class LessonThreadsPhaser {

    // Phaser split work threads on parts
    // and thread wait while all his parts not being completed
    // after begin other thread

    LessonThreadsPhaser(){
        Phaser phaser = new Phaser(2);
        new MyPhaser(phaser);
        new MyPhaser(phaser);
    }

    public static void main(String[] args) {
        new LessonThreadsPhaser();
    }

    static class MyPhaser extends Thread {
        Phaser phaser;
        public MyPhaser(Phaser phaser) {
            this.phaser = phaser;
            start();
        }
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                try {
                    System.out.println(getName() + " working phaser");
                    sleep(1_000);
                    //System.out.println(this.getId());
                    phaser.arriveAndAwaitAdvance(); // wait phaser while threads call this method
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(this.getId()%2 == 0) {
                    try {
                        System.out.println(" thread completed");
                        sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }
}
