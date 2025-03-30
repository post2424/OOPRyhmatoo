public class Mangija implements Ese{
    private byte elupunktid;
    private int[] positsioon;
    private byte xKiirus;
    private byte yKiirus;

    public Mangija(byte elupunktid, int[] positsioon) {
        this.elupunktid = elupunktid;
        this.positsioon = positsioon;
        this.xKiirus = 0;
        this.yKiirus = 0;
    }

    public byte getxKiirus() {
        return xKiirus;
    }

    public void setxKiirus(byte kiirus) {
        this.xKiirus = kiirus;
    }

    public byte getyKiirus() {
        return yKiirus;
    }

    public void setyKiirus(byte yKiirus) {
        this.yKiirus = yKiirus;
    }
    public void liigu() {
        if (Input.key == 'd') {
            xKiirus = 1;
            System.out.println(xKiirus);
        } else if (Input.key == 'a') {
            xKiirus = -1;
            System.out.println(xKiirus);
        } else if (Input.key == 'w') {
            yKiirus = -1;
            System.out.println(yKiirus);
        } else if (Input.key == 's'){
            yKiirus = 1;
            System.out.println(yKiirus);
        }
    }
}
