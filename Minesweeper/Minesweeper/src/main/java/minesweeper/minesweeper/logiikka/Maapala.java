package minesweeper.minesweeper.logiikka;

public class Maapala {

    private int x;
    private int y;
    private int arvo;

    public Maapala(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getArvo() {
        return this.arvo;
    }

    @Override
    public String toString() {
        if (this.arvo == -1) {
            return " M ";
        }
        return " " + this.arvo + " ";
    }

    public void kasvataArvoa() {
        this.arvo++;
    }

    public void muutaMiinaksi() {
        this.arvo = -1;
    }

    public boolean onkoMiina() {
        if (this.arvo == -1) {
            return true;
        }
        return false;
    }

    public void kasvataArvoaJosEiMiina() {
        if (!onkoMiina()) {
            this.kasvataArvoa();
        } else {
        }
    }

    public boolean onkoArvoNolla() {
        if (this.arvo == 0) {
            return true;
        } else {
            return false;
        }
    }
}
