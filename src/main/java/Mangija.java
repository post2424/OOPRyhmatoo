import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class Mangija extends Ese{
    private final byte elupunktid;

    public Mangija(int x, int y, char[][] ikoon, Renderdaja maailm, byte elupunktid) {
        super(x, y, ikoon, maailm);
        this.elupunktid = elupunktid;
    }

    public void uuendaKiirust() {
        if (Sisend.hoitudKlahvid.contains("W")) {
            yKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains("A")) {
            xKiirus = -1;
        }
        if (Sisend.hoitudKlahvid.contains("S")) {
            yKiirus = 1;
        }
        if (Sisend.hoitudKlahvid.contains("D")){
            xKiirus = 1;
        }
    }
    public void uuenda(){
        xKiirus = 0;
        yKiirus = 0;
        uuendaKiirust();
        uuendaPositsiooni();
    }

}
