package Triangles;


import static Triangles.Aplikacja.CELL_SIZE;
import static Triangles.Aplikacja.DIMENTION_X;
import static Triangles.Aplikacja.DIMENTION_Y;
import static Triangles.Aplikacja.list;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
class Board extends JPanel
{

    public Board()
    {      
        this.setPreferredSize(new Dimension(CELL_SIZE*DIMENTION_X,CELL_SIZE*DIMENTION_Y));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        super.paintComponent(g);
        int i,j,x,y;
        for(i=0;i<DIMENTION_X;i++)
        {
            for(j=0;j<DIMENTION_Y;j++)
            {
                x=i*CELL_SIZE;
                y=j*CELL_SIZE;
                g.drawRect(x,y,CELL_SIZE,CELL_SIZE);
                if(list.contains(new Node(i,j,false)))
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[]{x,x+CELL_SIZE,x+CELL_SIZE/2}, new int[]{y,y,y+CELL_SIZE}, 3);
                    
                }
                if(list.contains(new Node(i,j,true)))
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[]{x+CELL_SIZE/2,x,x+CELL_SIZE}, new int[]{y,y+CELL_SIZE,y+CELL_SIZE}, 3);
                }
                g.setColor(Color.black);
            }
        }
    }  
    
    
}
