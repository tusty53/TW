/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangles;

/**
 *
 * @author Kuba
 */
public class Node
{
    int x=0;
    int y=0;
    Boolean up=false;
    
    Node(int x,int y, Boolean up)
    {
        this.x=x;
        this.y=y;
        this.up=up;
    }
    void normalise(int maxLeft,int maxUp)
    {
        this.x-=maxLeft;
        this.y=maxUp-this.y;
    }
    
    @Override
    public boolean equals (Object o) {
    Node x = (Node) o;
        if (x.x != this.x) return false;
        if (x.y != this.y) return false;
        if (x.up != this.up) return false;
        return true;
    }
}
