/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author professores
 */
public class Monitor implements Runnable{
    public int curr;
    Thread th;
    
    public Monitor() {
        th = new Thread(this);
        th.start();
    }    

    @Override
    public void run() {
        System.out.println("monitorando (thread : "+(th.getId()-12)+")");
        for (int i = 0; i < 1000000; i++) {
            curr = i;
            System.out.print("\r             ");
        }        
        System.out.println("\rterminado (thread : "+(th.getId()-12)+")");
    }
    
}
