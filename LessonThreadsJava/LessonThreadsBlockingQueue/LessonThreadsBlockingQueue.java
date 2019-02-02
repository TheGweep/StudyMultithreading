package LessonsJava.LessonThreadsJava.LessonThreadsBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class LessonThreadsBlockingQueue {

    BlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();


    LessonThreadsBlockingQueue(){
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(blockingQueue.take()); // wait for string writing in thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                blockingQueue.add("this is string");
            }
        }.start();
    }

    public static void main(String[] args) {
        new LessonThreadsBlockingQueue();
    }

}
