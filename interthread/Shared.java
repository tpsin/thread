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

class Shared {

    int num;
    boolean isSet = false;

    public synchronized void put (int i) {
        while(isSet) {
            try { wait(); } catch (Exception e) {}
        }
        this.num = i;
        isSet = true;
        System.out.println("put: " + this.num);
        notify();
    }

    public synchronized void get () {
        while(!isSet) {
            try { wait(); } catch (Exception e) {}
        }
        System.out.println("get: " + this.num);
        isSet = false;
        notify();
    }
}
