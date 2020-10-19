import java.util.Arrays;
import java.util.OptionalLong;

// 巡回セールスマン問題
public class TSP {
    private int n;
    private boolean[][] ok;
    private long[][] cost;
    public TSP(int n) {
        this.n = n;
        this.cost = new long[n][n];;
        this.ok = new boolean[n][n];
    }

    public void add(int from, int to, long cost) {
        this.ok[from][to] = true;
        this.cost[from][to] = cost;
    }

    public OptionalLong run(int start) {
        int m = 1 << n;
        long[][] dp = new long[m][n];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][start] = 0;

        for (int bit = 0; bit < m; bit++) {
            for (int i = 0; i < n; i++) {
                if (dp[bit][i]==Long.MAX_VALUE) continue;
                for (int j = 0; j < n; j++) {
                    if (!this.ok[i][j]) continue;
                    dp[bit | (1<<j)][j] = Math.min(dp[bit | (1<<j)][j], dp[bit][i] + cost[i][j]);
                }
            }
        }
        if (dp[m-1][start] == Long.MAX_VALUE) {
            return OptionalLong.empty();
        } else {
            return OptionalLong.of(dp[m-1][start]);
        }
    }
}
