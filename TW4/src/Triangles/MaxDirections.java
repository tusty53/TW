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
public class MaxDirections
{
    int up;
    int down;
    int left;
    int right;
    
    MaxDirections()
    {
        this.up=0;
        this.down=0;
        this.left=0;
        this.right=0;
    }
    
    void increaseUp(int y)
    {
        if(y>this.up)
            this.up=y;
    }
    
    void increaseDown(int y)
    {
        if(y<this.down)
            this.down=y;
    }
    
    void increaseLeft(int x)
    {
        if(x<this.left)
            this.left=x;
    }
    void increaseRight(int x)
    {
        if(x>this.right)
            this.right=x;
    }

    void check(int x, int y)
    {
        increaseUp(y);
        increaseDown(y);
        increaseLeft(x);
        increaseRight(x);
    }
    
}
