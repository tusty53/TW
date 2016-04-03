package Triangles;

import static Triangles.Aplikacja.N;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class RepeatableExecutor extends Thread
{
    @Override
    public synchronized void run()
    {
        Counter counter = new Counter(this);
        StructDrawer drawer = new StructDrawer();
        ArrayList<Production2D> ups = new ArrayList<>();
        ArrayList<Production2D> downs = new ArrayList<>();
        Triangle S = new Triangle();
        S.setLabel("S");
        int i,j;
        
        P12D p1 = new P12D(S,counter);
        p1.start();
        
        counter.release();
        ups.add(p1);
        drawer.draw(p1.triangleA);
        
        for(j=1;j<N;j++)
        {
            for (Production2D p : ups) 
            {
                P52D p5 = new P52D(p.triangleA,counter);
                downs.add(p5);
                p5.start();
                
            }
            counter.release();
            ups.clear();
            drawer.draw(p1.triangleA);

            for (i=0;i<downs.size();i++)
            {
                if(i==0)
                {
                    P122D p12 = new P122D(downs.get(i).triangleA,counter);
                    ups.add(p12);
                    p12.start();
                    
                }
                if(i==downs.size()-1)
                {
                    P112D p11 = new P112D(downs.get(i).triangleA,counter);
                    ups.add(p11);
                    p11.start();
                    
                }
                else
                {
                    P152D p15 = new P152D(downs.get(i+1).triangleA,downs.get(i).triangleA,counter);
                    ups.add(p15);
                    p15.start();
                    
                }
            }
            counter.release();
            downs.clear();
            drawer.draw(p1.triangleA);
        }
        
        
        
        System.out.println("done");
    }
}
