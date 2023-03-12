public class Joueur {
    String nom;
    int score;

    boolean aErreur = false;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    public void addScore(int score) {
        this.score += score;
    }



    public void setErreur(boolean erreur) {
        this.aErreur = erreur;
    }
}
