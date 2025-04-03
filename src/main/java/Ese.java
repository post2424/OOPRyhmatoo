public abstract class Ese {
    int x, y;
    byte kiirus;
    byte xKiirus, yKiirus;
    char[][] ikoon;
    Renderdaja maailm;

    public Ese(int x, int y, char[][] ikoon, Renderdaja maailm) {
        this.x = x;
        this.y = y;
        this.xKiirus = 0;
        this.yKiirus = 0;
        this.ikoon = ikoon;
        this.maailm = maailm;
    }
    /**
     * uuendab mängija positsiooni vastavalt tema kiirusele ja maailma laiusele
     */
    public void uuendaPositsiooni() {
        int vanaX = x;
        int vanaY = y;
        this.x = Math.clamp(x + xKiirus, 0, maailm.maailmaLaius - this.ikoon[0].length);
        this.y = Math.clamp(y + yKiirus, 0, maailm.maailmaPikkus - this.ikoon.length);
        Mang.toimusMuutus = Mang.toimusMuutus || x != vanaX || y != vanaY;
    }
}
