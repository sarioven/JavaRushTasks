public class Евклид {
    public static void main(String[] args) {
        System.out.println(evq(0, 10));
    }

    public static int evq(int p, int q) {
        if(q == 0) return p;
        int r = p % q;
        return evq(q, r);
    }
}
