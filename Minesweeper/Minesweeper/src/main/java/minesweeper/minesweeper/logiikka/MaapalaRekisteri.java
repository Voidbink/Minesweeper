package minesweeper.minesweeper.logiikka;

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

    public void luoMaapalat() {
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                Maapala maapala = new Maapala(i, j);
                maapalat.add(maapala);
            }
        }
    }

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

    public void asetaMaapalojenArvot() {
        ArrayList<Maapala> miinat = miinojenAlustaja.getMiinat();
        for (Maapala miina : miinat) {
            kasvataMaapalojenArvojaJosMiinanVieressa(miina.getX(), miina.getY());
        }

    }
    public ArrayList<Maapala> getMaapalat(){
        return this.maapalat;
    }

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
    public ArrayList<Maapala> getMiinat(){
        ArrayList<Maapala> miinat = this.miinojenAlustaja.getMiinat();
        return miinat;
    }
}
