package LessonsJava.LessonThreadsJava.LessonThreadsConditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LessonThreadsConditions {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int number = 40;
    LessonThreadsConditions(){

        //new AccountMinus().start();
        new AccountMinus().start();
        new AccountPlus().start();
    }

    public static void main(String[] args) {
        new LessonThreadsConditions();
    }

    static class AccountPlus extends Thread{
        @Override
        public void run() {
            lock.lock();
            number += 10;
            condition.signal();
            lock.unlock();

        }
    }
    static class AccountMinus extends Thread{
        @Override
        public void run() {
            if(number < 50) {
                lock.lock();
                try {
                    System.out.println(number);
                    condition.await();
                    System.out.println(number);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            number -=10;
            System.out.println(number);
            }

        }
    }
