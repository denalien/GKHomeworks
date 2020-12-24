package partthree.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch prepare = new CountDownLatch(CARS_COUNT);
    public static Semaphore smp = new Semaphore(CARS_COUNT/2);
    public static Lock finish = new ReentrantLock();
    public static CountDownLatch end = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }



        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            prepare.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            end.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}