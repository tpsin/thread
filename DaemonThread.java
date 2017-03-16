public class DaemonThread {
    
    public static void main(String[] args) throws InterruptedException {
        
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try{Thread.sleep(100);} catch (Exception e) {}
                System.out.println("Hello" + i);
            }
        });
        t.setDaemon(true);
        t.start();
        Thread.sleep(400);
        return;
    }
}
