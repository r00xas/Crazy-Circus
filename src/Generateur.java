import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Generateur {
    public Queue<String> BlueDepart;
    public Queue<String> RedDepart;
    public Queue<String> BlueArrivee;
    public Queue<String> RedArrivee;



    public String elephant = "ELEPHANT";
    public String lion = "LION";
    public String ours = "OURS";

    public Generateur() {
        this.BlueDepart = new LinkedList<>();
        this.RedDepart = new LinkedList<>();
        this.RedArrivee = new LinkedList<>();
        this.BlueArrivee = new LinkedList<>();
        BlueDepart.offer(this.lion);
        BlueDepart.offer(this.ours);
        RedDepart.offer(this.elephant);
    }

    public String toString(){
        String s = "";
        s+=BlueDepart.toString();
        return s;
    }

}
