import java.util.ArrayList;
import java.util.Objects;
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
            if (Objects.equals(this.joueurs.get(i).nom, nom)) {
                if (!this.joueurs.get(i).aErreur) {
                    this.joueurActuel = i;
                    return true;
                } else {
                    System.out.println("Ce joueur a déjà fait une erreur !");
                    return false;
                }
            }
        }
        System.out.println("Ce joueur n'existe pas !");
        return false;
    }

    public static void main(String[] args) {
        Game partie = new Game();
        partie.addJoueurs(args);
        Scanner sc = new Scanner(System.in);
        Generateur g = new Generateur();
        Cards carteDepart = new Cards(g);
        Tas tas = new Tas();
        while (!partie.isOver) {
            Cards carte = new Cards(g);
            if (tas.isIn(carte)){
                do {
                    g = new Generateur();
                    carte = new Cards(g);
                    tas.add(carte);
                } while (!tas.isIn(carte));
            }
            else tas.add(carte);
            Boolean verif = false;
            System.out.println("Bleu : "+g.BlueDepart + " | Rouge : " + g.RedDepart);
            System.out.println("Bleu : "+g.BlueArrivee + " | Rouge : " + g.RedArrivee);
            System.out.println("-----------------------------------------------------");
            System.out.println(g.toString());
            Commands.affichageCommandes();
            String commande = "";

            while (!verif) {
                commande = sc.nextLine();
                verif = partie.setJoueurActuel(commande.split(" ")[0]);
            }

            Commands.traitement(commande.split(" ")[1], carte);
            if (Commands.isRight(carte, g)) {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + " remporte la manche !");
                partie.joueurs.get(partie.joueurActuel).addScore(1);
                g = new Generateur(g);
            } else {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + ", la sequence c'est pas bonne :/");
            }
        }
    }
}
