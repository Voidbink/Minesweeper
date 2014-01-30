/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.minesweeper;

import minesweeper.minesweeper.logiikka.Maapala;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;
import java.util.ArrayList;
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
public class MineSweeperTest {
    
    public MineSweeperTest() {
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
    public void oikeaMaaraMaapaloja(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(10, 10);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        assertTrue(maapalat.size() == 100);
    }
    
    @Test
    public void oikeaMaaraPaloja2(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 10);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        assertTrue(maapalat.size() == 400);
    }
    @Test
    public void oikeaMaaraMiinoja(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 10);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();
        
        ArrayList<Maapala> miinat = rekisteri.getMiinat();
        assertTrue(miinat.size() == 10);
    }
    @Test
    public void oikeaMaaraMiinoja2(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(10, 15);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();
        
        ArrayList<Maapala> miinat = rekisteri.getMiinat();
        assertTrue(miinat.size() == 15);
    }
    @Test
    public void miinoillaOikeaArvo(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 20);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        for (Maapala maapala : maapalat) {
            if(maapala.onkoMiina()){
                assertTrue(maapala.getArvo() == -1);
            }
        }
        
    }
    @Test
    public void miinoillaOikeaArvo2(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        for (Maapala maapala : maapalat) {
            if(maapala.onkoMiina()){
                assertTrue(maapala.getArvo() == -1);
            }
        }
    }
    @Test
    public void maaPaloillaOikeaArvoAlussa(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            assertTrue(maapala.getArvo() == 0);
        }
        
    }
    @Test
    public void maaPalojenArvoKasvaaYhdella(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            maapala.kasvataArvoa();
        }
        for (Maapala maapala : maapalat) {
            assertTrue(maapala.getArvo() == 1);
        }
    }
    @Test
    public void maaPalojenArvoKasvaaKahdella(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            maapala.kasvataArvoa();
            maapala.kasvataArvoa();
        }
        for (Maapala maapala : maapalat) {
            assertTrue(maapala.getArvo() == 2);
        }
    }
    @Test
    public void kaikkiMuuttuvatMiinoiksi(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            maapala.muutaMiinaksi();
        }
        for (Maapala maapala : maapalat) {
            assertTrue(maapala.getArvo() == -1);
        }
    }
    @Test
    public void palojenArvotKasvavatOikeinJosMiinaKeskella(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(3, 1);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            if(maapala.getX() == 1 && maapala.getY() == 1){
                maapala.muutaMiinaksi();
            }
        }
        rekisteri.kasvataMaapalojenArvojaJosMiinanVieressa(1, 1);
        
        for (Maapala maapala : maapalat) {
            if(!maapala.onkoMiina()){
                assertTrue(maapala.getArvo() == 1);
            }
        }
    }
    @Test
    public void palaOnTyhjaAluksi(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            assertTrue(maapala.onkoArvoNolla());
        }
    }
    @Test
    public void kunKaikkiMiinojaMikaanEiOleTyhja(){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(5, 5);
        rekisteri.luoMaapalat();
        
        ArrayList<Maapala> maapalat = rekisteri.getMaapalat();
        
        for (Maapala maapala : maapalat) {
            maapala.muutaMiinaksi();
        }
        for (Maapala maapala : maapalat) {
            assertFalse(maapala.onkoArvoNolla());
        }
    }
}
