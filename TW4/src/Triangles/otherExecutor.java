package Triangles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class otherExecutor extends Thread
{
    @Override
    public synchronized void run()
    {
        Counter counter = new Counter(this);
        StructDrawer drawer = new StructDrawer();
        
        Triangle S = new Triangle();
        S.setLabel("S");
        
        P12D p1 = new P12D(S,counter);
        p1.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P52D p5a = new P52D(p1.triangleA,counter);
        p5a.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P112D p11a = new P112D(p5a.triangleA,counter);
        p11a.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P52D p5b = new P52D(p11a.triangleA,counter);
        p5b.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P112D p11b = new P112D(p5b.triangleA,counter);
        p11b.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P52D p5c = new P52D(p11b.triangleA,counter);
        p5c.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P112D p11c = new P112D(p5c.triangleA,counter);
        p11c.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P52D p5d = new P52D(p11c.triangleA,counter);
        p5d.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        P112D p11d = new P112D(p5d.triangleA,counter);
        p11d.start();
        
        counter.release();
        drawer.draw(p1.triangleA);
        
        System.out.println("done");
    }
}
