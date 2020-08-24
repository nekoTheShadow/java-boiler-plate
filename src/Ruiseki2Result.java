
public class Ruiseki2Result {
    private long[][] s;

    public Ruiseki2Result(long[][] s) {
        this.s = s;
    }

    // クエリ [x1, x2) × [y1, y2) の長方形区域の和
    public long sum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1][y2] - s[x2][y1] + s[x1][y1];
    }
}
