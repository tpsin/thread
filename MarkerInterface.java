interface  Daemonable {}

class MyThread extends Thread implements Runnable, Daemonable  {

    @Override
    public void run() {}

}

public class MarkerInterface {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        if(new MyThread() instanceof Daemonable) {
            myThread.setDaemon(true);
        } else {
            myThread.setDaemon(false);
        }
        System.out.println("Is myThread a deamon? " + myThread.isDaemon());
    }
}
