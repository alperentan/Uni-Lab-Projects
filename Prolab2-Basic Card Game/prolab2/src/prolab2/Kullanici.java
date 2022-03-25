package prolab2;

public class Kullanici extends Oyuncu{

    public Kullanici(int oyuncuID, String isim, int skor) {

        super(oyuncuID, isim, skor);
    }

    public Kullanici() {

    }

    public Kullanici(int oyuncuID) {
        super(oyuncuID);
    }

    @Override
    public int kartSec(int kartId) {
        return super.kartSec(kartId);
    }
}
