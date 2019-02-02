package LessonsJava.LessonThreadsJava.LessonThreadsThreadFactory;

import java.util.concurrent.ThreadFactory;

public class LessonThreadsThreadFactory {

    // interface which use when we want synchronized threads for something characters

    LessonThreadsThreadFactory(){
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY); // synchronized for MAX_PRIORITY
                return thread;
            }
        };
        threadFactory.newThread(new MyRunnable()).start();
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(1);
        }
    }
    public static void main(String[] args) {
        new LessonThreadsThreadFactory();
    }
}
