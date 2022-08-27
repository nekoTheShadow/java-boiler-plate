
public class Ruiseki2 {
    private int h;
    private int w;
    private long[][] a;
    private long[][] s;

    public Ruiseki2(int h, int w) {
        this.h = h;
        this.w = w;
        this.a = new long[h][w];
        this.s = new long[h+1][w+1];
    }

    public void set(int x, int y, long v) {
        this.a[x][y] = v;
    }

    public void build() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                s[i+1][j+1] = s[i][j+1] + s[i+1][j] - s[i][j] + a[i][j];
            }
        }
    }
    
    // クエリ [x1, x2) × [y1, y2) の長方形区域の和
    public long sum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1];
    }
}
