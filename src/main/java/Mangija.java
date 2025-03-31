import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public class Mangija implements Ese{
    private final byte elupunktid;
    private int x,y;
    private byte xKiirus;
    private byte yKiirus;

    public Mangija(int x, int y,byte elupunktid) {
        this.elupunktid = elupunktid;
        this.x = x;
        this.y = y;
        this.xKiirus = 0;
        this.yKiirus = 0;
    }
    public void uuendaPositsiooni(){
        x += xKiirus; y += yKiirus;
    }

    public void uuendaKiirust() {
        if (Sisend.hoitudKlahvid.contains("W")) {
            yKiirus -= 1;
            System.out.println(yKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("A")) {
            xKiirus -= 1;
            System.out.println(xKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("S")) {
            yKiirus += 1;
            System.out.println(xKiirus);
        }
        if (Sisend.hoitudKlahvid.contains("D")){
            xKiirus += 1;
            System.out.println(yKiirus);
        }
    }

}
