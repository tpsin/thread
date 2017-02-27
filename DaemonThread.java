import java.util.Random;
import java.util.stream.IntStream;

public class DaemonThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Runnable r = () -> {
            int end = new Random().nextInt(10);
            System.out.println(Thread.currentThread().getName() + " has end = " + end);
            IntStream.range(0, end).forEach(i -> {
                try {Thread.sleep(100);} catch (Exception e){}
                System.out.println(Thread.currentThread().getName() + " is running: " + i);
            });
            System.out.println(Thread.currentThread().getName() + " is terminated");
        };

        Thread t1 = new Thread(r);
        t1.setDaemon(true);
        t1.start();
        new Thread(r).run();
    }
}