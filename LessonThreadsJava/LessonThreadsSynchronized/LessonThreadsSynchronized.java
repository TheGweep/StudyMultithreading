package LessonsJava.LessonThreadsJava.LessonThreadsSynchronized;

public class LessonThreadsSynchronized {

    LessonThreadsSynchronized() throws InterruptedException {


        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread1 = new MyThread();
        //Resource resource = new Resource();
        Resource.id = 6;

        /*resource.setId(9);
        myThread.setResource(resource);
        myThread1.setResource(resource);*/
        myThread.start();
        myThread1.start();
        myThread.join();
        myThread1.join();
        System.out.println(Resource.id);
    }

    public static void main(String[] args) throws InterruptedException {
        new LessonThreadsSynchronized();
    }
}

class MyThread extends Thread{

    Resource resource = new Resource();

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public  void run() {
        //resource.changeId();
       resource.changeStaticId();
        resource.staticId();

        super.run();
    }
}

class Resource {
     static int id;


    public synchronized static void changeStaticId() {
        int id = Resource.id;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        id++;
        Resource.id = id;

        // level synchronized static method, field
        // may be doing together with not synchronized method, field
        // never combine static and non static synchronized

        synchronized (Resource.class){

        }


    }


    public  int getId() {
        return id;
    }

    public  synchronized void setId(int id) {
        this.id = id;
    }

// synchronized don't block while prev thread not end (lock)

    public synchronized void changeId(){

        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        int id = this.id;
        id++;
        this.id = id;

        synchronized (this){
            // synchronized this block
        }
    }

    public synchronized void staticId(){
        int id = Resource.id;
        if(Thread.currentThread().getName().equals("one")){
            Thread.yield();
        }
        id++;
        Resource.id = id;


    }

}