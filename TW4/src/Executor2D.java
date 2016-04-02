/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class Executor2D extends Thread
{
    @Override
    public synchronized void run()
    {
        Counter counter = new Counter(this);
        
        Triangle S = new Triangle();
        S.setLabel("S");
        
        P12D p1 = new P12D(S,counter);
        p1.start();
        
        counter.release();
        
        P52D p5a = new P52D(p1.triangleA,counter);
        p5a.start();
        
        counter.release();
        
        P112D p11a = new P112D(p5a.triangleA,counter);
        P122D p12a = new P122D(p5a.triangleA,counter);
        p11a.start();
        p12a.start();
        
        counter.release();
        
        P52D p5b = new P52D(p11a.triangleA,counter);
        P52D p5c = new P52D(p12a.triangleA,counter);
        p5b.start();
        p5c.start();
        
        counter.release();
        
        P112D p11b = new P112D(p5b.triangleA,counter);
        P122D p12b = new P122D(p5c.triangleA,counter);
        P152D p15a = new P152D(p5b.triangleA,p5c.triangleA,counter);
        p11b.start();
        p12b.start();
        p15a.start();
        
        counter.release();
        
        System.out.println("done");
    }
}
