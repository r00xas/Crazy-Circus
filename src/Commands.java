import java.util.ArrayList;
import java.util.LinkedList;

public class Commands {

    public static boolean traitement(String commande_full, Cards carte) {
        ArrayList<String> listeCommandes = new ArrayList<>();
        String commande = new String();
        boolean statement = true;

        for (int i = 0; i < commande_full.length(); i=i+2) {
            if (i + 2 <= commande_full.length()) {
                listeCommandes.add(commande_full.substring(i, i + 2));
            }
            else {
                break;
            }
        }

        for (String listeCommande : listeCommandes) {
            commande = listeCommande;
            switch (commande) {
                case "KI" -> statement=doKi(carte);
                case "LO" -> statement=doLo(carte);
                case "SO" -> statement=doSo(carte);
                case "NI" -> statement=doNi(carte);
                case "MA" -> statement=doMa(carte);
                default -> {
                    System.out.println("Commande inconnue");
                    return false;
                }
            }
        }
        return statement;
    }

    public static boolean isRight(Cards carte, Generateur g) {
        return carte.Blue.equals(g.BlueArrivee) && carte.Red.equals(g.RedArrivee);
    }

    public static boolean doKi(Cards carte) {
        if (carte.Blue.peek() == null) {
            return false;
        }
        carte.Red.addFirst(carte.Blue.removeFirst());
        return true;
    }
    public static boolean doLo(Cards carte) {
        if (carte.Red.peek() == null) {
            return false;
        }
        carte.Blue.addFirst(carte.Red.removeFirst());
        return true;
    }
    public static boolean doSo(Cards carte) {
        if (carte.Blue.peek() == null || carte.Red.peek() == null) {
            return false;
        }

        carte.Manoeuvre.addFirst(carte.Blue.removeFirst());
        carte.Manoeuvre.addFirst(carte.Red.removeFirst());
        carte.Blue.addFirst(carte.Manoeuvre.removeFirst());
        carte.Red.addFirst(carte.Manoeuvre.removeFirst());

        return true;
    }
    public static boolean doNi(Cards carte) {

        if (carte.Blue.peek() == null) {
            return false;
        }

        while (carte.Blue.peek() != null) {
            carte.Manoeuvre.addFirst(carte.Blue.removeFirst());
        }
        carte.Blue = carte.Manoeuvre;
        carte.Manoeuvre = new LinkedList<>();

        return true;
    }
    public static boolean doMa(Cards carte) {

        if (carte.Red.peek() == null) {
            return false;
        }

        while (carte.Red.peek() != null) {
            carte.Manoeuvre.addFirst(carte.Red.removeFirst());
        }
        carte.Red = carte.Manoeuvre;
        carte.Manoeuvre = new LinkedList<>();

        return true;

    }

    public static void affichageCommandes() {
        System.out.println("--------------------------------------------");
        System.out.println("KI : BLEU --> ROUGE     NI : BLEU ^\nLO : BLEU <-- ROUGE     MA : ROUGE ^\nSO : BLEU <-> ROUGE\n");
    }
}
