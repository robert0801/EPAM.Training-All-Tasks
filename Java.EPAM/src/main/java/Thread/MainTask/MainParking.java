package Thread.MainTask;

import java.util.concurrent.Semaphore;

public class MainParking {
    public static void main(String[] args) {
        Semaphore parkingPlace = new Semaphore(3);

        Car car1 = new Car("Вася", parkingPlace);
        Car car2 = new Car("Костя", parkingPlace);
        Car car3 = new Car("Петя", parkingPlace);
        Car car4 = new Car("Игорь", parkingPlace);
        Car car5 = new Car("Иван", parkingPlace);
        Car car6 = new Car("Олег", parkingPlace);
        Car car7 = new Car("Вика", parkingPlace);
        Car car8 = new Car("Оля", parkingPlace);
        Car car9 = new Car("Аня", parkingPlace);
        Car car10 = new Car("Лена", parkingPlace);


        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();
        car9.start();
        car10.start();

    }
}

