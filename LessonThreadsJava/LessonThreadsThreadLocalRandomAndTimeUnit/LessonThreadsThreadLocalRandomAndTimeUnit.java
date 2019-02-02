package LessonsJava.LessonThreadsJava.LessonThreadsThreadLocalRandomAndTimeUnit;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class LessonThreadsThreadLocalRandomAndTimeUnit {
    LessonThreadsThreadLocalRandomAndTimeUnit() throws InterruptedException {
        System.out.println(Math.random());

        // use in threads when need random

        System.out.println(ThreadLocalRandom.current().nextInt());

        // use TimeUnit when need set time in methods in threads

       // Thread.sleep(TimeUnit.DAYS.toMinutes(7));
        System.out.println(TimeUnit.DAYS.toSeconds(7));
    }

    public static void main(String[] args) throws InterruptedException {
        new LessonThreadsThreadLocalRandomAndTimeUnit();
    }
}
