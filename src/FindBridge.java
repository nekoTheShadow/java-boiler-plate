import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://ei1333.github.io/luzhiled/snippets/graph/lowlink.html
 * LowLinkを利用してグラフの橋の一覧を求める。
 */
public class FindBridge {
    private int n;
    private List<List<Integer>> g;
    private boolean[] used;
    private int[] ord;
    private int[] low;
    private List<int[]> bridge;
    
    public FindBridge(int n) {
        this.n = n;
        this.g = IntStream.range(0, n).mapToObj(unused -> new ArrayList<Integer>()).collect(Collectors.toList());
        this.used = new boolean[n];
        this.ord = new int[n];
        this.low = new int[n];
        this.bridge = new ArrayList<>();
    }
    
    public void add(int from, int to) {
        g.get(from).add(to);
    }
    
    public List<int[]> run() {
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                k = dfs(i, k, -1);
            }
        }
        return bridge;
    }
    
    private int dfs(int idx, int k, int par) {
        used[idx] = true;
        ord[idx] = k++;
        low[idx] = ord[idx];
        for (int to : g.get(idx)) {
            if (!used[to]) {
                k = dfs(to, k, idx);
                low[idx] = Math.min(low[idx], low[to]);
                if (ord[idx] < low[to]) {
                    int min = Math.min(idx, to);
                    int max = Math.max(idx, to);
                    bridge.add(new int[] {min, max});
                }
            } else if (to != par) {
                low[idx] = Math.min(low[idx], ord[to]);
            }
        }
        return k;
    }
}
