package com.company;

public class Oyuncu extends Karakter {
    private int skor=20;
    private int oyuncuID;
    private String oyuncuIsim;
    boolean oyuncuTur;
    public static class Gozluklu extends Oyuncu{
        public Gozluklu() {
            konum.setX(6);
            konum.setY(5);
        }
        /*
        ilerleyeceği yönü ve harita matrisini parametre olarak alır
        Oyuncunun konumunu günceller.-- 1:-> | 2:<- | 3:aşağı | 4:yukarı
        Harita dısı olan kısım için arayüz kısmıda düzenlenecek
         */
        void ilerle(int yon,int[][] map){
            if(yon==1){
                if (map[konum.getY()][konum.getX()+2]==1) {
                    this.konum.setX(this.konum.getX()+2);
                }
                else {
                    konum.setX(konum.getX() + 1);
                }
            }
            if(yon==2){
                if (map[konum.getY()][konum.getX()-2]==1) {
                    this.konum.setX(this.konum.getX()-2);
                }
                else {
                    konum.setX(konum.getX() -1);
                }
            }
            if(yon==3){
                if (map[konum.getY()+2][konum.getX()]==1) {
                    this.konum.setY(this.konum.getY()+2);
                }
                else {
                    konum.setY(konum.getY() + 1);
                }
            }
            if(yon==4){
                if (map[konum.getY()-2][konum.getX()]==1) {
                    this.konum.setY(this.konum.getY()-2);
                }
                else {
                    konum.setY(konum.getY() - 1);
                }
            }
        }
    }

    public static class Tembel extends Oyuncu{
        public Tembel() {
            konum.setX(6);
            konum.setY(5);
        }
        /*
        ilerleyeceği yönü ve harita matrisini parametre olarak alır
        Oyuncunun konumunu günceller.-- 1:-> | 2:<- | 3:aşağı | 4:yukarı --
        Harita dısı olan kısım için arayüz kısmıda düzenlenecek
         */
        void ilerle(int yon){
            if(yon==1){
                konum.setX(konum.getX()+1);
            }
            if(yon==2){
                konum.setX(konum.getX()-1);
            }
            if(yon==3){
                konum.setY(konum.getY()+1);
            }
            if(yon==4){
                konum.setY(konum.getY()-1);
            }
        }
    }
    static class Puan extends Oyuncu{
        @Override
        public int skorGoster(Oyuncu oyuncu) {
            return oyuncu.skor;
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
        return oyuncuID;
    }

    @Override
    public void setID(int ID) {
        this.oyuncuID=ID;
    }

    @Override
    public String getIsim() {
        return oyuncuIsim;
    }

    @Override
    public void setIsim(String isim) {
        this.oyuncuIsim=isim;
    }

    @Override
    public boolean isTur() {
        return oyuncuTur;
    }

    @Override
    public void setTur(boolean tur) {
        this.oyuncuTur=tur;
    }

    public int skorGoster() {
        return skor;
    }
    public int skorGoster(Oyuncu oyuncu) {
        return oyuncu.skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
}