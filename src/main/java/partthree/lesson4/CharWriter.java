package partthree.lesson4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CharWriter {

    static final char[] CHARS = {'A','B','C'};
    static final Object mon = new Object();
    static int count = 5;
    static int i = 0;


public static void charWriter(char ch){

    try{
        for (int j = 0; j < count; j++) {
            synchronized (mon){
                while (ch != CHARS[i%3]){
                    mon.wait();
                }
                System.out.println(ch);
                i++;
                mon.notifyAll();
            }
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(()-> charWriter('A'));
        service.execute(()-> charWriter('B'));
        service.execute(()-> charWriter('C'));

        service.shutdown();


    }


}
