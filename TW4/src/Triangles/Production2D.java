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
public abstract class Production2D extends Thread
{
    Triangle triangleA;
    Triangle triangleB;
    Triangle triangleC;
    StructDrawer drawer = new StructDrawer();
    Counter cntr;
    
    Production2D(Triangle a,Triangle b,Triangle c,Counter Count)
    {
        this.triangleA=a;
        this.triangleB=b;
        this.triangleC=c;
        this.cntr=Count;
        
    }
    
    abstract Triangle apply(Triangle a,Triangle b, Triangle c);//returns always the highest one
    
    @Override
    public void run()
    {
        this.cntr.inc();
        triangleA=apply(triangleA,triangleB,triangleC);
        this.cntr.dec();
    }
    
}

class P12D extends Production2D
{

    public P12D(Triangle a, Counter Count)
    {
        super(a, null, null, Count);
    }

    @Override
    Triangle apply(Triangle a, Triangle b, Triangle c)
    {
        System.out.println("P1 - 2D");
        UpPointingTriangle E1 = new UpPointingTriangle();
        E1.setLabel("E1");
        return E1;
    }
    
}

class P52D extends Production2D
{

    public P52D(Triangle a, Counter Count)
    {
        super(a, null, null, Count);
    }

    @Override
    Triangle apply(Triangle a, Triangle b, Triangle c)
    {
        
        System.out.println("P5 - 2D");
        DownPointingTriangle E2 = new DownPointingTriangle();
        E2.setLabel("E2");
        ((UpPointingTriangle)a).setBottom(E2);
        E2.setUpper(a);
        return E2;
    }
    
}

class P112D extends Production2D
{

    public P112D(Triangle a,Counter Count)
    {
        super(a, null, null, Count);
    }

    @Override
    Triangle apply(Triangle a, Triangle b, Triangle c)
    {
        System.out.println("P11 - 2D");
        UpPointingTriangle E1 = new UpPointingTriangle();
        E1.setLabel("E1");
        ((DownPointingTriangle)a).setBottomRight(E1);
        E1.setUpperLeft(a);
        return E1;
    }
    
}

class P122D extends Production2D
{

    public P122D(Triangle a,Counter Count)
    {
        super(a, null, null, Count);
    }

    @Override
    Triangle apply(Triangle a, Triangle b, Triangle c)
    {
        System.out.println("P12 - 2D");
        UpPointingTriangle E1 = new UpPointingTriangle();
        E1.setLabel("E1");
        ((DownPointingTriangle)a).setBottomLeft(E1);
        E1.setUpperRight(a);
        return E1;
    }
    
}
class P152D extends Production2D
{

    public P152D(Triangle a, Triangle b, Counter Count)
    {
        super(a, b, null, Count);
    }

    @Override
    Triangle apply(Triangle a, Triangle b, Triangle c)
    {
        System.out.println("P15 - 2D");
        UpPointingTriangle E1 = new UpPointingTriangle();
        E1.setLabel("E1");
        ((DownPointingTriangle)b).setBottomLeft(E1);
        ((DownPointingTriangle)a).setBottomRight(E1);
        E1.setUpperRight(b);
        E1.setUpperLeft(a);
        return E1;
    }
    
}
