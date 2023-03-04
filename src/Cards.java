import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Cards {
    public Deque<String> Blue;
    public Deque<String> Red;
    public Deque<String> Manoeuvre;

    public Cards(Generateur gen) {
        this.Manoeuvre = new LinkedList<>();
        this.Blue = gen.BlueDepart;
        this.Red = gen.RedDepart;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "Blue=" + Blue +
                ", Red=" + Red +
                ", Manoeuvre=" + Manoeuvre +
                '}';
    }
}

