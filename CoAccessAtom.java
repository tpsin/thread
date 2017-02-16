/*
 * Concurrent access to shared variables using atomic instruction.
 */
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Antonio Pierro
 */


public class CoAccessAtom {

    static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        Runnable r = () -> IntStream.range(0, 500000).forEach(i -> CoAccessAtom.counter.incrementAndGet());
        Thread thread1 = new Thread(r);
        thread1.start();
        Thread thread2 = new Thread(r);
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){}

        System.out.println("Counter value: " + counter);

    }
}
