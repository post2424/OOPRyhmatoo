import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.Scanner;

public class Mangija extends Ese{
    private final byte elupunktid;

    public Mangija(int x, int y, char[][] ikoon, Renderdaja maailm, byte elupunktid) {
        super(x, y, ikoon, maailm);
        this.elupunktid = elupunktid;
    }
    public String[] määraKlahvid() {
        String[] klahvid = new String[4];
        String[] suunad = {"üles", "vasakule", "alla", "paremale"};
        for (int i = 0; i < 4; i++) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Sisesta klahv, mille abil mängija liigub "+suunad[i]);
            String klahv = scan.nextLine();
            klahvid[i] = klahv.toUpperCase();
        }
        return klahvid;
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
    public void uuenda(String[] klahvid){
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust(klahvid);
        uuendaPositsiooni();
    }

}
