public class Euclid {

    public int get(int p, int q) {
        if (q == 0){
            return p;
        }else{
            int r = p % q;
            System.out.println(q + " " + r);
            return get(q, r);
        }
    }
}
