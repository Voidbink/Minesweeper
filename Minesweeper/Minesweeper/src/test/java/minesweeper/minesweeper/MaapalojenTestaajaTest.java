/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.minesweeper;

import minesweeper.minesweeper.logiikka.Maapala;
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
public class MaapalojenTestaajaTest {

    public MaapalojenTestaajaTest() {
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
    public void maapalallaOikeaArvoLuodessa() {
        Maapala maapala = new Maapala(1, 1);
        assertTrue(maapala.getArvo() == 0);
    }

    @Test
    public void maapalallaOikeaArvoaMuutoksenJalkeen() {
        Maapala maapala = new Maapala(1, 1);
        maapala.kasvataArvoa();
        assertTrue(maapala.getArvo() == 1);
        maapala.kasvataArvoa();
        assertTrue(maapala.getArvo() == 2);
    }

    @Test
    public void maapalaMuuttuuMiinaksi() {
        Maapala maapala = new Maapala(1, 1);
        maapala.muutaMiinaksi();
        assertTrue(maapala.getArvo() == -1);
    }
}
