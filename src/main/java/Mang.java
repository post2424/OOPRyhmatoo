import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import java.io.IOException;
import java.util.*;

public class Mang {
    public static HashSet<Kuul> eemaldadaKuulid = new HashSet<>();
    public static HashSet<Mangija> eemaldadaMangijad = new HashSet<>();
    public static HashSet<Mangija> mangijad = new HashSet<>();
    public static HashSet<Kuul> kuulid = new HashSet<>();
    public static final int FPS = 60;
    public static boolean toimusMuutus = true;
    private static void katkestaMäng() {
        System.out.println("\033[?47l"); // taasta ekraan
        System.out.println("\033[?25h"); // tee kursor nähtavaks
        System.out.println("M4ngu too l6petatud.");
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
        }
        ProcessBuilder sulgeTerminal = new ProcessBuilder("taskkill", "/F", "/IM", "cmd.exe");
        try {
            sulgeTerminal.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    public static void main(String[] args) {
        System.out.println("\033[?47h"); // salvesta ekraan
        System.out.print("\033[?25l"); //eemaldab kursori
        System.out.print("\033[2J"); // puhasta ekraan
        Sisend.initsialiseeriSisend();
        Renderdaja maailm = new Renderdaja(80);
        char[][] mängijaAIkoon = new char[][]{
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'}
        };
        char[][] mängijaBIkoon = new char[][]{
                {'B','B','B','B','B','B'},
                {'B','B','B','B','B','B'},
                {'B','B','B','B','B','B'},
                {'B','B','B','B','B','B'},
                {'B','B','B','B','B','B'}
        };
        Mangija mangijaA = new Mangija(0, maailm.maailmaPikkus - mängijaAIkoon.length,
                mängijaAIkoon,"\033[1;91m", maailm, (byte) 100);
        mangijaA.seadistaKlahvid("W", "A", "S", "D", "Q");
        Mangija mangijaB = new Mangija(maailm.maailmaLaius-mängijaBIkoon[0].length, maailm.maailmaPikkus-mängijaBIkoon.length,
                mängijaBIkoon, "\033[1;91m", maailm, (byte) 100);
        mangijaB.seadistaKlahvid("Up", "Left", "Down", "Right", "U");
        mangijad.add(mangijaA);
        mangijad.add(mangijaB);
        while (true) {
            if (mangijad.size() < 2){
                for (Mangija mangija : mangijad){
                    System.out.println("V6itja on " + mangija.ikoon[0][0]);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                katkestaMäng();
            }

            long praguneAeg = System.nanoTime();
            if (Sisend.hoitudKlahvid.contains("Escape")) katkestaMäng();
            maailm.puhastaMaailm();
            for (Mangija mangija : mangijad) {
                mangija.uuenda();
            }
            mangijad.removeAll(eemaldadaMangijad);
            Sisend.hoitudKlahvid.removeAll(Sisend.eemaldatavadKlahvid);
            Sisend.eemaldatavadKlahvid.clear();
            for (Kuul kuul: kuulid){
                kuul.uuenda();
            }
            kuulid.removeAll(eemaldadaKuulid);
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
            else{
                System.out.print("\033[1;31m");

            }
        }
    }
}

