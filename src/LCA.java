import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://atcoder.jp/contests/past201912-open/submissions/9688917
public class LCA {
    
    private int n;
    private List<List<Integer>> g;
 
    public LCA(int n){
        this.n = n;
        this.g = IntStream.range(0, n).mapToObj(unused -> new ArrayList<Integer>()).collect(Collectors.toList());
    }
    
    public void add(int parent, int child) {
        g.get(parent).add(child);
    }
    
    private int k;
    private int[] depth;
    private int[][] pars;
    
    public void build(int root) {
      k = Integer.toBinaryString(n).length();
      depth = new int[n];
      pars = new int[n][k+1];
      Arrays.fill(depth, -1);
      dfs(root, -1, 0);
      for (int i = 0; i < k; i++) {
          for (int j = 0; j < n; j++) {
              if(pars[j][i] < 0) {
                  pars[j][i+1] = -1;
              } else {
                  pars[j][i+1] = pars[ pars[j][i] ][i];
              }
          }
      }
    }
 
    private void dfs(int v, int p, int i) {
        pars[v][0] = p;
        depth[v] = i;
        for(int c : g.get(v)){
            if(depth[c] != -1) continue;
            dfs(c, v, i+1);
        }
    }
 
    public int lca(int a, int b){
        if(depth[a] < depth[b]){
            int t = b;
            b = a;
            a = t;
        }
        for (int i = 0; i <= k; i++) {
            if(((depth[a] - depth[b]) >> i & 1) == 1){
                a = pars[a][i];
            }
        }
        if(a == b) return a;
        for (int i = k; i >= 0; i--) {
            if(pars[a][i] != pars[b][i]){
                a = pars[a][i];
                b = pars[b][i];
            }
        }
        return pars[a][0];
    }
}