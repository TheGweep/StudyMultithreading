package LessonsJava.LessonThreadsJava.LessonThreadsDeadlock;

public class LessonThreadsDeadlock {

    // deadlock problem which begin when one thread have link on resource in two thread,
    // two thread have link on resource in one thread

    // in threads resources have link on himself

    LessonThreadsDeadlock(){
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        MyThread myThread = new MyThread();
        MyThread1 myThread1 = new MyThread1();
        myThread.resourceA = resourceA;
        myThread1.resourceB = resourceB;
        myThread.start();
        myThread1.start();

    }


    public static void main(String[] args) {
        new LessonThreadsDeadlock();

    }

}

class  MyThread extends Thread {
    ResourceA resourceA;
    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class MyThread1 extends Thread {
    ResourceB resourceB;
    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;
    public synchronized int getI(){

        return ResourceB.returnI();
    }
    public static synchronized int returnI(){
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;
    public synchronized int getI(){

        return ResourceA.returnI();
    }
    public static synchronized int returnI(){
        return 2;
    }
}
