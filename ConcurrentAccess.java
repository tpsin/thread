/*
 * Concurrent access to shared variables
 */
package concurrentaccess;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Pierro
 */

class MyThread implements Runnable {
    
    @Override
    public void run(){
       for(int i = 0; i < 5000 ; i++) {
           incrementCounter();
       }  
    }
    public static void incrementCounter(){
        ConcurrentAccess.counter++;   
    }
}

public class ConcurrentAccess {

    /**
     * @param args the command line arguments
     */
    static int counter = 0;
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        thread1.start();
        Thread thread2 = new Thread(new MyThread());
        thread2.start();
        
        // while(thread1.isAlive() || thread2.isAlive()){}
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConcurrentAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Counter : " + counter);
        
    }
}
