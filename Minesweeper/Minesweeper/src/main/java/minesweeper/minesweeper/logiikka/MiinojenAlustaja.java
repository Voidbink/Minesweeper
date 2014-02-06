package minesweeper.minesweeper.logiikka;

/**
 * Tämä luokka alustaa pelilaudan miinat.
 * Luokka arpoo x ja y koordinaatit ja muuttaa kyseiset koordinaatit
 * omaavan maapalan miinaksi eli asettaa maapalalle arvon -1
 * 
 * @author Mikael Parvamo
 */

import java.util.*;

public class MiinojenAlustaja {

    private Random random;
    private int koko;
    private int miinoja;
    private ArrayList<Maapala> miinat;

    MiinojenAlustaja(int koko, int miinoja) {
        this.miinat = new ArrayList<>();
        this.miinoja = miinoja;
        this.koko = koko;
        this.random = new Random();
    }

    /**
     * Tämä metodi alustaa pelin miinat.
     * Metodi on while loopissa, kunnes vaadittu määrä miinoja on arvottu.
     * 
     * Jos miinojen lista on tyhjä, lisätään miina suoraan listaan.
     * Jos arvottu miina on jo listassa, ei sitä lisätä, vaan arvotaan uusi.
     * Metodissa luodut maapalat eli miinat asetetaan ArrayListiin ja
     * lopuksi ArrayList palautetaan metodin kutsujalle.
     * 
     * @return ArrayList<Maapala>
     */
    public ArrayList<Maapala> alustaMiinat() {

        while (miinat.size() < miinoja) {
            int onkoMiinaListassa = 0;
            int randomX = random.nextInt(koko - 1);
            int randomY = random.nextInt(koko - 1);

            if (miinat.isEmpty()) {
                miinat.add(new Maapala(randomX, randomY));
            } else {
                for (Maapala miina : miinat) {
                    if (miina.getX() == randomX && miina.getY() == randomY) {
                        onkoMiinaListassa++;
                    }
                }
                if (onkoMiinaListassa == 0) {
                    miinat.add(new Maapala(randomX, randomY));
                }
            }
        }
        return miinat;
    }

    public ArrayList<Maapala> getMiinat() {
        return this.miinat;
    }
}
