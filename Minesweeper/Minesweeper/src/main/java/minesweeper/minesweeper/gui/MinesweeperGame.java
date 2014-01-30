package minesweeper.minesweeper.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;

public class MinesweeperGame {

    private int miinoja;
    private int koko;
    private JFrame frame;
    private MaapalaRekisteri maapalat;

    public MinesweeperGame(int koko, int miinoja) {
        this.koko = koko;
        this.miinoja = miinoja;
        this.maapalat = new MaapalaRekisteri(koko, miinoja);
    }

    public void run() {
        frame = new JFrame("Minesweeper");
        int leveys = 800;
        int korkeus = 800;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(koko, koko);
        container.setLayout(layout);
        JButton[][] nappulat = new JButton[koko][koko];

        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                JButton nappula = new JButton();
                GameClickListener kuuntelija = new GameClickListener(i, j, maapalat);
                nappula.addMouseListener(kuuntelija);
                nappulat[i][j] = nappula;
            }
        }
        for (int i = 0; i < nappulat.length; i++) {
            for (int j = 0; j < nappulat.length; j++) {
                container.add(nappulat[i][j]);
            }
        }
    }
}

