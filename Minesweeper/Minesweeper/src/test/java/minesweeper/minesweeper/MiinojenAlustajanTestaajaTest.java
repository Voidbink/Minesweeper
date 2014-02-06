/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.minesweeper;

import java.util.ArrayList;
import minesweeper.minesweeper.logiikka.Maapala;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;
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
public class MiinojenAlustajanTestaajaTest {
    
    public MiinojenAlustajanTestaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void oikeaMaaraMiinoja() {
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 10);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();

        ArrayList<Maapala> miinat = rekisteri.getMiinat();
        assertTrue(miinat.size() == 10);
    }

    @Test
    public void oikeaMaaraMiinoja2() {
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(10, 15);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();

        ArrayList<Maapala> miinat = rekisteri.getMiinat();
        assertTrue(miinat.size() == 15);
    }

    @Test
    public void miinoillaOikeaArvo() {
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 20);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();

        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        for (Maapala maapala : maapalat) {
            if (maapala.onkoMiina()) {
                assertTrue(maapala.getArvo() == -1);
            }
        }

    }

    @Test
    public void miinoillaOikeaArvo2() {
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();

        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        for (Maapala maapala : maapalat) {
            if (maapala.onkoMiina()) {
                assertTrue(maapala.getArvo() == -1);
            }
        }
    }
}
