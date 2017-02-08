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
        Shared shared = new Shared();
        new Producer(shared);
        new Consumer(shared);
    }
    
}
