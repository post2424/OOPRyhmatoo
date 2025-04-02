public class Kuul extends Ese {
    Mangija omanik;

    public Kuul(int x, int y, char[][] ikoon, Renderdaja maailm, Mangija omanik) {
        super(x, y, ikoon, maailm);
        this.omanik = omanik;
    }

    /**
     * lisaks ülemklassis tehtule kontrollib, kas tabab ühtegi vastast, ning vajadusel lahutab elupunkte ning kustutab end maailmast
     */
    public void uuendaPositsiooni() {
        super.uuendaPositsiooni();
        for (Mangija vastane : Mang.mangijad) {
            if (vastane != omanik) {
                if (x == vastane.getX() || x == vastane.getX() + 1 || x == vastane.getX() + 2) {
                    if (y == vastane.getY() || y == vastane.getY() + 1 || y == vastane.getY() + 2) {
                        vastane.setElupunktid((byte) (vastane.getElupunktid() - 25));
                    }
                }
            }
        }
    }
}
