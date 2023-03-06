import java.util.ArrayList;

public class Tas {
    public ArrayList<Cards> tas;

    public Tas() {
        this.tas = new ArrayList<>();
    }

    public boolean add(Cards carte) {
        if (this.isIn(carte)) {
            return false;
        } else {
            this.tas.add(carte);
            return true;
        }
    }

    public void generate() {
        Generateur gen = new Generateur();
        Cards carte = new Cards(gen);
        this.add(carte);
        while (!this.isFull()) {
            gen = new Generateur(gen);
            carte = new Cards(gen);
            this.add(carte);
        }
    }

    public boolean isFull() {
        return this.tas.size() == 2;
    }

    public boolean isIn(Cards carte) {
        for (Cards c : this.tas) {
            if (c.Blue.equals(carte.Blue) && c.Red.equals(carte.Red)) {
                return true;
            }
        }
        return false;
    }

}
