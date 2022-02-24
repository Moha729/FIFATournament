public class Player {

    private String name;

    private int m;
    private int p;

    private int w;
    private int d;
    private int l;

    private int gf;
    private int ga;
    private int gd;


    public Player(String name, int m, int p, int w, int d, int l, int gf, int ga, int gd) {
        this.name = name;
        this.m = m;
        this.p = p;
        this.w = w;
        this.d = d;
        this.l = l;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
    }

    public void showInTable(){}//do instance methods to translate these data

    @Override
    public String toString() {
        return name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }

    public int getGa() {
        return ga;
    }

    public void setGa(int ga) {
        this.ga = ga;
    }

    public int getGd() {
        return gd;
    }

    public void setGd(int gd) {
        this.gd = gd;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getP() {
        return p;
    }
}
