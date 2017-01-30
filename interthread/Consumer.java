/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interthread;

/**
 *
 * @author antonio
 */
class Consumer implements Runnable {

    Counter c;

    public Consumer(Counter c) {
        this.c = c;
        Thread thread = new Thread(this, "consumer");
        thread.start();
    }
    
    @Override
    public void run() {
        while(true) {
            c.get();
            try { Thread.sleep(900);} catch (Exception e) {}
        }
    }
    
}

