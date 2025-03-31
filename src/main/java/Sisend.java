//Kood on võetud siit: https://github.com/kwhat/jnativehook/blob/2.2/doc/Keyboard.md
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import java.util.HashSet;
import java.util.Set;

public class Sisend implements NativeKeyListener {
    public static void initsialiseeriSisend(){
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new Sisend());
    }
    public static Set<String> hoitudKlahvid = new HashSet<>();
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        //System.out.println("Key Pressed in input: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        hoitudKlahvid.add(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        hoitudKlahvid.remove(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
}