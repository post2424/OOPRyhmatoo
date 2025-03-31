import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.Iterator;

public class Mang {
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
                {'A','A'},
                {'A','A'}
        };
        Mangija mangijaA = new Mangija(0, maailm.maailmaPikkus- mängijaAIkoon.length, (byte)100, mängijaAIkoon);
        Iterator iteraator;
        while (true) {
            iteraator = Sisend.hoitudKlahvid.iterator();
            if (iteraator.hasNext()) {
                if (Sisend.hoitudKlahvid.contains("Escape")) {
                    katkestaMäng();
                }
                mangijaA.uuenda();
            }
            maailm.lisaMaailma(mangijaA);
            maailm.renderiMaailm();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
