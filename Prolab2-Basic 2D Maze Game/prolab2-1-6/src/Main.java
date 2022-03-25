package com.company;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;


public class Main extends JFrame{
    static int step=0;
    static int column_lenght=0;
    static ArrayList<Edge> edges=new ArrayList<Edge>();

    public Main(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {

        Main ekran = new Main("Sirinler");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(460,395);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Oyun oyun = new Oyun();
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);
        ekran.add(oyun);
        ekran.setLocationRelativeTo(null);
        ekran.setVisible(true);



        int[][] map = Oyun.readMap();
        for (short i = 0; i <step ; i++) {
            for (short j = 0; j <column_lenght ; j++) {
                Edge edge=new Edge();
                if (map[i][j] == 1) {
                    edge.r=i;
                    edge.c=j;
                    edges.add(edge);
                }
            }
        }
        for (var i:edges) {
            for (var j:edges) {
                if (i.r == j.r && i.c+1==j.c) {
                    i.neighbor[0]=j;
                }
                else if (i.r == j.r&&i.c-1==j.c) {
                    i.neighbor[1]=j;
                }
                else if (i.r+1==j.r && i.c==j.c) {
                    i.neighbor[2]=j;
                }
                else if (i.r-1==j.r && i.c==j.c) {
                    i.neighbor[3]=j;
                }
            }
        }



    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        Main.step = step;
    }

    public static int getColumn_lenght() {
        return column_lenght;
    }

    public static void setColumn_lenght(int column_lenght) {
        Main.column_lenght = column_lenght;
    }

    public static ArrayList<Edge> getEdges() {
        return edges;
    }

    public static void setEdges(ArrayList<Edge> edges) {
        Main.edges = edges;
    }

}




