public class Kuul extends Ese {
    Mangija omanik;
    public byte kuuliKiirus = 3;
    public Kuul(int x, int y, char[][] ikoon, Renderdaja maailm, Mangija omanik) {
        super(x, y, ikoon, maailm);
        this.omanik = omanik;
        määraSuund();
    }
    private void määraSuund(){
        if (omanik.viimaneKlahv == omanik.ülesKlahv) {
            this.yKiirus = (byte)-kuuliKiirus;
            ikoon = new char[][]{{'|'}};
        } else if (omanik.viimaneKlahv == omanik.vasakuleKlahv) {
            this.xKiirus = (byte)-kuuliKiirus;
            ikoon = new char[][]{{'-'}};
        } else if (omanik.viimaneKlahv == omanik.allaKlahv) {
            this.yKiirus = kuuliKiirus;
            ikoon = new char[][]{{'|'}};
        } else if (omanik.viimaneKlahv == omanik.paremaleKlahv) {
            this.xKiirus = kuuliKiirus;
            ikoon = new char[][]{{'-'}};
        }
    }
    /**
     * lisaks ülemklassis tehtule kontrollib, kas tabab ühtegi vastast, ning vajadusel lahutab elupunkte ning kustutab end maailmast
     */
    public void uuendaPositsiooni() {
        Mang.toimusMuutus = true;
        if (x > maailm.maailmaLaius || x < 0||
        y < maailm.maailmaPikkus || y< 0) Mang.kuulid.remove(this);
        else{
            x += xKiirus; y+= yKiirus;
            for (Mangija mangija : Mang.mangijad) {
                if (mangija != omanik) {
                    if (x >= mangija.x && x < mangija.x + mangija.ikoon[0].length &&
                            y >= mangija.y && y < mangija.y + mangija.ikoon.length) {
                        pihta(mangija);
                    }
                }
            }
        }
    }
    public void uuenda(){
        uuendaPositsiooni();
        maailm.lisaMaailma(this);
    }
    public void pihta(Mangija mangija){
        mangija.setElupunktid((byte) (mangija.getElupunktid()-(int)(Math.random()*10)-20));
        Mang.kuulid.remove(this);
    }
}
