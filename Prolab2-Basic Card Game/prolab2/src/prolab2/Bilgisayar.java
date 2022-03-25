package prolab2;
import java.util.Random;

public class Bilgisayar extends Oyuncu{
    public int basketboladim=4;
    public int futboladim=4;
    public Bilgisayar(int oyuncuID, String isim, int skor) {
        super(oyuncuID, isim, skor);
    }

    public Bilgisayar() {

    }

    @Override
    public int kartSec(int durum) {
        Random random=new Random();
        if(futboladim==0||basketboladim==0){
            return super.kartSec(0);
        }
        if(durum%2==0){
            int kartId=random.nextInt(futboladim);
            return super.kartSec(kartId);
        }
        else{
            int kartId=random.nextInt(basketboladim);
            return super.kartSec(kartId);
        }

    }
}