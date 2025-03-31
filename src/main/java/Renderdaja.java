import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.util.Arrays;

public class Renderdaja {
    public double kuvasuhe = 9.0/16; // pikkus jagatud laius
    public int maailmaLaius;
    public int maailmaPikkus;
    //public char[][] tühiMaailm;
    public char[][] maailm;



    public Renderdaja(int maailmaLaius) {
        this.maailmaLaius = maailmaLaius;
        this.maailmaPikkus = (int)(maailmaLaius*kuvasuhe/3);

        maailm = genereeriMaailm();
    }
    public static char[][] kopeeriMaatriks(char[][] maatriks){
        char[][] tagasta = new char[maatriks[0].length][maatriks.length];
        for (int i = 0; i < maatriks.length; i++) tagasta[i] = Arrays.copyOf(maatriks[i], maatriks[i].length);
        return tagasta;
    }

    public char[][] genereeriMaailm() {
        char[][] väljasta = new char[maailmaPikkus][maailmaLaius];
        for (int i = 0; i < maailmaPikkus; i++) {
            Arrays.fill(väljasta[i], ' ');
        }
        return väljasta;
    }
    public void lisaMaailma(Ese ese){
        maailm = genereeriMaailm();
        for (int i = 0; i < ese.ikoon.length; i++) {
            for (int j = 0; j < ese.ikoon[0].length; j++) {
                maailm[ese.y+j][ese.x+i] = ese.ikoon[j][i];
            }
        }
    }
    public void renderiMaailm(){
        for (int i = -1; i < maailmaPikkus+1; i++) {
                for (int j = -1; j < maailmaLaius+1; j++) {
                    if (i == -1) System.out.print('#');
                    else if (i==maailmaPikkus) System.out.print('#');
                    else {
                        if (j==-1) System.out.print("#");
                        else if (j==maailmaLaius) System.out.print('#');
                        else System.out.print(maailm[i][j]);
                }
            }
            System.out.println();
        }
    }
}

