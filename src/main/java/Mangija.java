import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.Scanner;

public class Mangija extends Ese {
    private byte elupunktid;
    private String ülesKlahv, vasakuleKlahv, allaKlahv, paremaleKlahv, tulistaKlahv;

    public Mangija(int x, int y, char[][] ikoon, Renderdaja maailm, byte elupunktid) {
        super(x, y, ikoon, maailm);
        this.elupunktid = elupunktid;
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
    }

    /**
     * muudab mängija kiirust vastavalt sisendile
     */
    public void uuendaKiirust() {
        if (Sisend.hoitudKlahvid.contains(ülesKlahv)) {
            yKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains(vasakuleKlahv)) {
            xKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains(allaKlahv)) {
            yKiirus = 1;
        }
        if (Sisend.hoitudKlahvid.contains(paremaleKlahv)) {
            xKiirus = 1;
        }
    }

    /**
     * kui mängija hoiab all tulistamise klahvi, lisatakse maailma kuul
     */
    public void tulista() {
        if (Sisend.hoitudKlahvid.contains(tulistaKlahv)) {
            Kuul kuul = new Kuul(x, y, new char[][]{{'-'}}, maailm, this);
            kuul.setxKiirus(xKiirus);
            kuul.setyKiirus(yKiirus);
            Mang.kuulid.add(kuul);
        }
    }

    public void uuenda() {
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust();
        uuendaPositsiooni();
        tulista();
    }

}
