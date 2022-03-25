package com.company;

import java.util.ArrayList;

public abstract class Karakter {
    public int ID;
    public String Isim;
    boolean tur;//t-> dusman f->oyuncu
    public Konum konum=new Konum();

    public Karakter() {
    }

    public Karakter(int ID, String isim, boolean tur, Konum konum) {
        this.ID = ID;
        Isim = isim;
        this.tur = tur;
        this.konum = konum;
    }

    public abstract Konum getKonum();

    public abstract void setKonum(Konum konum);

    public abstract int getID();

    public abstract void setID(int ID);

    public abstract String getIsim();

    public abstract void setIsim(String isim);

    public abstract boolean isTur();

    public abstract void setTur(boolean tur);

    public void calculateDistance(Edge begin){
        if (begin.neighbor[0] != null) {
            if (begin.neighbor[0].len == -1) {
                for (var i:begin.path) {
                    begin.neighbor[0].path.add(i);
                }
                begin.neighbor[0].path.add(begin.c+","+begin.r);
                begin.neighbor[0].len=begin.neighbor[0].path.size();
                calculateDistance(begin.neighbor[0]);
            }
            else if(begin.neighbor[0].len > (begin.len+1)){
                ArrayList<String> s=new ArrayList<String>();
                for (var i:begin.path) {
                    s.add(i);
                }
                s.add(begin.c+","+begin.r);
                begin.neighbor[0].path=s;
                begin.neighbor[0].len=begin.neighbor[0].path.size();
                calculateDistance(begin.neighbor[0]);
            }

        }
        if (begin.neighbor[1] != null) {
            if (begin.neighbor[1].len == -1) {
                for (var i:begin.path) {
                    begin.neighbor[1].path.add(i);
                }
                begin.neighbor[1].path.add(begin.c+","+begin.r);
                begin.neighbor[1].len=begin.neighbor[1].path.size();
                calculateDistance(begin.neighbor[1]);
            }
            else if(begin.neighbor[1].len > (begin.len+1)){
                ArrayList<String> s=new ArrayList<String>();
                for (var i:begin.path) {
                    s.add(i);
                }
                s.add(begin.c+","+begin.r);
                begin.neighbor[1].path=s;
                begin.neighbor[1].len=begin.neighbor[1].path.size();
                calculateDistance(begin.neighbor[1]);
            }
        }
        if (begin.neighbor[2] != null) {
            if (begin.neighbor[2].len == -1) {
                for (var i:begin.path) {
                    begin.neighbor[2].path.add(i);
                }
                begin.neighbor[2].path.add(begin.c+","+begin.r);
                begin.neighbor[2].len=begin.neighbor[2].path.size();
                calculateDistance(begin.neighbor[2]);
            }
            else if(begin.neighbor[2].len > (begin.len+1)){
                ArrayList<String> s=new ArrayList<String>();
                for (var i:begin.path) {
                    s.add(i);
                }
                s.add(begin.c+","+begin.r);
                begin.neighbor[2].path=s;
                begin.neighbor[2].len=begin.neighbor[2].path.size();
                calculateDistance(begin.neighbor[2]);
            }
        }
        if (begin.neighbor[3] != null) {
            if (begin.neighbor[3].len == -1) {
                for (var i:begin.path) {
                    begin.neighbor[3].path.add(i);
                }
                begin.neighbor[3].path.add(begin.c+","+begin.r);
                begin.neighbor[3].len=begin.neighbor[3].path.size();
                calculateDistance(begin.neighbor[3]);
            }
            else if(begin.neighbor[3].len > (begin.len+1)){
                ArrayList<String> s=new ArrayList<String>();
                for (var i:begin.path) {
                    s.add(i);
                }
                s.add(begin.c+","+begin.r);
                begin.neighbor[3].path=s;
                begin.neighbor[3].len=begin.neighbor[3].path.size();
                calculateDistance(begin.neighbor[3]);
            }
        }

    }
}
