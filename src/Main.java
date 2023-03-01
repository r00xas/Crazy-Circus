public class Main {
    public static void main(String[] args) {
        Generateur g = new Generateur();
        Cards carte = new Cards();
        System.out.println(g.toString());
        Commands.affichageCommandes();
        Commands.traitement("SONI", carte);
    }
}