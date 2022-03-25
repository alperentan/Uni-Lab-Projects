package com.company;

import java.util.ArrayList;

public class Dusman extends Karakter{
    private int dusmanID;
    private String dusmanIsim;
    private boolean dusmanTur=true;
    public static class Azman extends Dusman{
        public int bx;
        public int by;
        public Azman(){
            this.setIsim("Azman");
        }

        ArrayList<int[]> paint(ArrayList<Edge> edges,Oyuncu  oyuncu){
            Edge beginning = new Edge();
            for (var i:edges) {
                ArrayList<String> s=new ArrayList<String>();
                i.len=-1;
                i.path=s;
                if(i.c== konum.getX()&&i.r== konum.getY()){
                    beginning=i;
                    beginning.len=0;
                }
            }
            ArrayList<int[]> paintSquare=new ArrayList<int[]>();
            calculateDistance(beginning);
            for (var e:edges) {
                String a=e.c+","+e.r;
                e.path.add(a);
            }
            for (var i: edges) {
                if (oyuncu.konum.getX()==i.c&&oyuncu.konum.getY()==i.r) {
                    for (var j:i.path) {
                        int[] pKor=new int[2];
                        String[] t=j.split(",");
                        int new_intx=Integer.parseInt(t[0]);
                        int new_inty=Integer.parseInt(t[1]);
                        pKor[0]=new_intx;
                        pKor[1]=new_inty;
                        paintSquare.add(pKor);
                    }
                }
            }
            return paintSquare;

        }
        void ilerle(ArrayList<Edge> edges,Oyuncu  oyuncu,Dusman dusman){
            if (oyuncu.konum.getX() == konum.getX()&oyuncu.konum.getY() == konum.getY()) {
                this.konum.setX(bx);
                this.konum.setY(by);
                oyuncu.setSkor(oyuncu.skorGoster()-5);
                return;
            }
            for (var i: edges) {
                if(oyuncu.konum.getX()==i.c&&oyuncu.konum.getY()==i.r) {
                    String[] t=i.path.get(1).split(",");
                    int new_intx=Integer.parseInt(t[0]);
                    int new_inty=Integer.parseInt(t[1]);
                    if (new_inty == oyuncu.getKonum().getY()&&new_intx==oyuncu.getKonum().getX()) {
                        konum.setX(bx);
                        konum.setY(by);
                        oyuncu.setSkor(oyuncu.skorGoster()-5);
                        break;
                    }
                    else{
                        if(new_intx==dusman.getKonum().getX()&&new_inty==dusman.getKonum().getY())
                            break;
                        else {
                        konum.setX(new_intx);
                        konum.setY(new_inty);
                        }
                        break;
                    }
                }
            }
        }
    }
    public static class Gargamel extends Dusman{
        public int bx;
        public int by;
        public Gargamel(){
            this.setIsim("Gargamel");
        }
        ArrayList<int[]> paint(ArrayList<Edge> edges,Oyuncu  oyuncu){

            Edge beginning = new Edge();
            for (var i:edges) {
                ArrayList<String> s=new ArrayList<String>();
                i.path=s;
                i.len=-1;
                if(i.c== konum.getX()&&i.r== konum.getY()){
                    beginning=i;
                    beginning.len=0;
                }
            }
            calculateDistance(beginning);
            for (var e:edges) {
                String a=e.c+","+e.r;
                e.path.add(a);
            }
            ArrayList<int[]> paintSquare=new ArrayList<int[]>();
            for (var i: edges) {
                if (oyuncu.konum.getX()==i.c&&oyuncu.konum.getY()==i.r) {
                    for (var j:i.path) {
                        int[] pKor=new int[2];
                        String[] t=j.split(",");
                        int new_intx=Integer.parseInt(t[0]);
                        int new_inty=Integer.parseInt(t[1]);
                        pKor[0]=new_intx;
                        pKor[1]=new_inty;
                        paintSquare.add(pKor);
                    }
                }
            }
            return paintSquare;

        }
        void ilerle(ArrayList<Edge> edges,Oyuncu  oyuncu){
            if (oyuncu.konum.getX() == konum.getX()&oyuncu.konum.getY() == konum.getY()) {
                this.konum.setX(bx);
                this.konum.setY(by);
                oyuncu.setSkor(oyuncu.skorGoster()-5);
                return;
            }
            for (var i: edges) {
                if(oyuncu.konum.getX()==i.c&&oyuncu.konum.getY()==i.r) {
                    if(i.path.size()<3) {
                        this.konum.setX(bx);
                        this.konum.setY(by);
                        oyuncu.setSkor(oyuncu.skorGoster()-5);
                        break;
                    }
                    else {
                        String[] new_kor1 = i.path.get(1).split(",");
                        String[] new_kor2 = i.path.get(2).split(",");
                        int new_x1 = Integer.parseInt(new_kor1[0]);
                        int new_y1 = Integer.parseInt(new_kor1[1]);
                        int new_x2 = Integer.parseInt(new_kor2[0]);
                        int new_y2 = Integer.parseInt(new_kor2[1]);
                        if (konum.getX() == new_x2 || konum.getY() == new_y2) {
                            if (new_y2 == oyuncu.getKonum().getY() && new_x2 == oyuncu.getKonum().getX()) {
                                this.konum.setX(bx);
                                this.konum.setY(by);
                                oyuncu.setSkor(oyuncu.skorGoster() - 5);
                                break;
                            } else {
                                this.konum.setX(new_x2);
                                this.konum.setY(new_y2);
                                break;
                            }
                        } else {
                            if (new_y1 == oyuncu.getKonum().getY() && new_x1 == oyuncu.getKonum().getX()) {
                                this.konum.setX(bx);
                                this.konum.setY(by);
                                oyuncu.setSkor(oyuncu.skorGoster() - 5);
                                break;
                            } else {
                                this.konum.setX(new_x1);
                                this.konum.setY(new_y1);
                                break;
                            }
                        }
                    }

                }
            }
        }
    }
    @Override
    public Konum getKonum() {
        return konum;
    }

    @Override
    public void setKonum(Konum konum) {
        this.konum=konum;
    }

    @Override
    public int getID() {
        return dusmanID;
    }

    @Override
    public void setID(int ID) {
        dusmanID=ID;
    }

    @Override
    public String getIsim() {
        return dusmanIsim;
    }

    @Override
    public void setIsim(String isim) {
        dusmanIsim=isim;
    }

    @Override
    public boolean isTur() {
        return true;
    }

    @Override
    public void setTur(boolean tur) {
        dusmanTur=tur;
    }



}