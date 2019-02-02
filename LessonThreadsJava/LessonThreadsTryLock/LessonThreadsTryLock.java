package LessonsJava.LessonThreadsJava.LessonThreadsTryLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LessonThreadsTryLock {

    static Lock lock = new ReentrantLock();

    LessonThreadsTryLock(){
        new MyThread().start();
        new MyThread1().start();
    }

    public static void main(String[] args) {
       new LessonThreadsTryLock();

    }

     // while thread lock we can do task for other thread through conditions (if - else, while, do - while)
   static class MyThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " begin working");
            while (true){
                if(lock.tryLock()){ // do task for our condition
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + " waiting");
                }
            }
        }
    }
}

