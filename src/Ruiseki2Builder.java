
public class Ruiseki2Builder {
    private int h;
    private int w;
    private long[][] a;

    public Ruiseki2Builder(int h, int w) {
        this.h = h;
        this.w = w;
        this.a = new long[h][w];
    }

    public void set(int x, int y, long v) {
        this.a[x][y] = v;
    }

    public Ruiseki2Result build() {
        long[][] s  = new long[h+1][w+1];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
            }
        }
        return new Ruiseki2Result(s);
    }
}
