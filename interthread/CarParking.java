import java.util.Random;

class Car extends Thread {

    Parking parking;

    Car(Parking parking) {
        this.parking = parking;
        this.start();
    }

    public void run() {
        this.parking.checkIn(this);
        try {Thread.sleep(new Random().nextInt(30_000));} catch (Exception ex) {}
        this.parking.checkOut(this);
    }
}

class Parking {
    Integer vacancies = new Integer(10);

    synchronized void checkIn (Car c) {
        while(vacancies < 1) {
            try {wait();} catch (Exception ex) {}
        }
        if(vacancies > 0) {
            vacancies --;
            System.out.println("Car " + c.getName() + " is entering");
        }
    }

    synchronized void checkOut(Car c) {
        System.out.println("Car " + c.getName() + " is exting");
        vacancies ++;
        notifyAll();
    }

    void showVacancies () {
        System.out.println("*** Parking vacancies are: " +  this.vacancies + " ***");
    }
}

public class CarParking {

    public static void main(String[] args) throws Exception{
        Parking parking = new Parking();
        Runnable r1 = () -> {
            while(true) {
                parking.showVacancies();
                try{Thread.sleep(5000);} catch (Exception e) {}
            }
        };

        new Thread(r1).start();
        for (int i = 0; i < 30; i++) {
            Thread.sleep(new Random().nextInt(2000));
            new Car(parking);
        }
    }
}
