package Triangles;

import static Triangles.Aplikacja.temp;
import static Triangles.Aplikacja.list;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
class StructDrawer
{
    
    void draw(Triangle triangleA)
    {
        MaxDirections max= new MaxDirections();
        Depth d=new Depth();
        temp.clear();
        walkThroughStruct(triangleA,0,0,max,d);
        System.out.println("AFTER");
        System.out.println("Up: "+max.up+" Down: "+max.down+" Right: "+max.right+" Left: "+max.left);
        clear(triangleA);
        temp.forEach((node)->node.normalise(max.left,max.up));
        temp.forEach((node)->System.out.println("X: "+node.x+"Y: "+node.y));
        synchronized(list)
        {
            list.clear();
            temp.forEach((node)->list.add(node));
        }
    }

    private void walkThroughStruct(Triangle triangle, int x, int y, MaxDirections max,Depth depth)
    {
        if(!triangle.visited)
        {
            triangle.visited=true;
            System.out.println(triangle.label);
            max.check(x,y);
            
            System.out.println("X: "+x+" Y: "+y);
            System.out.println("Up: "+max.up+" Down: "+max.down+" Right: "+max.right+" Left: "+max.left);
            if(triangle instanceof UpPointingTriangle)
            {
                temp.add(new Node(x,y,true));
                if((((UpPointingTriangle)triangle).bottom!=null)&&(!((UpPointingTriangle)triangle).bottom.visited))
                {
                    walkThroughStruct(((UpPointingTriangle)triangle).bottom,x,y-1,max,depth);
                }
                if((((UpPointingTriangle)triangle).upperLeft!=null)&&(!((UpPointingTriangle)triangle).upperLeft.visited))
                {
                    walkThroughStruct(((UpPointingTriangle)triangle).upperLeft,x-1,y+1,max,depth);
                }
                if((((UpPointingTriangle)triangle).upperRight!=null)&&(!((UpPointingTriangle)triangle).upperRight.visited))
                {
                    walkThroughStruct(((UpPointingTriangle)triangle).upperRight,x+1,y+1,max,depth);
                }
            }
            if(triangle instanceof DownPointingTriangle)
            {
                temp.add(new Node(x,y,false));
                if((((DownPointingTriangle)triangle).upper!=null)&&(!((DownPointingTriangle)triangle).upper.visited))
                {
                    walkThroughStruct(((DownPointingTriangle)triangle).upper,x,y+1,max,depth);
                }
                if((((DownPointingTriangle)triangle).bottomLeft!=null)&&(!((DownPointingTriangle)triangle).bottomLeft.visited))
                {
                    walkThroughStruct(((DownPointingTriangle)triangle).bottomLeft,x-1,y-1,max,depth);
                }
                if((((DownPointingTriangle)triangle).bottomRight!=null)&&(!((DownPointingTriangle)triangle).bottomRight.visited))
                {
                    walkThroughStruct(((DownPointingTriangle)triangle).bottomRight,x-1,y-1,max,depth);
                }
            }
        }
    }
    private void clear(Triangle triangle)
    {
        if(triangle.visited)
        {
            triangle.visited=false;            
            if(triangle instanceof UpPointingTriangle)
            {
                if(((UpPointingTriangle)triangle).bottom!=null)
                {
                    clear(((UpPointingTriangle)triangle).bottom);
                }
                if(((UpPointingTriangle)triangle).upperLeft!=null)
                {
                   clear(((UpPointingTriangle)triangle).upperLeft);
                }
                if(((UpPointingTriangle)triangle).upperRight!=null)
                {
                    clear(((UpPointingTriangle)triangle).upperRight);
                }
            }
            if(triangle instanceof DownPointingTriangle)
            {
                if(((DownPointingTriangle)triangle).upper!=null)
                {
                    clear(((DownPointingTriangle)triangle).upper);
                }
                if(((DownPointingTriangle)triangle).bottomLeft!=null)
                {
                    clear(((DownPointingTriangle)triangle).bottomLeft);
                }
                if(((DownPointingTriangle)triangle).bottomRight!=null)
                {
                    clear(((DownPointingTriangle)triangle).bottomRight);
                }
            }
        }
    }
    
}
