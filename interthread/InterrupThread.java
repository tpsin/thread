/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author antonio
 */


interface Killable {}

public class InterrupThread {

    public static void main(String[] args) throws InterruptedException {

        Shared shared = new Shared();
        Consumer consumer = new Consumer(shared);
        Producer producer = new Producer(shared, consumer);
        Thread.sleep(1000);
        // producer.thread.stop(); // UNSAFE. It causes Starvation.
        producer.thread.interrupt();
    }
}

class Shared {

    Integer shared = null;
    boolean isSet = false;

    synchronized void put(Integer number) {
        while(isSet) {
            try{wait();} catch(Exception e){}
        }
        this.shared = number;
        isSet = true;
        notify();
    }
    synchronized Integer get() {
        while(!isSet) {
            try{wait();} catch(Exception e){}
        }
        isSet = false;
        notify();
        return this.shared;
    }
}

class Producer implements Runnable {

    Shared shared;
    Thread thread;
    Consumer consumer;

    Producer(Shared shared) {
        this.shared = shared;
        this.thread = new Thread(this);
        this.thread.start();
    }

    Producer(Shared shared, Consumer consumer) {
        this.shared = shared;
        this.consumer = consumer;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        Integer number = new Integer(0);
        while(true) {
            number++;
            try{
                Thread.sleep(new Random().nextInt(400));
            } catch (Exception e){
                System.out.println("Producer is going to be killed but ...");
                this.consumer.thread.interrupt();
                return;
            }
            this.shared.put(number);
        }
    }

}

class Consumer implements Runnable {

    Shared shared;
    Thread thread;

    Consumer(Shared shared) {
        this.shared = shared;
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(new Random().nextInt(300));
            } catch (Exception e){
                System.out.println("Consumer is dying... ");
                return;
            }
            System.out.println("Consumer: " + this.shared.get());
        }
    }
}
