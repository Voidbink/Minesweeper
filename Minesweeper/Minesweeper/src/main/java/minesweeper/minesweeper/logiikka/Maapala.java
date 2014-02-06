package minesweeper.minesweeper.logiikka;

/**
 * Tämä luokka edustaa maapaloja, jotka luovat pelialustan.
 * Maapalalle voi asettaa arvon, hakea arvon, tai hakea maapalan koordinaatit.
 *
 * @author Mikael Parvamo
 */
public class Maapala {

    private int x;
    private int y;
    private int arvo;

    public Maapala(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getArvo() {
        return this.arvo;
    }

    @Override
    public String toString() {
        if (this.arvo == -1) {
            return " M ";
        }
        return " " + this.arvo + " ";
    }

    public void kasvataArvoa() {
        this.arvo++;
    }

    /**
     * Tämä metodi muuttaa arvon -1:ksi eli "miinaksi"
     */
    public void muutaMiinaksi() {
        this.arvo = -1;
    }

    /**
     * Tämä metodi palauttaa arvon true, jos maapala on miina(arvo = -1) ja
     * muuten false
     *
     * @return
     */
    public boolean onkoMiina() {
        if (this.arvo == -1) {
            return true;
        }
        return false;
    }

    /**
     * Jos maapala ei ole miina, kasvatetaan maapalan arvoa yhdellä. Kutsu
     * metodiin tulee vain maapaloille, jotka ovat miinan vieressä.
     */
    public void kasvataArvoaJosEiMiina() {
        if (!onkoMiina()) {
            this.kasvataArvoa();
        } else {
        }
    }

    /**
     * Tämä metodi tarkastaa, onko maapalan arvo 0 (maapalan vieressä ei ole
     * miinaa). Jos näin on, palautetaan true ja muuten false.
     *
     * @return true / false
     */
    public boolean onkoArvoNolla() {
        if (this.arvo == 0) {
            return true;
        } else {
            return false;
        }
    }
}
