/*
 * Concurrent access to shared variables without atomic instruction.
 */
import java.util.stream.IntStream;

/**
 * @author Antonio Pierro
 */


public class CoAccess {

    static int counter = 0;

    public static void main(String[] args) {

        Runnable r = () -> IntStream.range(0, 500000).forEach(i -> CoAccess.counter++);
        Thread thread1 = new Thread(r);
        thread1.start();
        Thread thread2 = new Thread(r);
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){}

        System.out.println("Counter value: " + counter);

    }
}
