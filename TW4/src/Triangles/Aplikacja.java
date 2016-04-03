package Triangles;


import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;




class Aplikacja extends JFrame{
    
    public static int CELL_SIZE=30;
    public static int DIMENTION=5;
    public JPanel panel;
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
        setSize(CELL_SIZE*DIMENTION,CELL_SIZE*DIMENTION);
        this.pack();
    }
    public void refresh()
    {
        this.removeAll();
        this.add(new Board());
    }
    public static void main(String args[]){

        Executor2D e = new Executor2D();
        e.start();
        /*EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Aplikacja ex = new Aplikacja();
            ex.setVisible(true);
        }
        });*/
        Aplikacja ex=new Aplikacja();
        ex.setVisible(true);
    }
}
