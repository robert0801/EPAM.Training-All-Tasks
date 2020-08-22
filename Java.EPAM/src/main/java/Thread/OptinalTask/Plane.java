package Thread.OptinalTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Plane extends Thread{
    private Semaphore runway;
    private String namePlane;

    public Plane(Semaphore runway, String namePlane) {
        this.runway = runway;
        this.namePlane = namePlane;
    }

    public String getNamePlane() {
        return namePlane;
    }

    @Override
    public void run() {
        try {
            runway.acquire();
            System.out.println(this.getNamePlane() + " начал выход на полосу.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Полоса \"приняла\" " + this.getNamePlane());
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this.getNamePlane() + " взлетел.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Полоса освободилась");
            runway.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
