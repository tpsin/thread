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

class Counter {

    int num;
    
    public void put (int i) {
        this.num = i;
        System.out.println("put: " + this.num);
    }
    
    public void get () {
        System.out.println("get: " + this.num);
    }
}
