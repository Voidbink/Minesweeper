package minesweeper.minesweeper.logiikka;

import java.util.*;

public class MiinojenAlustaja {
    
    private Random random;
    private int koko;
    private int miinoja;
    private ArrayList<Maapala> miinat;
    
    MiinojenAlustaja(int koko, int miinoja) {
        this.miinat = new ArrayList<>();
        this.miinoja = miinoja;
        this.koko = koko;
        this.random = new Random();
    }
    
    public ArrayList<Maapala> alustaMiinat() {
        
        while (miinat.size() < miinoja) {
            int onkoMiinaListassa = 0;
            int randomX = random.nextInt(koko - 1);
            int randomY = random.nextInt(koko - 1);
            
            if (miinat.isEmpty()) {
                miinat.add(new Maapala(randomX, randomY));
            } else {               
                for (Maapala miina : miinat) {
                    if (miina.getX() == randomX && miina.getY() == randomY) {
                        onkoMiinaListassa++;
                    }
                }
                if (onkoMiinaListassa == 0) {
                    miinat.add(new Maapala(randomX, randomY));
                }
            }
        }
        return miinat;
    }
    public ArrayList<Maapala> getMiinat(){
        return this.miinat;
    }
}
