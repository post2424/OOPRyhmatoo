import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.Iterator;

public class Mang {
    public static ArrayList<Mangija> mangijad = new ArrayList<>();
    public static ArrayList<Kuul> kuulid = new ArrayList<>();
    public static final int FPS = 60;

    private static void katkestaMäng() {
        System.out.println("M4ngu too l6petatud.");
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        Sisend.initsialiseeriSisend();
        Renderdaja maailm = new Renderdaja(50);
        char[][] mängijaAIkoon = new char[][]{
                {'A', 'A', 'A'},
                {'A', 'A', 'A'},
                {'A', 'A', 'A'}
        };
        char[][] mängijaBIkoon = new char[][]{
                {'B', 'B', 'B'},
                {'B', 'B', 'B'},
                {'B', 'B', 'B'}
        };
        Mangija mangijaA = new Mangija(0, maailm.maailmaPikkus - mängijaAIkoon.length, mängijaAIkoon, maailm, (byte) 100);
        mangijaA.seadistaKlahvid("W", "A", "S", "D", "Q");
        Mangija mangijaB = new Mangija(maailm.maailmaLaius - mängijaBIkoon[0].length, maailm.maailmaPikkus - mängijaBIkoon.length, mängijaBIkoon, maailm, (byte) 100);
        mangijaB.seadistaKlahvid("Up", "Left", "Down", "Right", "U");
        mangijad.add(mangijaA);
        mangijad.add(mangijaB);
        while (true) {
            long praguneAeg = System.nanoTime();

            if (Sisend.hoitudKlahvid.contains("Escape")) katkestaMäng();
            maailm.puhastaMaailm();
            for (Mangija mangija : mangijad) {
                mangija.uuenda();
                maailm.lisaMaailma(mangija);
            }
            Sisend.hoitudKlahvid.removeAll(Sisend.eemaldatavadKlahvid);
            Sisend.eemaldatavadKlahvid.clear();
            for (Kuul kuul : kuulid) {
                maailm.lisaMaailma(kuul);
            }
            maailm.renderiMaailm();
            long viimaneAeg = praguneAeg;
            long mõõdunud = (praguneAeg - viimaneAeg) / 1000000;
            long magamisAeg = 1000 / FPS - mõõdunud;
            if (magamisAeg > 0) {

                try {
                    Thread.sleep(magamisAeg);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
