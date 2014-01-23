package minesweeper.minesweeper;
import minesweeper.minesweeper.logiikka.*;
import java.util.*;

public class App {
    public static void main( String[] args ){
        MaapalaRekisteri rekisteri = new MaapalaRekisteri(20, 40);
        rekisteri.luoMaapalat();
        rekisteri.alustaMiinat();
        rekisteri.asetaMaapalojenArvot();
        rekisteri.tulostaMaapalat();
        
        
    }
}
