/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class DownPointingTriangle extends Triangle
{
    Triangle bottomLeft;
    Triangle bottomRight;
    Triangle upper;
    
    DownPointingTriangle()
    {
        this.upper=null;
        this.bottomLeft=null;
        this.bottomRight=null;
    }
    
    void setBottomLeft(Triangle t)
    {
        this.bottomLeft=t;
    }
    
    void setBottomRight(Triangle t)
    {
        this.bottomRight=t;
    }
    
    void setUpper(Triangle t)
    {
        this.upper=t;
    }

}
