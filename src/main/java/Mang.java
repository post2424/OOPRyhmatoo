import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.util.Iterator;

public class Mang {
    public static boolean töötab = true;
    private static void katkestaMäng(){
        Mang.töötab = false;
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Võetud https://github.com/kwhat/jnativehook/blob/2.2/doc/Keyboard.md
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new Sisend());
        //Võetud koodi lõpp
        Mangija MangijaA = new Mangija(0, 0, (byte) 100);
        Iterator iteraator;
        while (töötab) {
            iteraator = Sisend.hoitudKlahvid.iterator();
            while (iteraator.hasNext()) {
                if (Sisend.hoitudKlahvid.contains("Escape")) {
                    katkestaMäng();
                }
                System.out.println("Main: " + iteraator.next());
                MangijaA.uuendaKiirust();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
