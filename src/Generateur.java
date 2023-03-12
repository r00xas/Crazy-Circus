import java.util.*;

public class Generateur {
    public Deque<String> BlueDepart;
    public Deque<String> RedDepart;
    public Deque<String> BlueArrivee;
    public Deque<String> RedArrivee;

    public String elephant = "ELEPHANT";
    public String lion = "LION";
    public String ours = "OURS";

    public void Aleatoire(Deque<String> Bleu, Deque<String> Rouge){
        Random rand = new Random();
        ArrayList<String> s = new ArrayList<>();
        s.add(this.elephant);
        s.add(this.ours);
        s.add(this.lion);
        s.add("");
        String temp = "";
        while (s.size() != 0) {
            if (rand.nextInt(0, 3) == 1) {
                Bleu.addFirst(s.get(rand.nextInt(s.size())));
                for (int i = 0; i < s.size(); ++i) {
                    if (Bleu.getFirst() == s.get(i)) {
                        s.remove(i);
                    }
                }
            } else {
                Rouge.addFirst(s.get(rand.nextInt(s.size())));
                for (int i = 0; i < s.size(); ++i) {
                    if (Rouge.getFirst() == s.get(i)) {
                        s.remove(i);
                    }
                }
            }
        }

        Deque<String> tempBleu = new LinkedList<>();
        Deque<String> tempRouge = new LinkedList<>();
        while (Bleu.size()!=0){
            tempBleu.addFirst(Bleu.removeFirst());
        }
        while (Rouge.size()!=0){
            tempRouge.addFirst(Rouge.removeFirst());
        }
        while (tempBleu.size()!=0){
            if (tempBleu.peek() != "") {
                Bleu.addFirst(tempBleu.removeFirst());
            }
            else {
                temp = tempBleu.removeFirst();
            }
        }
        while (tempRouge.size()!=0){
            if (tempRouge.peek() != "") {
                Rouge.addFirst(tempRouge.removeFirst());
            }
            else {
                temp = tempRouge.removeFirst();
            }
        }
    }
    public Generateur() {
        this.BlueDepart = new LinkedList<>();
        this.RedDepart = new LinkedList<>();
        this.RedArrivee = new LinkedList<>();
        this.BlueArrivee = new LinkedList<>();

        do {
            Aleatoire(this.BlueDepart, this.RedDepart);
            Aleatoire(this.BlueArrivee, RedArrivee);
        } while (this.BlueDepart.equals(this.BlueArrivee) && this.RedDepart.equals(this.RedArrivee));
    }

    public Generateur(Generateur gen) {
        this.BlueDepart = gen.BlueArrivee;
        this.RedDepart = gen.RedArrivee;
        this.RedArrivee = new LinkedList<>();
        this.BlueArrivee = new LinkedList<>();

        do {
            Aleatoire(this.BlueArrivee, this.RedArrivee);
        } while ((this.BlueDepart.equals(this.BlueArrivee)) && (this.RedDepart.equals(this.RedArrivee)));
    }

    /*public String toString(){

        Object[] BlueDepartListe = BlueDepart.toArray();
        Object[] RedDepartListe = RedDepart.toArray();
        Object[] BlueArriveeListe = BlueArrivee.toArray();
        Object[] RedArriveeListe = RedArrivee.toArray();
        String retourner = "";


        if (BlueDepartListe.length > 1) retourner += BlueDepartListe[0];
        retourner += "\t";
        if (RedDepartListe.length > 1) retourner += RedDepartListe[0];

        retourner += "\t\t\t\t";

        if (BlueArriveeListe.length > 1) retourner += BlueArriveeListe[0];
        retourner += "\t";
        if (RedArriveeListe.length > 1) retourner += RedArriveeListe[0];


        retourner += "\n";


        if (BlueDepartListe.length > 1) retourner += BlueDepartListe[1];
        else if (BlueDepartListe.length == 1) retourner += BlueDepartListe[0];
        else retourner += "\t";

        retourner += "\t";

        if (RedDepartListe.length > 1) retourner += RedDepartListe[1];
        else if (RedDepartListe.length == 1) retourner += RedDepartListe[0];
        else retourner += "\t";

        retourner += "\t\t";

        if (BlueArriveeListe.length > 1) retourner += BlueArriveeListe[1];
        else if (BlueArriveeListe.length == 1) retourner += BlueArriveeListe[0];
        else retourner += "\t";

        retourner += "\t";
        if (RedArriveeListe.length > 1) retourner += RedArriveeListe[1];
        else if (RedArriveeListe.length == 1) retourner += RedArriveeListe[0];
        else retourner += "\t";


        retourner +="\n";
        retourner += "----"+"\t"+"----"+"\t\t"+"==>"+"\t"+"----"+"\t\t"+"----";
        retourner +="\n";
        retourner+= "BLEU"+"\t"+"ROUGE"+"\t\t\t"+"BLEU"+"\t\t"+"ROUGE";



        return retourner;
    }*/

    public String toString(){

        Object[] BlueDepartListe = BlueDepart.toArray();
        Object[] RedDepartListe = RedDepart.toArray();
        Object[] BlueArriveeListe = BlueArrivee.toArray();
        Object[] RedArriveeListe = RedArrivee.toArray();
        String retourner = "";


        if (BlueDepartListe.length == 3 && BlueDepartListe[0] == "ELEPHANT") retourner += BlueDepartListe[0] + " ";
        else if (BlueDepartListe.length == 3) retourner += BlueDepartListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t";

        if (RedDepartListe.length == 3 && RedDepartListe[0] == "ELEPHANT") retourner += RedDepartListe[0] + " ";
        else if (RedDepartListe.length == 3) retourner += RedDepartListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t\t\t\t";


        if (BlueArriveeListe.length == 3 && BlueArriveeListe[0] == "ELEPHANT") retourner += BlueArriveeListe[0] + " ";
        else if (BlueArriveeListe.length == 3) retourner += BlueArriveeListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t";

        if (RedArriveeListe.length == 3 && RedArriveeListe[0] == "ELEPHANT") retourner += RedArriveeListe[0] + " ";
        else if (RedArriveeListe.length == 3) retourner += RedArriveeListe[0] + "\t ";
        else retourner += "\t ";

        // LIGNE SUIVANTE
        retourner += "\n";


        if (BlueDepartListe.length == 3 && BlueDepartListe[1] == "ELEPHANT") retourner += BlueDepartListe[1] + " ";
        else if (BlueDepartListe.length == 3) retourner += BlueDepartListe[1] + "\t ";
        else if (BlueDepartListe.length == 2 && BlueDepartListe[0] == "ELEPHANT") retourner += BlueDepartListe[0] + " ";
        else if (BlueDepartListe.length == 2) retourner += BlueDepartListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t";

        if (RedDepartListe.length == 3 && RedDepartListe[1] == "ELEPHANT") retourner += RedDepartListe[1] + " ";
        else if (RedDepartListe.length == 3) retourner += RedDepartListe[1] + "\t ";
        else if (RedDepartListe.length == 2 && RedDepartListe[0] == "ELEPHANT") retourner += RedDepartListe[0] + " ";
        else if (RedDepartListe.length == 2) retourner += RedDepartListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t\t\t\t";

        if (BlueArriveeListe.length == 3 && BlueArriveeListe[1] == "ELEPHANT") retourner += BlueArriveeListe[1] + " ";
        else if (BlueArriveeListe.length == 3) retourner += BlueArriveeListe[1] + "\t ";
        else if (BlueArriveeListe.length == 2 && BlueArriveeListe[0] == "ELEPHANT") retourner += BlueArriveeListe[0] + " ";
        else if (BlueArriveeListe.length == 2) retourner += BlueArriveeListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t";

        if (RedArriveeListe.length == 3 && RedArriveeListe[1] == "ELEPHANT") retourner += RedArriveeListe[1] + " ";
        else if (RedArriveeListe.length == 3) retourner += RedArriveeListe[1] + "\t ";
        else if (RedArriveeListe.length == 2 && RedArriveeListe[0] == "ELEPHANT") retourner += RedArriveeListe[0] + " ";
        else if (RedArriveeListe.length == 2) retourner += RedArriveeListe[0] + "\t ";
        else retourner += "\t ";
        
        // LIGNE SUIVANTE
        retourner += "\n";
        
        if (BlueDepartListe.length == 3 && BlueDepartListe[2] == "ELEPHANT") retourner += BlueDepartListe[2] + " ";
        else if (BlueDepartListe.length == 3) retourner += BlueDepartListe[2] + "\t ";
        else if (BlueDepartListe.length == 2 && BlueDepartListe[1] == "ELEPHANT") retourner += BlueDepartListe[1] + " ";
        else if (BlueDepartListe.length == 2) retourner += BlueDepartListe[1] + "\t ";
        else if (BlueDepartListe.length == 1 && BlueDepartListe[0] == "ELEPHANT") retourner += BlueDepartListe[0] + " ";
        else if (BlueDepartListe.length == 1) retourner += BlueDepartListe[0] + "\t ";
        else retourner += "\t ";
        
        retourner += "\t";

        if (RedDepartListe.length == 3 && RedDepartListe[2] == "ELEPHANT") retourner += RedDepartListe[2] + " ";
        else if (RedDepartListe.length == 3) retourner += RedDepartListe[2] + "\t ";
        else if (RedDepartListe.length == 2 && RedDepartListe[1] == "ELEPHANT") retourner += RedDepartListe[1] + " ";
        else if (RedDepartListe.length == 2) retourner += RedDepartListe[1] + "\t ";
        else if (RedDepartListe.length == 1 && RedDepartListe[0] == "ELEPHANT") retourner += RedDepartListe[0] + " ";
        else if (RedDepartListe.length == 1) retourner += RedDepartListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t\t\t\t";

        if (BlueArriveeListe.length == 3 && BlueArriveeListe[2] == "ELEPHANT") retourner += BlueArriveeListe[2] + " ";
        else if (BlueArriveeListe.length == 3) retourner += BlueArriveeListe[2] + "\t ";
        else if (BlueArriveeListe.length == 2 && BlueArriveeListe[1] == "ELEPHANT") retourner += BlueArriveeListe[1] + " ";
        else if (BlueArriveeListe.length == 2) retourner += BlueArriveeListe[1] + "\t ";
        else if (BlueArriveeListe.length == 1 && BlueArriveeListe[0] == "ELEPHANT") retourner += BlueArriveeListe[0] + " ";
        else if (BlueArriveeListe.length == 1) retourner += BlueArriveeListe[0] + "\t ";
        else retourner += "\t ";

        retourner += "\t";

        if (RedArriveeListe.length == 3 && RedArriveeListe[2] == "ELEPHANT") retourner += RedArriveeListe[2] + " ";
        else if (RedArriveeListe.length == 3) retourner += RedArriveeListe[2] + "\t ";
        else if (RedArriveeListe.length == 2 && RedArriveeListe[1] == "ELEPHANT") retourner += RedArriveeListe[1] + " ";
        else if (RedArriveeListe.length == 2) retourner += RedArriveeListe[1] + "\t ";
        else if (RedArriveeListe.length == 1 && RedArriveeListe[0] == "ELEPHANT") retourner += RedArriveeListe[0] + " ";
        else if (RedArriveeListe.length == 1) retourner += RedArriveeListe[0] + "\t ";
        else retourner += "\t ";
        
        

        retourner +="\n";
        retourner += "----"+"\t\t"+"----"+"\t\t"+"==>"+"\t\t"+"----"+"\t\t"+"----";
        retourner +="\n";
        retourner+= "BLEU"+"\t\t"+"ROUGE"+"\t\t\t"+"BLEU"+"\t\t"+"ROUGE";



        return retourner;
    }



}
