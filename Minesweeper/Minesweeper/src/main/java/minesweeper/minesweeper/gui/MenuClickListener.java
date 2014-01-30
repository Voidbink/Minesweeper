package minesweeper.minesweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import minesweeper.minesweeper.gui.MinesweeperGame;

public class MenuClickListener implements ActionListener{
    private JButton easy;
    private JButton medium;
    private JButton hard;

    public MenuClickListener(JButton easy, JButton medium, JButton hard) {
        this.easy = easy;
        this.medium = medium;
        this.hard = hard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == easy){
            MinesweeperGame peli = new MinesweeperGame(20, 20);
            peli.run();
        }else if(e.getSource() == medium){
            MinesweeperGame peli = new MinesweeperGame(20, 40);
            peli.run();
        }else{
            MinesweeperGame peli = new MinesweeperGame(20, 60);
            peli.run();
        }
    }
}

