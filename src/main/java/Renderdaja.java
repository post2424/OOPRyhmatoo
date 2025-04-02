import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Renderdaja {
    public double kuvasuhe = 9.0 / 16; // pikkus jagatud laius
    public int maailmaLaius;
    public int maailmaPikkus;
    public char[][] eelmineMaailm = null;
    public char[][] maailm;


    public Renderdaja(int maailmaLaius) {;
        System.out.print("\033[?25l"); //eemaldab kursori ekraanilt
        this.maailmaLaius = maailmaLaius;
        this.maailmaPikkus = (int) (maailmaLaius * kuvasuhe / 3);
        puhastaMaailm();
    }

    public static char[][] kopeeriMaatriks(char[][] maatriks) {
        char[][] tagasta = new char[maatriks[0].length][maatriks.length];
        for (int i = 0; i < maatriks.length; i++) tagasta[i] = Arrays.copyOf(maatriks[i], maatriks[i].length);
        return tagasta;
    }

    /**
     * teeb maailma suurusega tühja maatriksi
     *
     * @return maatriks
     */
    public char[][] genereeriMaailm() {
        char[][] väljasta = new char[maailmaPikkus][maailmaLaius];
        for (int i = 0; i < maailmaPikkus; i++) {
            Arrays.fill(väljasta[i], ' ');
        }
        return väljasta;
    }

    /**
     * lisab maailma eseme ikooni
     *
     * @param ese
     */
    public void lisaMaailma(Ese ese) {
        for (int i = 0; i < ese.ikoon.length; i++) {
            for (int j = 0; j < ese.ikoon[0].length; j++) {
                maailm[ese.y + j][ese.x + i] = ese.ikoon[j][i];
            }
        }
    }
    /**
     * asendab maailma tühja maatriksiga
     */
    public void puhastaMaailm() {
        maailm = genereeriMaailm();
    }

    /**
     * väljastab ekraanile maailma
     */
    public void renderiMaailm() {

        //if (eelmineMaailm.equals(maailm)) {
            StringBuilder temp = new StringBuilder();
            System.out.print(""); // teeb ekraani tühjaks
            for (int i = -1; i < maailmaPikkus + 1; i++) {
                for (int j = -1; j < maailmaLaius + 1; j++) {
                    if (i == -1) temp.append('#');
                    else if (i == maailmaPikkus) temp.append('#');
                    else {
                        if (j == -1) temp.append("#");
                        else if (j == maailmaLaius) temp.append('#');
                        else temp.append(maailm[i][j]);
                    }
                }
                temp.append("\n");
            }
            System.out.print("\033[H\033[2J" + temp); // paneb cursori ekraani algusesse
            //tühjendab ekraani
    }
}

