public class Test {
    public static void main(String[] args) {
        Generateur gen = new Generateur();
        Tas tas = new Tas();
        Cards carte = new Cards(gen);
        tas.add(carte);
        while (true) {
            gen = new Generateur(gen);
            carte = new Cards(gen);
            tas.add(carte);
        }
    }
}
