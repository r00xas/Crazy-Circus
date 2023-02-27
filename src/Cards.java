import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cards {
    public Queue<String> Blue;
    public Queue<String> Red;
    public Queue<String> Manoeuvre;

    public Cards(Generateur gen) {
        this.Manoeuvre = new LinkedList<>();
        this.Blue = gen.BlueDepart;
        this.Red = gen.RedDepart;
    }

    public Cards() {
        this.Manoeuvre = new LinkedList<>();
        this.Blue = new LinkedList<>();
        this.Red = new LinkedList<>();
        this.Blue.offer("LION");
        this.Blue.offer("OURS");
        this.Red.offer("ELEPHANT");
    }
}

