import java.util.ArrayList;

public class Game {
    ArrayList<Joueur> joueurs;

    public Game() {
        this.joueurs = new ArrayList<>();
    }

    public void addJoueur(String nom) {
        Joueur j = new Joueur(nom);
        this.joueurs.add(j);
    }

    public void addJoueurs(String[] noms) {
        for (String nom : noms) {
            this.addJoueur(nom);
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.addJoueurs(args);
        
    }
}
