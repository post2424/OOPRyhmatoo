import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.Scanner;

public class Mangija extends Ese{
    private byte elupunktid;

    public Mangija(int x, int y, char[][] ikoon, Renderdaja maailm, byte elupunktid) {
        super(x, y, ikoon, maailm);
        this.elupunktid = elupunktid;
    }

    public byte getElupunktid() {
        return elupunktid;
    }

    public void setElupunktid(byte elupunktid) {
        this.elupunktid = elupunktid;
    }

    public void uuendaKiirust(String[] klahvid) {
        if (Sisend.hoitudKlahvid.contains(klahvid[0])) {
            yKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains(klahvid[1])) {
            xKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains(klahvid[2])) {
            yKiirus = 1;
        }
        if (Sisend.hoitudKlahvid.contains(klahvid[3])){
            xKiirus = 1;
        }
    }
    public void tulista(String[] klahvid) {
        if (Sisend.hoitudKlahvid.contains(klahvid[4])) {
            Kuul kuul = new Kuul(x, y, new char[][] {{'-'}}, maailm, this);
            kuul.setxKiirus(xKiirus);
            kuul.setyKiirus(yKiirus);
            Mang.kuulid.add(kuul);
        }
    }
    public void uuenda(String[] klahvid){
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust(klahvid);
        uuendaPositsiooni();
    }

}
