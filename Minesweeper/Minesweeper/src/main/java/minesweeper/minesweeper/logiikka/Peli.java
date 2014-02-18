package minesweeper.minesweeper.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import minesweeper.minesweeper.gui.Nappula;

/**
 *
 * @author User
 */
public class Peli {

    private boolean havio;
    private boolean voitto;
    private boolean miinaAvattu;
    private ArrayList<Nappula> nappulat;

    public Peli(ArrayList<Nappula> nappulat) {
        this.havio = false;
        this.voitto = false;
        this.miinaAvattu = false;
        this.nappulat = nappulat;
    }
    /**
     * Tämä metodi tarkastaa, onko pelaaja voittanut. Metodi tarkastaa onko
     * kaikkimuut nappulat kuin miinat avattu. Jos näin on, metodi asettaa
     * muuttujalle voitto arvon true, asettaa nappuloille Enabled arvon false ja
     * muuttaa nappuloiden taustavärin vihreäksi. Muuten ei tapahdu mitään.
     */
    public void voittikoPelaaja() {
        int suljettuja = 0;
        int miinat = 0;

        for (Nappula nappula : nappulat) {
            if (!nappula.onkoAvattu()) {
                suljettuja++;
            }
            if (nappula.getArvo() == -1) {
                miinat++;
            }
        }
        if (miinat == suljettuja) {
            voitto = true;

            for (Nappula nappula : nappulat) {
                nappula.setEnabled(false);
                nappula.setBackground(Color.GREEN);
            }
        }
    }

    public void miinaAvattu() {
        this.havio = true;
    }

    public boolean getVoitto() {
        return this.voitto;
    }
    
    public boolean getHavio(){
        return this.havio;
    }
}
