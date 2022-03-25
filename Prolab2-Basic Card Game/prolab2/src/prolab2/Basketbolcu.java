package prolab2;
public class Basketbolcu extends Sporcu {//child class

    int ikilik = 0;
    int ucluk = 0;
    int serbestAtis = 0;

    public Basketbolcu() {
        super();
    }

    public Basketbolcu(String sporcuIsim, String sporcuTakim, int ikilik, int ucluk, int serbestAtis) {
        super(sporcuIsim, sporcuTakim);
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
    }

    public int getIkilik() {
        return ikilik;
    }

    public void setIkilik(int ikilik) {
        this.ikilik = ikilik;
    }

    public int getUcluk() {
        return ucluk;
    }

    public void setUcluk(int ucluk) {
        this.ucluk = ucluk;
    }

    public int getSerbestAtis() {
        return serbestAtis;
    }

    public void setSerbestAtis(int serbestAtis) {
        this.serbestAtis = serbestAtis;
    }

}
