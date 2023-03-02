public class Joueur {
    String nom;
    int score;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0;
    }

    public void addScore(int score) {
        this.score += score;
    }
}
