package LessonsJava.LessonThreadsJava.LessonThreadsScheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LessonScheduledExecutorService {

    // ScheduledExecutorService help take access for threads after the time which we set

    LessonScheduledExecutorService(){
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new MyThread(), 2, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }

    public static void main(String[] args) {
        new LessonScheduledExecutorService();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("after 2s");
        }
    }
}
