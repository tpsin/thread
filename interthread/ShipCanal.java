/**
 *
 * @author @an_pierro
 */

class Ship implements Runnable {
    
    Canal canal;
    Thread thread;
    
    Ship(Canal canal) {
        this.canal = canal;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        canal.enter(thread);
    }
}

class Canal {
    
    boolean isOpen = true;
    
    synchronized void enter (Thread t) {
        while(!isOpen) {
            try {wait();} catch (InterruptedException ex) {}
        }
        isOpen = false;
        sail(t.getName());
        isOpen = true;
        notify();
    }
    
    void sail (String shipName) {
        System.out.print(shipName +  " entered the Panama Canal...");
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500);
                System.out.print(".");
            } catch (InterruptedException ex) {}
        }
        System.out.println(shipName + " is exit from the Panama Canal...");
    }
}

public class ShipCanal {

    public static void main(String[] args) {
        Canal canal = new Canal();
        Collection<Ship> ships = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ships.add(new Ship(canal));
        }
    }
}
