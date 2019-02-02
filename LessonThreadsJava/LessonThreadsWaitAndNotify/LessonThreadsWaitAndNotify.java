package LessonsJava.LessonThreadsJava.LessonThreadsWaitAndNotify;


import java.util.*;

public class LessonThreadsWaitAndNotify {


    static List<String> list = Collections.synchronizedList(new ArrayList<>());

    // wait and notify use only synchronized in one object

    LessonThreadsWaitAndNotify() throws InterruptedException {
        /*MyThread myThread = new MyThread();
        myThread.start();
        synchronized (myThread){
            myThread.wait(); // wait thread
        }
        System.out.println(myThread.getTotal());*/

            //new ThreadWriter().start();
            //new ThreadReader().start();


    }


    public static void main(String[] args) throws InterruptedException {
        //new LessonsJava.LessonThreadsJava.LessonThreadsWaitAndNotify();
        new ThreadWriter().start();
        new ThreadReader().start();

    }
    static Scanner scn = new Scanner(System.in);
    private static String str = "exit";

   static class ThreadWriter extends Thread {

      // private int number;

       @Override
       public  void run() {

          // list.add("");

           while (true) {
                {
                   synchronized (list) {
                       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                       // str = bufferedReader.readLine();
                       //number = Integer.parseInt(str);
                       //list.add(scn.nextLine());
                       // System.out.println(list.toString());
                       list.add(scn.nextLine());
                       list.notify();
                   }
                   try {
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

           }

       }
   }


   static class ThreadReader extends Thread {

        @Override
        public void run() {
                while (true){
                    synchronized (list) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                        //System.out.println(list.remove(0));
                        System.out.println(list.toString());
                }
            }
        }
    }

}

class MyThread extends Thread{

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                total += i;
              //  System.out.println(total);
                try {

                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            notify(); // give command to work for wait
        }

    }
}

