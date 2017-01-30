/*
 * Reference: Multithreading InterThread Communication  Producer Consumer.mp4
 */
package interthread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class InterThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Producer(counter);
        new Consumer(counter);
    }
    
}
