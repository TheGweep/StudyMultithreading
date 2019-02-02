package LessonsJava.LessonThreadsJava.LessonThreadsExchanger;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Exchanger;

public class LessonThreadsExchanger {

    // Exchanger use for send data between threads
    // also use for synchronize and swap (exchange) message
    Exchanger<String> exchanger = new Exchanger<>();
    LessonThreadsExchanger(){
        new Person(exchanger);
        new PersonData(exchanger);
    }

    public static void main(String[] args) {
        new LessonThreadsExchanger();
    }

    static class Person extends Thread{
        Exchanger<String> exchanger;
        private String name;
        private String parseAge;
        private int age;
        Person(Exchanger<String> exchanger){
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print("Enter name: ");
               name = bufferedReader.readLine();
                System.out.print("Enter age: ");
                parseAge = bufferedReader.readLine();
                age = Integer.parseInt(parseAge);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                exchanger.exchange("Hi my name is " + name); // begin and wait exchanger in other threads
                sleep(3_000);
                exchanger.exchange("I'm " + age + " years old");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class PersonData extends Thread{
        Exchanger<String> exchanger;

        PersonData( Exchanger<String> exchanger){
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {

            try {
                System.out.println(exchanger.exchange(null)); // this thread wait first exchanger
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
