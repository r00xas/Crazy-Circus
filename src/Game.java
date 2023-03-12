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

    public Joueur gagnant() {
        int valeur = 0;
        for (Joueur j : joueurs) {
            if (j.score > valeur) {
                valeur = j.score;
            }
        }
        for (Joueur j : joueurs) {
            if (j.score == valeur) {
                return j;
            }
        }
        return null;
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

    public void resetJoueurs() {
        for (Joueur j : this.joueurs) {
            j.aErreur = false;
        }
    }

    public int nbJoueursRestants () {
        int nb = 0;
        for (Joueur j : this.joueurs) {
            if (!j.aErreur) {
                nb++;
            }
        }
        return nb;
    }

    public Joueur getJoueurRestant () {
        if (this.nbJoueursRestants() == 1) {
            for (Joueur j : this.joueurs) {
                if (!j.aErreur) {
                    return j;
                }
            }
        }
        return null;
    }

    public static void jouer (Game partie, Generateur g, Cards carte) {
        Scanner sc = new Scanner(System.in);
        String commande = "";
        Boolean verif = false;
        Boolean isOver = false;

        while (!isOver) {

            while (!verif) {
                commande = sc.nextLine();
                verif = partie.setJoueurActuel(commande.split(" ")[0]);
            }

            Commands.traitement(commande.split(" ")[1], carte);
            if (Commands.isRight(carte, g)) {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + " remporte la manche !");
                partie.joueurs.get(partie.joueurActuel).addScore(1);
                isOver = true;
            } else {
                System.out.println(partie.joueurs.get(partie.joueurActuel).nom + ", la sequence c'est pas bonne");
                partie.joueurs.get(partie.joueurActuel).aErreur = true;
                if (partie.nbJoueursRestants() == 1) {
                    isOver = true;
                    System.out.println(partie.getJoueurRestant().nom + " a gagné la manche !");
                    partie.getJoueurRestant().addScore(1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Game partie = new Game();
        partie.addJoueurs(args);
        Generateur g = new Generateur();
        Generateur oldG = new Generateur();
        Tas tas = new Tas();
        Cards carte = new Cards(g);
        while (!partie.isOver) {
            if (tas.isIn(carte)) {
                do {
                    g = new Generateur(oldG);
                    carte = new Cards(g);
                    tas.add(carte);
                } while (!tas.isIn(carte));
            } else tas.add(carte);

            System.out.println("Bleu : " + g.BlueDepart + " | Rouge : " + g.RedDepart);
            System.out.println("Bleu : " + g.BlueArrivee + " | Rouge : " + g.RedArrivee);
            Commands.affichageCommandes();
            jouer(partie,g,carte);
            partie.resetJoueurs();
            oldG = g;
            g = new Generateur(g);
        }
    }
}