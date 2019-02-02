package LessonsJava.LessonThreadsJava.LessonThreadsReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LessonThreadsReentrantLock {

    LessonThreadsReentrantLock() throws InterruptedException {
        Resource resource = new Resource();
        resource.setI(5);
        resource.setK(5);
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread1 = new MyThread();
        myThread.resource = resource;
        myThread1.resource = resource;
        myThread.start();
        myThread1.start();
        myThread.join();
        myThread1.join();
        System.out.println(resource.getI());
        System.out.println(resource.getK());

    }
    public static void main(String[] args) throws InterruptedException {
        new LessonThreadsReentrantLock();
    }
}

class MyThread extends Thread{
    Resource resource;
    @Override
    public void run() {
        resource.changeI();
       // resource.changeK();
    }
}

class Resource {
    private int i;
    private int k;
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //
    Lock lock = new ReentrantLock(); // lock work as if we synchronized method


    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    void changeI(){
         lock.lock(); // begin lock
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        i++;
        this.i = i;
       // lock.unlock(); // end lock
        this.changeK();
    }

    void changeK(){
        //lock.lock(); // begin lock
        int k = this.k;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        k++;
        this.k = k;
        lock.unlock(); // end lock
    }
}
