package Thread.OptinalTask;

import java.util.concurrent.Semaphore;

public class Airport {
    public static void main(String[] args) {
        Semaphore subway = new Semaphore(5);
        for (int i = 1; i <= 10; i++){
            new Plane(subway, "Самолет №" + i).start();
        }
    }
}
