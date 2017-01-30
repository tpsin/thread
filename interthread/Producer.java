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
class Producer implements Runnable {
    
    Counter c;

    public Producer(Counter c) {
        this.c = c;
        Thread thread = new Thread(this, "producer");
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            c.put(i++);
            try { Thread.sleep(1000);} catch (Exception e) {            }
        }
    }
    
}
