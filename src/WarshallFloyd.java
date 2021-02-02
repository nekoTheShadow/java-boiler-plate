
public class WarshallFloyd {
    private int n;
    private long[][] wf;

    public WarshallFloyd(int n) {
        this.n = n;
        this.wf = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++ ) {
                if (i == j) {
                    this.wf[i][j] = 0;
                } else {
                    this.wf[i][j] = Long.MAX_VALUE/2-1;
                }
            }
        }
    }

    public void addEdge(int from, int to, long dist) {
        this.wf[from][to] = dist;
    }

    public void solve() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    wf[i][j] = Math.min(wf[i][j], wf[i][k] + wf[k][j]);
                }
            }
        }
    }

    public long getDist(int from, int to) {
        return this.wf[from][to];
    }
}
