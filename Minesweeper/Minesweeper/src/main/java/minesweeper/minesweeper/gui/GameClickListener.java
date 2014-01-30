package minesweeper.minesweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import minesweeper.minesweeper.logiikka.MaapalaRekisteri;

public class GameClickListener implements MouseListener {
    private int x;
    private int y;

    private MaapalaRekisteri maapalat;

    public GameClickListener(int x, int y, MaapalaRekisteri maapalat) {
        this.maapalat = maapalat;
        this.x = x;
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

