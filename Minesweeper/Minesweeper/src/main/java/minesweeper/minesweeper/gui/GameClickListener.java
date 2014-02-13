package minesweeper.minesweeper.gui;

/*
 * Tämä luokka toimii käytännössä pelialustana.
 * Minesweeperissä ei sinänsä ole muuta toiminnallisuutta kuin
 * klikkausten kuuntelu ja tämä luokka hoitaa juuri sen.
 * Eli luokka kuuntelee hiiren painalluksen ja tarkastaa kutsujan arvon sekä koordinaatit
 * ja avaa (painaa JButtoneja) tilanteen vaatimalla tavalla
 * 
 * @author Mikael Parvamo
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;

public class GameClickListener implements MouseListener {

    private boolean voitto;
    private boolean miinaAvattu;
    private ArrayList<Nappula> viereisetNappulatNollalla;
    private ArrayList<Nappula> nappulat;

    public GameClickListener(ArrayList<Nappula> nappulat) {
        this.nappulat = nappulat;
        this.viereisetNappulatNollalla = new ArrayList<>();
        this.miinaAvattu = false;
        this.voitto = false;
    }

    /**
     * Tämä metodi vastaanottaa klikkauksen ja siirtää MouseEventin ja kutsuvan
     * komponentin enhancedMouseClicked- metodille.
     *
     * @param MouseEvent e (hiiren klikkaus)
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Nappula nappula = (Nappula) e.getComponent();
        enhancedMouseClicked(e, nappula);
    }

    /**
     * Tämä metodi saa parametrina "klikkaavan" komponentin ja itse klikkauksen.
     * Metodi tarkistaa, mikä hiiren näppäin aloitti kutsun ja tekee sen jälkeen
     * tarvittavat operaatiot, jotta peli etenisi odotetusti.
     *
     * Jos pelaaja on avannut miinan tai voittanut pelin, ei hiirtä enää
     * kuunnella.
     *
     * Jos kutsun teki hiiren vasen näppäin, tarkistaa metodi nappulan arvon.
     * Jos arvo on 0, kutsuu metodi avaaArvollaNolla- metodia. Jos arvo on
     * suurempi kuin 0 kutsutaan avaaArvollaNollaaSuurempi- metodia. Muussa
     * tapauksessa (arvon ollessa -1) kutsutaan metodia avaaMiina.
     *
     * Kutsun ollessa hiiren oikea näppäin, muutetaan nappulan tekstiä joko
     * tyhjäksi, huutomerkiksi(lipuksi) tai kysymysmerkiksi.
     */
    public void enhancedMouseClicked(MouseEvent e, Nappula nappula) {
        if (miinaAvattu) {
        } else if (voitto) {
        } else {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (nappula.getArvo() == 0) {
                    avaaArvollaNolla(nappula, e);
                } else if (nappula.getArvo() > 0) {
                    avaaArvollaNollaaSuurempi(nappula);
                } else {
                    avaaMiina(nappula);
                }
            } else if (e.getButton() == MouseEvent.BUTTON3 || e.getButton() == MouseEvent.BUTTON2) {
                if (nappula.getText().equals("")) {
                    nappula.setText("!");
                } else if (nappula.getText().equals("!")) {
                    nappula.setText("?");
                } else {
                    nappula.setText("");
                }
            }
        }
    }

    /**
     * Tämä metodi käy kaikki nappulat läpi ja tarkastaa, sijaitsevatko ne
     * kutsun tehneen komponentin vieressä kutsumalla metodia onkoVieressa. Jos
     * ne sijaitsevat, tarkastetaan niiden arvo. Arvon ollessa suurempi kuin 0,
     * "avataan" nappula. Jos arvo on 0, klikataan tätä nappulaa ja aloitetaan
     * rekursio tällä nappulalla.
     *
     * @param Nappula nappula(kutsun tehnyt nappula) ja MouseEvent e eli
     * "hiiritapahtuma"
     */
    public void avaaArvollaNolla(Nappula nappula, MouseEvent e) {
        for (Nappula nappula1 : nappulat) {
            if (onkoVieressa(nappula, nappula1) && !nappula1.onkoAvattu() && nappula1.getText().equals("")) {
                nappula1.avaa();
                if (nappula1.getArvo() > 0) {
                    nappula1.setText("" + nappula1.getArvo());
                }
                nappula1.setEnabled(false);
                enhancedMouseClicked(e, nappula1);
            }
        }
        voittikoPelaaja();
    }

    /**
     * Tämä metodi avaa parametrina saamansa komponentin (painaa nappulaa)
     * asettaa sille tekstiksi nappulan arvon ja kytkee nappulan pois päältä.
     *
     * @param nappula(klikattu nappula)
     */
    public void avaaArvollaNollaaSuurempi(Nappula nappula) {
        nappula.avaa();
        nappula.setText("" + nappula.getArvo());
        nappula.setEnabled(false);
        voittikoPelaaja();
    }

    /**
     * Tämä metodi tekee toimenpiteet, jos klikattu nappula oli miina. Metodi
     * asettaa klikatun miinan taustaväriksi punaisen ja tekee nappulasta
     * "klikatun." Tämän jälkeen metodi käy läpi kaikki muut nappulat ja jos
     * kyseessä on miina, "avataan" se ja asetetaan sen taustaväriksi harmaa.
     * Pelin boolean muuttuja miinaAvattu saa arvon true, eikä pelin
     * painalluksia enää kuunnella.
     *
     * @param nappula(kutsun tehnyt komponentti)
     */
    public void avaaMiina(Nappula nappula) {
        nappula.avaa();
        nappula.setText("*");
        nappula.setBackground(Color.red);
        nappula.setEnabled(false);
        this.miinaAvattu = true;

        for (Nappula nappula1 : nappulat) {
            if (nappula1.getArvo() == -1 && nappula1.onkoAvattu() == false) {
                nappula1.avaa();
                nappula1.setText("*");
                nappula1.setBackground(Color.GRAY);
                nappula1.setEnabled(false);
            }
        }
    }

    /**
     * Tämä metodi tarkastaa, onko pelaaja voittanut. Metodi tarkastaa onko
     * kaikkimuut nappulat kuin miinat avattu. Jos näin on, metodi asettaa
     * muuttujalle voitto arvon true, asettaa nappuloille Enabled arvon false
     * ja muuttaa nappuloiden taustavärin vihreäksi. Muuten ei tapahdu mitään.
     */
    public void voittikoPelaaja() {
        int suljettuja = 0;
        int miinoja = 0;

        for (Nappula nappula : nappulat) {
            if (!nappula.onkoAvattu()) {
                suljettuja++;
            }
            if (nappula.getArvo() == -1) {
                miinoja++;
            }
        }
        if (miinoja == suljettuja) {
            voitto = true;

            for (Nappula nappula : nappulat) {
                nappula.setEnabled(false);
                nappula.setBackground(Color.GREEN);
            }
        }
    }

    /**
     * Tämä metodi tarkistaa onko kutsun tehnyt nappula toisen nappulan
     * vieressä. Jos ne ovat vierekkäin, palautetaan true, muuten false.
     *
     * @param nappula1(klikkaava nappula), nappula2 (verrattava nappula)
     * @return true / false
     */
    public boolean onkoVieressa(Nappula nappula1, Nappula nappula2) {
        if (Math.abs(nappula1.getXkoordinaatti() - nappula2.getXkoordinaatti()) <= 1 && Math.abs(nappula1.getYkoordinaatti() - nappula2.getYkoordinaatti()) <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
