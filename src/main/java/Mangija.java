import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class Mangija extends Ese{
    private final byte elupunktid;

    public Mangija(int x, int y,byte elupunktid, char[][] ikoon) {
        this.elupunktid = elupunktid;
        this.x = x;
        this.y = y;
        this.xKiirus = 0;
        this.yKiirus = 0;
        this.ikoon = ikoon;
    }
    public void uuendaKiirust() {
        if (Sisend.hoitudKlahvid.contains("W")) {
            yKiirus = -1;
            //System.out.println(yKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("A")) {
            xKiirus = -1;
            //System.out.println(xKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("S")) {
            yKiirus = 1;
            //System.out.println(yKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("D")){
            xKiirus = 1;
            //System.out.println(xKiirus);
        }
    }
    public void uuenda(){
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust();
        uuendaPositsiooni();
    }

}
