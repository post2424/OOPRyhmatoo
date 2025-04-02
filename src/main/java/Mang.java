import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.ArrayList;
import java.util.Iterator;

public class Mang {
    public static ArrayList<Mangija> mangijad = new ArrayList<>();
    public static ArrayList<Kuul> kuulid = new ArrayList<>();
    private static void katkestaMäng(){
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
                {'A','A','A'},
                {'A','A','A'},
                {'A','A','A'}
        };
        char[][] mängijaBIkoon = new char[][]{
                {'B','B','B'},
                {'B','B','B'},
                {'B','B','B'}
        };
        Mangija mangijaA = new Mangija(0, maailm.maailmaPikkus-mängijaAIkoon.length, mängijaAIkoon, maailm, (byte)100);
        Mangija mangijaB = new Mangija(maailm.maailmaLaius-mängijaBIkoon[0].length, maailm.maailmaPikkus-mängijaBIkoon.length, mängijaBIkoon, maailm, (byte)100);
        mangijad.add(mangijaA);
        mangijad.add(mangijaB);
        Iterator iteraator;
        while (true) {
            iteraator = Sisend.hoitudKlahvid.iterator();
            if (iteraator.hasNext()) {
                if (Sisend.hoitudKlahvid.contains("Escape")) {
                    katkestaMäng();
                }
                mangijaA.uuenda(new String[]{"W", "A", "S", "D", "Q"});
                mangijaB.uuenda(new String[]{"I", "J", "K", "L", "U"});
                Sisend.hoitudKlahvid.removeAll(Sisend.eemaldatavadKlahvid);
                Sisend.eemaldatavadKlahvid.clear();
            }
            maailm.lisaMaailma(mangijaA);
            maailm.lisaMaailma(mangijaB);
            for (Kuul kuul : kuulid) {
                maailm.lisaMaailma(kuul);
            }
            maailm.renderiMaailm();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
