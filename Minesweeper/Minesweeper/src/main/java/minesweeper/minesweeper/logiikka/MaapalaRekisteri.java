package minesweeper.minesweeper.logiikka;

/**
 * Tämä luokka pitää kirjaa maapaloista ArrayListissä, asettaa maapaloille oikeat arvot
 * ja kutsuu miinojen alustajaa alustamaan miinat.
 * 
 * @author Mikael Parvamo
 */

import minesweeper.minesweeper.logiikka.MiinojenAlustaja;
import java.util.*;

public class MaapalaRekisteri {

    private int koko;
    private int miinoja;
    private ArrayList<Maapala> maapalat;
    private MiinojenAlustaja miinojenAlustaja;

    public MaapalaRekisteri(int koko, int miinoja) {
        this.koko = koko;
        this.miinoja = miinoja;
        this.maapalat = new ArrayList<>();
        this.miinojenAlustaja = new MiinojenAlustaja(koko, miinoja);
    }

    /**
     * Tämä metodi luo maapalat, jotka toimivat pelin alustana.
     * Metodi käy läpi pelilaudan sekä leveys, että korkeus suunnassa ja
     * luo jokaiseen koordinaattiin oman maapalan (Maapala(leveys,korkeus))
     */
    public void luoMaapalat() {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Maapala maapala = new Maapala(i, j);
                maapalat.add(maapala);
            }
        }
    }

    /**
     * Tämä metodi tulostaa jokaisen maapalan
     */
    public void tulostaMaapalat() {
        int k = 0;
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                System.out.print(maapalat.get(k));
                k++;
            }
            System.out.println("");
        }
    }

    /**
     *Tämä metodi alustaa miinat.
     * Metodi kutsuu miinojenAlustajan metodia alustaMiinat ja saa listan maapaloista
     * jotka muutetaan miinoiksi.
     * Metodi käy läpi kummatkin listat ja kutsuu tarvittaville maapaloille metodia
     * muutaMiinaksi()
     */
    public void alustaMiinat() {
        ArrayList<Maapala> miinat = miinojenAlustaja.alustaMiinat();

        for (Maapala miina : miinat) {
            for (Maapala maapala : maapalat) {
                if (maapala.getX() == miina.getX() && maapala.getY() == miina.getY()) {
                    maapala.muutaMiinaksi();
                }
            }
        }
    }

    /**
     * Tämä metodi kutsuu miinojenAlustaja:lta listaa miinoista
     * ja kutsuu jokaisen miinan koordinaatilla kasvataMaapalojenArvojaJosMiinanVieressa
     */
    public void asetaMaapalojenArvot() {
        ArrayList<Maapala> miinat = miinojenAlustaja.getMiinat();
        for (Maapala miina : miinat) {
            kasvataMaapalojenArvojaJosMiinanVieressa(miina.getX(), miina.getY());
        }

    }

    public ArrayList<Maapala> getMaapalat() {
        return this.maapalat;
    }

    /**
     * Tämä metodi kysyy jokaiselta maapalalta, onko se parametrina annetun koordinaatin
     * viressä. Jos on, niin maapala kutsuu metodia kasvataArvoaJosEiMiina.
     * 
     * @param miinan X ja Y koordinaatit
     */
    public void kasvataMaapalojenArvojaJosMiinanVieressa(int miinaX, int miinaY) {
        for (Maapala maapala : maapalat) {
            if (maapala.getX() == miinaX - 1 && maapala.getY() == miinaY) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX - 1 && maapala.getY() == miinaY - 1) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX && maapala.getY() == miinaY - 1) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX + 1 && maapala.getY() == miinaY - 1) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX + 1 && maapala.getY() == miinaY) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX + 1 && maapala.getY() == miinaY + 1) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX && maapala.getY() == miinaY + 1) {
                maapala.kasvataArvoaJosEiMiina();
            } else if (maapala.getX() == miinaX - 1 && maapala.getY() == miinaY + 1) {
                maapala.kasvataArvoaJosEiMiina();
            }
        }
    }

    public ArrayList<Maapala> getMiinat() {
        ArrayList<Maapala> miinat = this.miinojenAlustaja.getMiinat();
        return miinat;
    }
}
