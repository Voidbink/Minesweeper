package minesweeper.minesweeper.gui;

/**
 * Tämä luokka luo pelin graafiset nappulat, asettaa niille arvot ja koordinaatit.
 * Luokka perii JButtonin.
 * 
 * @author Mikael Parvamo
 */

import javax.swing.JButton;

public class Nappula extends JButton {

    private int x;
    private int y;
    private int arvo;
    private boolean avattu;

    public Nappula(int x, int y) {
        this.x = x;
        this.y = y;
        this.avattu = false;
    }

    public int getXkoordinaatti() {
        return this.x;

    }

    public int getYkoordinaatti() {
        return this.y;
    }

    public void asetaMaaArvo(int arvo) {
        this.arvo = arvo;
    }

    public int getArvo() {
        return this.arvo;
    }
    
    /**
     * Tämä metodi "avaa" nappulan eli asettaa sille arvon true this.avattu:lle.
     * 
     * @return true
     */
    public void avaa() {
        this.avattu = true;
    }
    
    public boolean onkoAvattu() {
        return this.avattu;
    }
    
    
    /**
     * Tämä metodi tarkistaa onko kutsun tehnyt nappula toisen nappulan
     * vieressä. Jos ne ovat vierekkäin, palautetaan true, muuten false.
     *
     * @param nappula1(klikkaava nappula), nappula2 (verrattava nappula)
     * @return true / false
     */
    public boolean onkoVieressa(Nappula nappula1) {
        if (Math.abs(this.x - nappula1.getXkoordinaatti()) <= 1 && Math.abs(this.y - nappula1.getYkoordinaatti()) <= 1) {
            return true;
        }
        return false;
    }
}
