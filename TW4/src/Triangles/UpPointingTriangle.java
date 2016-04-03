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
public class UpPointingTriangle extends Triangle
{

    
    Triangle upperLeft;
    Triangle upperRight;
    Triangle bottom;
    
    UpPointingTriangle()
    {
        this.bottom=null;
        this.upperLeft=null;
        this.upperRight=null;
    }
    
    void setUpperLeft(Triangle t)
    {
        this.upperLeft=t;
    }
    
    void setUpperRight(Triangle t)
    {
        this.upperRight=t;
    }
    
    void setBottom(Triangle t)
    {
        this.bottom=t;
    }
}
