import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    ArrayList<Joueur> joueurs;

    boolean isOver = false;

    int joueurActuel = 0;

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

    public void setOver(boolean over) {
        isOver = over;
    }

    public boolean setJoueurActuel(String nom) {
        for (int i = 0; i < this.joueurs.size(); ++i) {
            if (this.joueurs.get(i).nom == nom) {
                this.joueurActuel = i;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Game partie = new Game();
        partie.addJoueurs(args);
        while (!partie.isOver) {
            Scanner sc = new Scanner(System.in);
            Generateur g = new Generateur();
            Cards carte = new Cards();
            System.out.println(g.BlueDepart + " " + g.RedDepart);
            System.out.println(g.BlueArrivee + " " + g.RedArrivee);
            Commands.affichageCommandes();
            partie.setJoueurActuel(sc.next());
            Commands.traitement(sc.next(), carte);
            if (Commands.isRight(carte, g)) {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + " remporte la manche !");
                partie.joueurs.get(partie.joueurActuel).addScore(1);
            } else {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + " perd la manche !");
            }
        }
    }
}
