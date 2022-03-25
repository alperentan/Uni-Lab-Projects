package prolab2;
import java.util.ArrayList;

public class Oyuncu {
    private int oyuncuID;
    private String isim;
    private int skor=0;
    public ArrayList<Futbolcu> fList=new ArrayList<Futbolcu>();
    public ArrayList<Basketbolcu> bList=new ArrayList<Basketbolcu>();

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public Oyuncu(int oyuncuID, String isim, int skor) {
        this.oyuncuID = oyuncuID;
        this.isim = isim;
        this.skor = skor;
    }
    public Oyuncu() {
    }

    public Oyuncu(int oyuncuID, String isim) {
        this.oyuncuID = oyuncuID;
        this.isim = isim;
    }

    public Oyuncu(int oyuncuID) {

        this.oyuncuID = oyuncuID;
    }

    public void skorGoster(){
        System.out.println(oyuncuID+". oyuncunun ("+isim+") skoru:"+skor);
    }
    public int kartSec(int kartId){

        return kartId;
    }

}
