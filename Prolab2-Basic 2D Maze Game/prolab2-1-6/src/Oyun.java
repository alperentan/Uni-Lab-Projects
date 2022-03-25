package com.company;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.imageio.*;
import javax.imageio.stream.FileImageInputStream;

class Edge{
    int r,c;
    int len=-1;
    Edge[] neighbor=new Edge[4];//r l d u
    ArrayList<String> path=new ArrayList<String>();
}
public class Oyun extends JPanel implements KeyListener,ActionListener{
    Timer timer = new Timer(5, this);
    Random rand = new Random();
    static String begin1="";
    static String begin2="";
    static Oyuncu.Gozluklu gozluklu=new Oyuncu.Gozluklu();
    static Oyuncu.Tembel tembel=new Oyuncu.Tembel();
    static Dusman.Azman azman=new Dusman.Azman();
    static Dusman.Gargamel gargamel=new Dusman.Gargamel();
    static String[] b1=new String[2];
    static String[] b2=new String[2];
    static int[][] map=new int[11][13];
    static boolean sirin=false;//f tembel t gozluklu
    private BufferedImage gargamelimg,azmanimg,gozlukluimg,tembelimg,sirineimg,coinimg,mushroomimg;
    int startcol=6,startrow=5;
    boolean altinexists=false,mantarexists=false,running=false;
    long altinCreationTime=0,altinExistanceTime=0,mantarCreationTime=0,mantarExistanceTime=0;
    int delayaltin=rand.nextInt(10000);
    int delaymantar=rand.nextInt(20000);
    long bastimealtin=System.currentTimeMillis();
    long bastimemantar=System.currentTimeMillis();
    Obje.Altin altin = new Obje.Altin();
    Obje.Mantar mantar = new Obje.Mantar();
    int i;
    static Oyuncu.Puan puan=new Oyuncu.Puan();
    Karakter[] k=new Karakter[4];



    static int[][] readMap(){
        int kontrol=0;
        try {
            File myObj = new File("C:\\Users\\oguzn\\IdeaProjects\\Prolab1V2\\src\\com\\company\\harita.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(Main.getStep()==0){
                    begin1=data;
                    String[] temp=begin1.split(",");
                    b1[0]=temp[0].split(":")[1];
                    b1[1]=temp[1].split(":")[1];
                    if (b1[0].equals("Gargamel")) {
                        if (b1[1].equals("A")) {
                            gargamel.setID(0);
                            gargamel.Isim=b1[0];
                            gargamel.konum.setY(0);
                            gargamel.konum.setX(3);
                            gargamel.bx=3;
                            gargamel.by=0;
                        }
                        else if (b1[1].equals("B")) {
                            gargamel.setID(0);
                            gargamel.Isim=b1[0];
                            gargamel.konum.setY(0);
                            gargamel.konum.setX(10);
                            gargamel.bx=10;
                            gargamel.by=0;
                        }
                        else if (b1[1].equals("C")) {
                            gargamel.setID(0);
                            gargamel.Isim=b1[0];
                            gargamel.konum.setY(5);
                            gargamel.konum.setX(0);
                            gargamel.bx=0;
                            gargamel.by=5;
                        }
                        else {
                            gargamel.setID(0);
                            gargamel.Isim=b1[0];
                            gargamel.konum.setY(10);
                            gargamel.konum.setX(3);
                            gargamel.bx=3;
                            gargamel.by=10;
                        }
                    }
                    else {
                        if (b1[1].equals("A")) {
                            azman.setID(0);
                            azman.Isim=b1[0];
                            azman.konum.setY(0);
                            azman.konum.setX(3);
                            azman.bx=3;
                            azman.by=0;
                        }
                        else if (b1[1].equals("B")) {
                            azman.setID(0);
                            azman.Isim=b1[0];
                            azman.konum.setY(0);
                            azman.konum.setX(10);
                            azman.bx=10;
                            azman.by=0;
                        }
                        else if (b1[1].equals("C")) {
                            azman.setID(0);
                            azman.Isim=b1[0];
                            azman.konum.setY(5);
                            azman.konum.setX(0);
                            azman.bx=0;
                            azman.by=5;
                        }
                        else {
                            azman.setID(0);
                            azman.Isim=b1[0];
                            azman.konum.setY(10);
                            azman.konum.setX(3);
                            azman.bx=3;
                            azman.by=10;
                        }
                    }
                    Main.setStep(Main.getStep()+1);
                    continue;
                }
                if(Main.getStep()==1&&kontrol==0){
                    if (data.charAt(0)=='K') {
                        begin2=data;
                        String[] temp=begin2.split(",");
                        b2[0]=temp[0].split(":")[1];
                        b2[1]=temp[1].split(":")[1];
                        if (b2[0].equals("Gargamel")) {
                            if (b2[1].equals("A")) {
                                gargamel.setID(0);
                                gargamel.Isim=b2[0];
                                gargamel.konum.setY(0);
                                gargamel.konum.setX(3);
                                gargamel.bx=3;
                                gargamel.by=0;
                            }
                            else if (b2[1].equals("B")) {
                                gargamel.setID(0);
                                gargamel.Isim=b2[0];
                                gargamel.konum.setY(0);
                                gargamel.konum.setX(10);
                                gargamel.bx=10;
                                gargamel.by=0;
                            }
                            else if (b2[1].equals("C")) {
                                gargamel.setID(0);
                                gargamel.Isim=b2[0];
                                gargamel.konum.setY(5);
                                gargamel.konum.setX(0);
                                gargamel.bx=0;
                                gargamel.by=5;
                            }
                            else {
                                gargamel.setID(0);
                                gargamel.Isim=b2[0];
                                gargamel.konum.setY(10);
                                gargamel.konum.setX(3);
                                gargamel.bx=3;
                                gargamel.by=10;
                            }
                        }
                        else {
                            if (b2[1].equals("A")) {
                                azman.setID(0);
                                azman.Isim=b2[0];
                                azman.konum.setY(0);
                                azman.konum.setX(3);
                                azman.bx=3;
                                azman.by=0;
                            }
                            else if (b2[1].equals("B")) {
                                azman.setID(0);
                                azman.Isim=b2[0];
                                azman.konum.setY(0);
                                azman.konum.setX(10);
                                azman.bx=10;
                                azman.by=0;
                            }
                            else if (b2[1].equals("C")) {
                                azman.setID(0);
                                azman.Isim=b2[0];
                                azman.konum.setY(5);
                                azman.konum.setX(0);
                                azman.bx=0;
                                azman.by=5;
                            }
                            else {
                                azman.setID(0);
                                azman.Isim=b2[0];
                                azman.konum.setY(10);
                                azman.konum.setX(3);
                                azman.bx=3;
                                azman.by=10;
                            }
                        }
                        Main.setStep(Main.getStep()+1);
                        continue;
                    }
                    else {
                        kontrol=1;
                    }
                }
                if(data.equals(begin1)){
                    return map;
                }
                String[] row=data.split("\\s+");
                Main.setColumn_lenght(row.length);

                if (kontrol == 1) {
                    for (int i = 0; i < row.length ; i++) {
                        System.out.print(row[i]+" ");
                        map[Main.getStep()-1][i]=Integer.parseInt(row[i]);
                    }
                }
                else {
                    for (int i = 0; i < row.length ; i++) {
                        map[Main.getStep()-2][i]=Integer.parseInt(row[i]);
                    }
                }
                Main.setStep(Main.getStep()+1);
            }
            if (kontrol == 1) {
                Main.setStep(Main.getStep()-1);
            }
            else {
                Main.setStep(Main.getStep()-2);
            }

            myReader.close();
            return map;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;

        }
    }

    int tur=0;



    public Oyun(){
        try {
            gargamelimg = ImageIO.read(new FileImageInputStream(new File("img/gargamel.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            gozlukluimg = ImageIO.read(new FileImageInputStream(new File("img/gozluklu.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tembelimg = ImageIO.read(new FileImageInputStream(new File("img/tembel.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sirineimg = ImageIO.read(new FileImageInputStream(new File("img/sirine.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            azmanimg = ImageIO.read(new FileImageInputStream(new File("img/azman.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            coinimg=ImageIO.read(new FileImageInputStream(new File("img/coin.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            mushroomimg=ImageIO.read(new FileImageInputStream(new File("img/mushroom.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.start();
        String text = "Hangi baslangic karakterini secmek istersiniz?";
        String title = "Karakter secimi";
        Object[] options ={"Tembel","Gozluklu"};
        int result = JOptionPane.showOptionDialog(null,text,title,JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
        if(result == JOptionPane.YES_OPTION){
        }
        else{
            sirin=true;
        }
        running=true;


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(running){
            drawMap(g);
            drawPuanveSkor(g);
            drawAltin(g);
            drawMantar(g);
            drawOyuncu(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 30, 30);}
        else{
            drawClearMap(g);
        }




    }
    public void drawMap(Graphics g){
        for(int row=0;row<map.length;row++){
            for(int col = 0;col<map[0].length;col++){
                Color color;
                switch (map[row][col]){
                    case 0 : color = Color.BLACK; break;
                    default:color = Color.WHITE; break;
                }
                g.setColor(color);
                g.fillRect(30*col, 30*row, 30, 30);
            }
        }
        g.setColor(Color.cyan);
        int xkor,ykor;
        ArrayList <int[]> arry1=gargamel.paint(Main.getEdges(),gozluklu);
        ArrayList <int[]> arry2=gargamel.paint(Main.getEdges(),tembel);
        ArrayList <int[]> arry3=azman.paint(Main.getEdges(),gozluklu);
        ArrayList <int[]> arry4=azman.paint(Main.getEdges(),tembel);
        if(sirin){
            for(var i : arry1){
                xkor=i[0];
                ykor=i[1];
                g.fillRect(xkor*30,ykor*30,30,30);
            }
            for(var i : arry3){
                g.setColor(Color.PINK);
                xkor=i[0];
                ykor=i[1];
                g.fillRect(xkor*30,ykor*30,30,30);
            }
        }
        else{
            for(var i : arry2){
                xkor=i[0];
                ykor=i[1];
                g.fillRect(xkor*30,ykor*30,30,30);
            }
            for(var i : arry4){
                g.setColor(Color.PINK);
                xkor=i[0];
                ykor=i[1];
                g.fillRect(xkor*30,ykor*30,30,30);
            }
        }
        for(int row=0;row<map.length;row++){
            for(int col = 0;col<map[0].length;col++){
                g.setColor(Color.BLACK);
                g.drawRect(30*col, 30*row, 30, 30);
            }}
        g.setColor(Color.BLUE);
        g.fillRect(30*startcol, 30*startrow, 30, 30);

    }


    public void drawClearMap(Graphics g){
        g.clearRect(0,0,460,395);
        if(sirin){
            if(gozluklu.skorGoster()-tur<=0){
                g.drawString("Kaybettiniz.", 190, 140);
            }
            else if(gozluklu.getKonum().getX()*30==360&&gozluklu.getKonum().getY()*30==210){
                g.drawString("Kazandiniz!", 190, 140);
            }
        }
        else{
            if(tembel.skorGoster()-tur<=0){
                g.drawString("Kaybettiniz.", 190, 140);
            }
            else if(tembel.getKonum().getX()*30==360&&tembel.getKonum().getY()*30==210){
                g.drawString("Kazandiniz!", 190, 140);
            }
        }
    }

    public void drawOyuncu(Graphics g){
        if(sirin){
            g.drawImage(gozlukluimg,gozluklu.getKonum().getX()*30,gozluklu.getKonum().getY()*30,30,30,this);}
        else{
            g.drawImage(tembelimg,tembel.getKonum().getX()*30, tembel.getKonum().getY()*30,30,30,this);}
        g.drawImage(sirineimg,390, 195, 60,60,this);
        g.drawImage(gargamelimg,(gargamel.getKonum().getX()*30)-2,(gargamel.getKonum().getY()*30)-3, 35,35,this);
        g.drawImage(azmanimg,(azman.getKonum().getX()*30)-2,(azman.getKonum().getY()*30), 35,35,this);

    }
    public void drawPuanveSkor(Graphics g){
        g.setColor(Color.BLACK);
        g.drawString("Oyuncu puanı:", 0, 350);
        if(sirin){
            g.drawString(String.valueOf(puan.skorGoster(gozluklu)-tur), 80, 350);
            if(puan.skorGoster(gozluklu)-tur<=0){
                running=false;
            }
            else if(gozluklu.getKonum().getX()*30==360&&gozluklu.getKonum().getY()*30==210){
                running=false;
            }
        }

        else{
            g.drawString(String.valueOf(puan.skorGoster(tembel)-tur), 80, 350);
            if(puan.skorGoster(tembel)-tur<=0){
                running=false;
            }
            if(tembel.getKonum().getX()*30==360&&tembel.getKonum().getY()*30==210){
                running=false;
            }
        }
    }

    private void drawAltin(Graphics g){

        if(System.currentTimeMillis()-bastimealtin>=delayaltin){
            if(!altinexists){
                k[0]=gargamel;
                k[1]=azman;
                k[2]=gozluklu;
                k[3]=tembel;
                altinexists=true;
                altin.Rastgele(Main.getEdges(),k);
                altinCreationTime=System.currentTimeMillis();
            }}

        g.setColor(Color.YELLOW);
        if(altinexists){
            if ( altin.konums[0]!= null&&altin.konums[1]!= null&&altin.konums[2]!= null&&altin.konums[3]!= null) {
                g.drawImage(coinimg,(altin.konums[0].getX()*30)-10,(altin.konums[0].getY()*30)-2, 50,35,this);
                g.drawImage(coinimg,(altin.konums[1].getX()*30)-10,(altin.konums[1].getY()*30)-2, 50,35,this);
                g.drawImage(coinimg,(altin.konums[2].getX()*30)-10,(altin.konums[2].getY()*30)-2, 50,35,this);
                g.drawImage(coinimg,(altin.konums[3].getX()*30)-10,(altin.konums[3].getY()*30)-2, 50,35,this);
                g.drawImage(coinimg,(altin.konums[4].getX()*30)-10,(altin.konums[4].getY()*30)-2, 50,35,this);

            }


        }
        altinExistanceTime=System.currentTimeMillis()-altinCreationTime;
        if(altinexists){
            if(altinExistanceTime>=5000){
                altinexists=false;
                delayaltin=rand.nextInt(10000);
                bastimealtin=System.currentTimeMillis();
            }}


    }

    private void drawMantar(Graphics g){
        if(System.currentTimeMillis()-bastimemantar>=delaymantar){
            if(!mantarexists){
                mantarexists=true;
                k[0]=gargamel;
                k[1]=azman;
                k[2]=gozluklu;
                k[3]=tembel;
                mantar.Rastgele(Main.getEdges(),k);
                mantarCreationTime=System.currentTimeMillis();
            }
        }
        g.setColor(Color.GREEN);
        if(mantarexists){
            if (mantar.konums[0] != null) {
                g.drawImage(mushroomimg, mantar.konums[0].getX()*30, mantar.konums[0].getY()*30,30,30,this);
            }
        }
        mantarExistanceTime=System.currentTimeMillis()-mantarCreationTime;
        if(mantarexists){
            if(mantarExistanceTime>=7000){
                mantarexists=false;
                delaymantar=rand.nextInt(20000);
                bastimemantar=System.currentTimeMillis();
            }
        }

    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

    @Override
    protected void processKeyEvent (KeyEvent ke){
        if(ke.getID()!=KeyEvent.KEY_PRESSED){
            return;
        }

        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            int wallgx, wallgy, walltx, wallty;
            wallgy = (gozluklu.getKonum().getY());
            wallgx = (gozluklu.getKonum().getX() + 1);
            wallty = (tembel.getKonum().getY());
            walltx = (tembel.getKonum().getX() + 1);
            if (running){
                if ((sirin) && (gozluklu.getKonum().getX() * 30) < (map[0].length - 1) * 30) {
                    if (map[wallgy][wallgx] != 0) {
                        tur++;

                        if (gozluklu.getKonum().getX() + 2 > 12) {
                            gozluklu.konum.setX(gozluklu.konum.getX() + 1);
                        } else {
                            gozluklu.ilerle(1, map);
                        }
                        if(altinexists){
                            for(int i=0;i<5;i++){
                                if (altin.konums[i] != null) {
                                    if ((gozluklu.getKonum().getX()-1==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()) {
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                    if((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()){
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                }

                            }
                        }
                        i = 0;
                        if(mantarexists){
                            if (mantar.konums[i] != null) {
                                if((gozluklu.getKonum().getX()-1==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                            }

                        }
                        if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                            gargamel.paint(Main.getEdges(), gozluklu);
                            gargamel.ilerle(Main.getEdges(), gozluklu);
                        }
                        if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                            azman.paint(Main.getEdges(), gozluklu);
                            azman.ilerle(Main.getEdges(), gozluklu, gargamel);
                        }

                    }
                } else {
                    if ((tembel.getKonum().getX() * 30) < ((map[0].length - 1) * 30)) {
                        if (map[wallty][walltx] != 0) {
                            tur++;
                            tembel.ilerle(1);
                            if(altinexists){
                                for(int i=0;i<5;i++){
                                    if (altin.konums[i] != null) {
                                        if((tembel.getKonum().getX()==altin.konums[i].getX())&&tembel.getKonum().getY()==altin.konums[i].getY()){
                                            tembel.setSkor(tembel.skorGoster()+5);
                                            altin.konums[i].setX(0);
                                            altin.konums[i].setY(0);
                                        }
                                    }

                                }
                            }
                            i = 0;
                            if(mantarexists){
                                if (mantar.konums[i] != null) {
                                    if((tembel.getKonum().getX()==mantar.konums[i].getX())&&tembel.getKonum().getY()==mantar.konums[i].getY()){
                                        tembel.setSkor(tembel.skorGoster()+50);
                                        mantar.konums[i].setX(0);
                                        mantar.konums[i].setY(0);
                                    }
                                }

                            }
                            if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                                gargamel.paint(Main.getEdges(), tembel);
                                gargamel.ilerle(Main.getEdges(), tembel);
                            }
                            if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                                azman.paint(Main.getEdges(), tembel);
                                azman.ilerle(Main.getEdges(), tembel, gargamel);
                            }
                        }
                    }
                }


            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
            int wallgx, wallgy, walltx, wallty;
            wallgy = (gozluklu.getKonum().getY());
            wallgx = (gozluklu.getKonum().getX() - 1);
            wallty = (tembel.getKonum().getY());
            walltx = (tembel.getKonum().getX() - 1);
            if (running){
                if (sirin && (gozluklu.getKonum().getX() * 30 > 0)) {
                    if (map[wallgy][wallgx] != 0) {
                        tur++;
                        gozluklu.ilerle(2, map);
                        if(altinexists){
                            for(int i=0;i<5;i++){
                                if (altin.konums[i] != null) {
                                    if ((gozluklu.getKonum().getX()+1==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()) {
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                    if((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()){
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                }

                            }
                        }
                        i = 0;
                        if(mantarexists){
                            if (mantar.konums[i] != null) {
                                if((gozluklu.getKonum().getX()+1==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                            }

                        }
                        if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                            gargamel.paint(Main.getEdges(), gozluklu);
                            gargamel.ilerle(Main.getEdges(), gozluklu);
                        }
                        if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                            azman.paint(Main.getEdges(), gozluklu);
                            azman.ilerle(Main.getEdges(), gozluklu, gargamel);
                        }
                    }
                } else {
                    if ((tembel.getKonum().getX() * 30) > 0) {
                        if (map[wallty][walltx] != 0) {
                            tur++;
                            tembel.ilerle(2);
                            if(altinexists){
                                for(int i=0;i<5;i++){
                                    if (altin.konums[i] != null) {
                                        if((tembel.getKonum().getX()==altin.konums[i].getX())&&tembel.getKonum().getY()==altin.konums[i].getY()){
                                            tembel.setSkor(tembel.skorGoster()+5);
                                            altin.konums[i].setX(0);
                                            altin.konums[i].setY(0);
                                        }
                                    }

                                }
                            }
                            i = 0;
                            if(mantarexists){
                                if (mantar.konums[i] != null) {
                                    if((tembel.getKonum().getX()==mantar.konums[i].getX())&&tembel.getKonum().getY()==mantar.konums[i].getY()){
                                        tembel.setSkor(tembel.skorGoster()+50);
                                        mantar.konums[i].setX(0);
                                        mantar.konums[i].setY(0);
                                    }
                                }

                            }
                            if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                                gargamel.paint(Main.getEdges(), tembel);
                                gargamel.ilerle(Main.getEdges(), tembel);
                            }
                            if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                                azman.paint(Main.getEdges(), tembel);
                                azman.ilerle(Main.getEdges(), tembel, gargamel);
                            }
                        }
                    }
                }
            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_UP) {
            int wallgx, wallgy, walltx, wallty;
            wallgy = (gozluklu.getKonum().getY() - 1);
            wallgx = (gozluklu.getKonum().getX());
            wallty = (tembel.getKonum().getY() - 1);
            walltx = (tembel.getKonum().getX());
            if (running){
                if (sirin && (gozluklu.getKonum().getY() * 30 > 0)) {
                    if (map[wallgy][wallgx] != 0) {
                        tur++;
                        gozluklu.ilerle(4, map);
                        if(altinexists){
                            for(int i=0;i<5;i++){
                                if (altin.konums[i] != null) {
                                    if ((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()+1==altin.konums[i].getY()) {
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                    if((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()){
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                }

                            }
                        }
                        i = 0;
                        if(mantarexists){
                            if (mantar.konums[i] != null) {
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()+1==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                            }

                        }
                        if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                            gargamel.paint(Main.getEdges(), gozluklu);
                            gargamel.ilerle(Main.getEdges(), gozluklu);
                        }
                        if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                            azman.paint(Main.getEdges(), gozluklu);
                            azman.ilerle(Main.getEdges(), gozluklu, gargamel);
                        }
                    }
                } else {
                    if ((tembel.getKonum().getY() * 30) > 0) {
                        if (map[wallty][walltx] != 0) {
                            tur++;
                            tembel.ilerle(4);
                            if(altinexists){
                                for(int i=0;i<5;i++){
                                    if (altin.konums[i] != null) {
                                        if((tembel.getKonum().getX()==altin.konums[i].getX())&&tembel.getKonum().getY()==altin.konums[i].getY()){
                                            tembel.setSkor(tembel.skorGoster()+5);
                                            altin.konums[i].setX(0);
                                            altin.konums[i].setY(0);
                                        }
                                    }

                                }
                            }
                            i = 0;
                            if(mantarexists){
                                if (mantar.konums[i] != null) {
                                    if((tembel.getKonum().getX()==mantar.konums[i].getX())&&tembel.getKonum().getY()==mantar.konums[i].getY()){
                                        tembel.setSkor(tembel.skorGoster()+50);
                                        mantar.konums[i].setX(0);
                                        mantar.konums[i].setY(0);
                                    }
                                }

                            }
                            if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                                gargamel.paint(Main.getEdges(), tembel);
                                gargamel.ilerle(Main.getEdges(), tembel);
                            }
                            if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                                azman.paint(Main.getEdges(), tembel);
                                azman.ilerle(Main.getEdges(), tembel, gargamel);
                            }
                        }
                    }
                }


            }
        }
        else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
            int wallgx, wallgy, walltx, wallty;
            wallgy = (gozluklu.getKonum().getY() + 1);
            wallgx = (gozluklu.getKonum().getX());
            wallty = (tembel.getKonum().getY() + 1);
            walltx = (tembel.getKonum().getX());
            if(running){
                if (sirin && ((gozluklu.getKonum().getY() * 30) < (map.length - 1) * 30)) {
                    if (map[wallgy][wallgx] != 0) {
                        tur++;
                        gozluklu.ilerle(3, map);
                        if(altinexists){
                            for(int i=0;i<5;i++){
                                if (altin.konums[i] != null) {
                                    if ((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()-1==altin.konums[i].getY()) {
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                    if((gozluklu.getKonum().getX()==altin.konums[i].getX())&&gozluklu.getKonum().getY()==altin.konums[i].getY()){
                                        gozluklu.setSkor(gozluklu.skorGoster()+5);
                                        altin.konums[i].setX(0);
                                        altin.konums[i].setY(0);
                                    }
                                }

                            }
                        }
                        i = 0;
                        if(mantarexists){
                            if (mantar.konums[i] != null) {
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()-1==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                                if((gozluklu.getKonum().getX()==mantar.konums[i].getX())&&gozluklu.getKonum().getY()==mantar.konums[i].getY()){
                                    gozluklu.setSkor(gozluklu.skorGoster()+50);
                                    mantar.konums[i].setX(0);
                                    mantar.konums[i].setY(0);
                                }
                            }

                        }
                        if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                            gargamel.paint(Main.getEdges(), gozluklu);
                            gargamel.ilerle(Main.getEdges(), gozluklu);
                        }
                        if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                            azman.paint(Main.getEdges(), gozluklu);
                            azman.ilerle(Main.getEdges(), gozluklu, gargamel);
                        }
                    }
                } else {
                    if ((tembel.getKonum().getY() * 30) < ((map.length - 1) * 30)) {
                        if (map[wallty][walltx] != 0) {
                            tur++;
                            tembel.ilerle(3);
                            if(altinexists){
                                for(int i=0;i<5;i++){
                                    if (altin.konums[i] != null) {
                                        if((tembel.getKonum().getX()==altin.konums[i].getX())&&tembel.getKonum().getY()==altin.konums[i].getY()){
                                            tembel.setSkor(tembel.skorGoster()+5);
                                            altin.konums[i].setX(0);
                                            altin.konums[i].setY(0);
                                        }
                                    }

                                }
                            }
                            i = 0;
                            if(mantarexists){
                                if (mantar.konums[i] != null) {
                                    if((tembel.getKonum().getX()==mantar.konums[i].getX())&&tembel.getKonum().getY()==mantar.konums[i].getY()){
                                        tembel.setSkor(tembel.skorGoster()+50);
                                        mantar.konums[i].setX(0);
                                        mantar.konums[i].setY(0);
                                    }
                                }

                            }
                            if (!(gargamel.konum.getX() == 0 && gargamel.konum.getY() == 0)) {
                                gargamel.paint(Main.getEdges(), tembel);
                                gargamel.ilerle(Main.getEdges(), tembel);
                            }
                            if (!(azman.konum.getX() == 0 && azman.konum.getY() == 0)) {
                                azman.paint(Main.getEdges(), tembel);
                                azman.ilerle(Main.getEdges(), tembel, gargamel);
                            }
                        }
                    }
                }

            }
        }
    }
}