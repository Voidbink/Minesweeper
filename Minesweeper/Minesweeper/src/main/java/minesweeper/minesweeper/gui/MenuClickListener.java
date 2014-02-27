package minesweeper.minesweeper.gui;

/**
 * Tämä luokka kuuntelee Menun klikkauksia.
 * 
 * @author Mikael Parvamo
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import minesweeper.minesweeper.gui.MinesweeperGameGUI;

public class MenuClickListener implements ActionListener{
    private JButton easy;
    private JButton medium;
    private JButton hard;

    public MenuClickListener(JButton easy, JButton medium, JButton hard) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
    }
    
    /**
     * Metodi saa parametrina klikkauksen. Metodin tehtävänä on tarkistaa
     * klikkauksen tehnyt komponentti ja käynnistää sen perusteella joko easy, 
     * medium tai hard vaikeustaso.
     * 
     * @param e (tehty klikkaus)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == easy){
            MinesweeperGameGUI peli = new MinesweeperGameGUI(20, 30);
            peli.run();
        }else if(e.getSource() == medium){
            MinesweeperGameGUI peli = new MinesweeperGameGUI(20, 45);
            peli.run();
        }else{
            MinesweeperGameGUI peli = new MinesweeperGameGUI(20, 60);
            peli.run();
        }
    }
}

