/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.minesweeper;

import java.util.ArrayList;
import minesweeper.minesweeper.gui.Nappula;
import minesweeper.minesweeper.logiikka.Maapala;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;
import minesweeper.minesweeper.logiikka.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PeliTest {

    private ArrayList<Nappula> nappulat;
    private MaapalaRekisteri maapalaRekisteri;
    private ArrayList<Maapala> maapalat;

    public PeliTest() {
        this.nappulat = new ArrayList<>();
        this.maapalaRekisteri = new MaapalaRekisteri(2, 0);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        maapalaRekisteri.luoMaapalat();
        maapalat = maapalaRekisteri.getMaapalat();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Nappula nappula = new Nappula(j, i);
                nappulat.add(nappula);
            }
        }
        for (Maapala maapala : maapalat) {
            for (Nappula nappula : nappulat) {
                if (maapala.getX() == nappula.getXkoordinaatti() && maapala.getY() == nappula.getYkoordinaatti()) {
                    nappula.asetaMaaArvo(maapala.getArvo());
                }
            }
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alussaHavioFalse() {
        Peli peli = new Peli(nappulat, 20);
        assertFalse(peli.getHavio());
    }

    @Test
    public void alussaVoittoFalse() {
        Peli peli = new Peli(nappulat, 20);
        assertFalse(peli.getVoitto());

    }

    @Test
    public void miinanAvattuaHavioTrue() {
        Peli peli = new Peli(nappulat, 20);
        peli.miinaAvattu();
        assertTrue(peli.getHavio());

    }

    @Test
    public void voittaessaVoittoTrue() {
        for (Nappula nappula : nappulat) {
            nappula.asetaMaaArvo(-1);
        }

        Peli peli = new Peli(nappulat, 20);
        peli.voittikoPelaaja();
        assertTrue(peli.getVoitto());

    }

    @ Test
    public void miinatVahenevatMerkatessa() {
        Peli peli = new Peli(nappulat, 20);
        peli.merkkaaMiina();
        assertTrue(peli.getMiinat() == 19);
    }

    @Test
    public void miinatVahenevatMerkatessa2() {
        Peli peli = new Peli(nappulat, 20);
        peli.merkkaaMiina();
        peli.merkkaaMiina();
        peli.merkkaaMiina();

        assertTrue(peli.getMiinat() == 17);
    }
    
    @Test
    public void miinatKasvavatKunMerkkausPoistetaan(){
        Peli peli = new Peli(nappulat,20);
        peli.merkkaaMiina();
        assertTrue(peli.getMiinat() == 19);
        peli.poistaMerkkaus();
        assertTrue(peli.getMiinat() == 20);
    }
    @Test
    public void miinatKasvavatKunMerkkausPoistetaan2(){
        Peli peli = new Peli(nappulat, 10);
        peli.merkkaaMiina();
        peli.merkkaaMiina();
        peli.merkkaaMiina();
        peli.poistaMerkkaus();
        
        assertTrue(peli.getMiinat() == 8);
    }
// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
// public void hello() {}
}
