import java.util.ArrayList;

public class Commands {

    public static void traitement(String commande_full, Cards carte) {
        ArrayList<String> listeCommandes = new ArrayList<>();
        String commande = new String();

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
                case "KI" -> doKi(carte);
                case "LO" -> doLo(carte);
                case "SO" -> doSo(carte);
                case "NI" -> doNi(carte);
                case "MA" -> doMa(carte);
                default -> System.out.println("Commande inconnue");
            }
        }
    }

    public static void doKi(Cards carte) {
        carte.Blue.offer(carte.Red.poll());
        System.out.println("KI");
    }
    public static void doLo(Cards carte) {
        carte.Red.offer(carte.Blue.poll());
        System.out.println("LO");
    }
    public static void doSo(Cards carte) {
        carte.Manoeuvre.offer(carte.Blue.poll());
        carte.Red.offer(carte.Manoeuvre.poll());
        System.out.println("SO");
    }
    public static void doNi(Cards carte) {
        while (carte.Blue.peek() != null) {
            carte.Manoeuvre.offer(carte.Blue.poll());
        }
        while (carte.Manoeuvre.peek() != null) {
            carte.Blue.offer(carte.Manoeuvre.poll());
        }
        System.out.println("NI");
    }
    public static void doMa(Cards carte) {
        while (carte.Red.peek() != null) {
            carte.Manoeuvre.offer(carte.Red.poll());
        }
        while (carte.Manoeuvre.peek() != null) {
            carte.Red.offer(carte.Manoeuvre.poll());
        }
        System.out.println("MA");
    }

    public static void affichageCommandes() {
        System.out.println("KI : BLEU --> ROUGE     NI : BLEU ^\nLO : BLEU <-- ROUGE     MA : ROUGE ^\nSO : BLEU <-> ROUGE\n");
    }
}
