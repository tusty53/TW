package Triangles;


import java.awt.EventQueue;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;




class Aplikacja extends JFrame{
    
    public static int CELL_SIZE=30;
    public static int N=3;
    public static int DIMENTION_X;
    public static int DIMENTION_Y;
    public static int DIMENTION;
    public JPanel panel;
    public static Boolean isTriangle=true;
    public static ArrayList<Node> list=new ArrayList<Node>();
    public static ArrayList<Node> temp=new ArrayList<Node>();
    
    Aplikacja()
    {
        initUI();
    }
    
    public void initUI()
    {
        panel=new Board();
        this.add(panel);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,300);
    }
    public void refresh()
    {
        this.removeAll();
        this.add(new Board());
    }
    public static void main(String args[]) throws InterruptedException{
        
        if(isTriangle)
        {
            System.out.println("Podaj ilość powtórzeń:");
            Scanner in = new Scanner(System.in);
            N= in.nextInt();
            DIMENTION_X=2*N-1;
            DIMENTION_Y=N;
        }
        else
        {
            DIMENTION_X=DIMENTION;
            DIMENTION_Y=DIMENTION;
        }
        RepeatableExecutor e = new RepeatableExecutor();
        e.start();

        Aplikacja ex=new Aplikacja();
        ex.setVisible(true);
        while(e.isAlive())
        {
            ex.revalidate();
            ex.repaint();
            sleep(10);
        }
        ex.revalidate();
        ex.repaint();
        
        
    }
}
