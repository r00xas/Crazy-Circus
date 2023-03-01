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
        while (s.size()!=0) {
            Bleu.addFirst(s.get(rand.nextInt(s.size())));
            for (int i = 0; i < s.size(); ++i) {
                if (Bleu.getFirst() == s.get(i)) {
                    s.remove(i);
                }
            }
            Rouge.addFirst(s.get(rand.nextInt(s.size())));
            for (int i = 0; i < s.size(); ++i) {
                if (Rouge.getFirst() == s.get(i)) {
                    s.remove(i);
                }
            }
        }
    }
    public Generateur() {
        this.BlueDepart = new LinkedList<>();
        this.RedDepart = new LinkedList<>();
        this.RedArrivee = new LinkedList<>();
        this.BlueArrivee = new LinkedList<>();

        Aleatoire(this.BlueDepart,this.RedDepart);
        Aleatoire(this.BlueArrivee,RedArrivee);
        /*BlueDepart.addFirst(this.lion);
        BlueDepart.addFirst(this.ours);
        RedDepart.addFirst(this.elephant);
        BlueArrivee.addFirst(this.elephant);
        BlueArrivee.addFirst(this.lion);
        BlueArrivee.addFirst(this.ours);*/
    }

    public String toString(){

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
    }



}
