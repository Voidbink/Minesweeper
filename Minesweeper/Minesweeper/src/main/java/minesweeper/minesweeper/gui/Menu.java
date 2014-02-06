
package minesweeper.minesweeper.gui;

/**
 * Tämä luokka on Minesweeperin menu.
 * Menusta pelaaja voi valita joko easyn, mediumin tai hardin pelin vaikeustasoksi.
 * 
 * @author Mikael Parvamo
 */

import minesweeper.minesweeper.logiikka.*;
import minesweeper.minesweeper.gui.*;
import javax.swing.*;
import java.awt.*;

public class Menu {
    private JFrame frame;
    
    public Menu(){
        
    }
    
    public void run(){
        frame = new JFrame("Minesweeper");
        int leveys = 400;
        int korkeus = 400;
        
        frame.setPreferredSize(new Dimension(leveys, korkeus));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    /**
     * Tämä metodi luo menun komponentit ja asettaa nillee actionListenerin, joka
     * kuuntelee menuun tehtyjä klikkauksia.
     * @param container 
     */
    private void luoKomponentit(Container container){
        GridLayout layout = new GridLayout(3, 1, 20, 50);
        container.setLayout(layout);
        
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton ("Hard");
        
        MenuClickListener kuuntelija = new MenuClickListener(easy, medium, hard);
        
        easy.addActionListener(kuuntelija);
        medium.addActionListener(kuuntelija);
        hard.addActionListener(kuuntelija);
        
        container.add(easy);
        container.add(medium);
        container.add(hard);
        
        
    }
    public JFrame getFrame(){
        return this.frame;
    }
}
