import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.Scanner;

public class Mangija extends Ese {
    private byte elupunktid;
    public String värv = "\033[31",viimaneKlahv = "";
    private int viimatiTulistas = 0;
    public String ülesKlahv,vasakuleKlahv,allaKlahv,paremaleKlahv,tulistaKlahv;
    public Mangija(int x, int y, char[][] ikoon, String värv, Renderdaja maailm, byte elupunktid) {
        super(x, y, ikoon, maailm);
        this.elupunktid = elupunktid;
        this.värv = värv;
    }


    /**
     * meetod, mille abil seadistatakse peaklassis mängija kaustatavd klahvid
     *
     * @param ülesKlahv
     * @param vasakuleKlahv
     * @param allaKlahv
     * @param paremaleKlahv
     * @param tulistaKlahv
     */
    public void seadistaKlahvid(String ülesKlahv, String vasakuleKlahv, String allaKlahv, String paremaleKlahv, String tulistaKlahv) {
        this.ülesKlahv = ülesKlahv;
        this.vasakuleKlahv = vasakuleKlahv;
        this.allaKlahv = allaKlahv;
        this.paremaleKlahv = paremaleKlahv;
        this.tulistaKlahv = tulistaKlahv;
    }

    public byte getElupunktid() {
        return elupunktid;
    }

    public void setElupunktid(byte elupunktid) {
        this.elupunktid = elupunktid;
        if (elupunktid < 0)Mang.eemaldadaMangijad.add(this);
    }

    /**
     * muudab mängija kiirust vastavalt sisendile
     */
    public void uuendaKiirust() {
        if (Sisend.hoitudKlahvid.contains(ülesKlahv)) {
            yKiirus = -1;
            viimaneKlahv = ülesKlahv;
        }
        if (Sisend.hoitudKlahvid.contains(vasakuleKlahv)) {
            xKiirus = -1;
            viimaneKlahv = vasakuleKlahv;
        }
        if (Sisend.hoitudKlahvid.contains(allaKlahv)) {
            yKiirus = 1;
            viimaneKlahv = allaKlahv;
        }
        if (Sisend.hoitudKlahvid.contains(paremaleKlahv)) {
            xKiirus = 1;
            viimaneKlahv = paremaleKlahv;
        }
    }

    /**
     * kui mängija hoiab all tulistamise klahvi, lisatakse maailma kuul
     */
    public void tulista() {
        if (viimatiTulistas == 0){
            if (Sisend.hoitudKlahvid.contains(tulistaKlahv)) {
                viimatiTulistas = 50;
                Mang.kuulid.add(new Kuul(x, y, new char[][]{{'-'}}, maailm, this));
            }
        }
        else {viimatiTulistas--;}
    }

    public void uuenda() {
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust();
        uuendaPositsiooni();
        maailm.lisaMaailma(this);
        tulista();
    }

}
