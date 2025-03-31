public abstract class Ese {
    int x, y;
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

    public void uuendaPositsiooni(){
        this.x = Math.clamp(x+xKiirus,0, maailm.maailmaLaius-this.ikoon[0].length);
        this.y = Math.clamp(y+yKiirus,0,maailm.maailmaPikkus-this.ikoon.length);

    }
}
