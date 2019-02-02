package LessonsJava.LessonThreadsJava.LessonThreadsSynchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LessonThreadsSynchronizedCollection  {

 // use synchronized collection  when return list
    // better return list clone object but not this list

    LessonThreadsSynchronizedCollection(){
        ListClass listClass = new ListClass();
        listClass.add("first");

        class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println(listClass.removeFirst());
                super.run();
            }
        }
        MyThread myThread = new MyThread();
        myThread.setName("one");
        myThread.start();
        new MyThread().start();

    }

    public static void main(String[] args) {
        new LessonThreadsSynchronizedCollection();
    }

    static class ListClass {
        // all methods synchronized in list
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name){
            list.add(name);
        }

        public synchronized   String removeFirst(){
            if(list.size() > 0) {
                if(Thread.currentThread().getName().equals("one")){
                    Thread.yield();
                }
                return (String) list.remove(0);
            }
            return null;
        }

    }

}
