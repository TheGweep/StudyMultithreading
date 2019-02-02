package LessonsJava.LessonThreadsJava.LessonThreadsSemaphores;

import java.util.concurrent.Semaphore;

public class LessonThreadsSemaphores {


    // semaphores need for set limit threads which was work together
  static Semaphore semaphore = new Semaphore(3);

    LessonThreadsSemaphores() {
        Person person = new Person();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();

        person.start();
        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
    }

    public static void main(String[] args) {
        new LessonThreadsSemaphores();
    }

    static class Person extends Thread{
        @Override
        public void run() {
            System.out.println(this.getName() + " waiting");
            try {
                semaphore.acquire();
                System.out.println(this.getName() + " eat at the table");
                this.sleep(1000);
                System.out.println(this.getName() + " release table");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
