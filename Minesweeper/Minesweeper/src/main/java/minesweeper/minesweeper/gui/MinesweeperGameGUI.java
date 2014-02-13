package minesweeper.minesweeper.gui;

/**
 * Tämä luokka toimii Minesweeperin käyttöliittymänä.
 * Luokka luo komponentit ja asettaa ne ikkunaan.
 * 
 * @author Mikael Parvamo
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import minesweeper.minesweeper.logiikka.Maapala;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;

public class MinesweeperGameGUI {

    private int miinoja;
    private int koko;
    private JFrame frame;
    private MaapalaRekisteri maapalaRekisteri;
    private ArrayList<Nappula> nappulat;
    private ArrayList<Maapala> maapalat;

    public MinesweeperGameGUI(int koko, int miinoja) {
        this.koko = koko;
        this.miinoja = miinoja;
        this.maapalaRekisteri = new MaapalaRekisteri(koko, miinoja);
        this.nappulat = new ArrayList<Nappula>();
        this.maapalat = maapalaRekisteri.getMaapalat();
    }

    public void run() {
        maapalaRekisteri.luoMaapalat();
        maapalaRekisteri.alustaMiinat();
        maapalaRekisteri.asetaMaapalojenArvot();

        frame = new JFrame("Minesweeper");
        int leveys = 900;
        int korkeus = 900;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Tämä matodi luo komponentit, joita peli käyttää.
     * Metodi asettaa luomilleen nappuloille samassa koordinaatissa sijaitsevan
     * maapalan arvon ja lisää nappuloille MouseListenerin.
     * @param container 
     */
    
    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(koko, koko);
        container.setLayout(layout);
        
        JLabel score = new JLabel("Time: ");
        score.setLayout(layout);
        
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
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
        GameClickListener kuuntelija = new GameClickListener(nappulat);
        for (Nappula nappula : nappulat) {
            nappula.addMouseListener(kuuntelija);
        }       
        for (Nappula nappula : nappulat) {
            container.add(nappula);
        }
        
    }
}
