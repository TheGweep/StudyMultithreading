package LessonsJava.LessonThreadsJava.LessonThreadsCreateAndLife;

import java.lang.reflect.InvocationTargetException;

//Thread in pool
// every thread have new stack begin method .run(), on thread method .start()

class MyThread extends Thread{
    @Override
    public void run() {
        //System.out.println("MyThread");
        //System.out.println(MyThread.currentThread().getName()); // get name thread
        for (int i = 0; i < 10; i++) {

            System.out.println("Thread name -" + MyThread.currentThread().getName() + " i: " + i);

            // we can do sleep only current thread, not link (object) this thread
            /*try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }

        //method();
        //super.run();
    }
    private void method() {
        //System.out.println("1");
        throw new RuntimeException();
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
      //  System.out.println("MyRunnable");
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread name -" + Thread.currentThread().getName() + " i: " + i);

        }
        //System.out.println(Thread.currentThread().getName());
    }
}


public class LessonThreadsCreateAndLife {
    LessonThreadsCreateAndLife() throws InvocationTargetException, IllegalAccessException, InterruptedException {

        // extends Thread
        MyThread myThread = new MyThread();
        myThread.start();

       // myThread.join(); // start next thread when, prev thread know state dead

       // myThread.setPriority(Thread.MAX_PRIORITY);

       // MyThread.yield(); // state running --> state runnable
       // new MyThread().start();
        System.out.println(MyThread.currentThread().getName()); // get name thread

        //implements Runnable

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        //Thread thread2 = new Thread(myRunnable);
       // thread2.start();


    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        new LessonThreadsCreateAndLife();

    }

}
