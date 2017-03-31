import java.util.Random;

class Car extends Thread {
    
    Parking parking = new Parking();
    
    Car(Parking parking) {
        this.parking = parking;
        this.start();
    }

    public void run() {
        this.parking.enter(this);
        try {Thread.sleep(new Random().nextInt(20_000));} catch (Exception ex) {}
        this.parking.exit(this);
    }
}

class Parking {
    Integer vacancies = new Integer(10);
    
    synchronized void enter (Car c) {
        while(vacancies < 1) {
            try {wait();} catch (Exception ex) {}
        }
        if(vacancies > 0) {
            vacancies --;
            System.out.println("Car " + c.getName() + " is entering");
        }
    }
    
    synchronized void exit(Car c) {
        System.out.println("Car " + c.getName() + " is exting");
        vacancies ++;
        notifyAll();
    } 
}

public class CarParking {
    
    public static void main(String[] args) {
        Parking parking = new Parking();
        for (int i = 0; i < 50; i++) {
            new Car(parking);
        }
    }
}
