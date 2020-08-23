package Thread.MainTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private String name;
    private Semaphore parkingPlace;

    public Car(String name, Semaphore semaphore) throws InterruptedException {
        this.name = name;
        this.parkingPlace = semaphore;
        this.join();
    }

    public String getNameCar() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this.getNameCar() + " приехал на стоянку в поисках парковочного места.");
        try {
            if (parkingPlace.availablePermits() == 0) {
                System.out.println(this.getNameCar() + " ожидает свободное парковочное место 10 секунд.");
                TimeUnit.SECONDS.sleep(10);
                if (parkingPlace.availablePermits() == 0) {
                    System.out.println(this.getNameCar() + " не нашел парковочного места и уехал.");
                    this.interrupt();
                } else {
                    this.stoppingOnParking();
                }
            } else {
                this.stoppingOnParking();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stoppingOnParking(){
        try {
            parkingPlace.acquire();
            System.out.println(this.getNameCar() + " стоит на парковке 5 секунд");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(this.getNameCar() + " уехал с парковки и освободил парковочное место");
            parkingPlace.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
