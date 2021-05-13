import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 強連結成分分解を行います。
 */
public class SCC {
    private List<List<Integer>> g1;
    private List<List<Integer>> g2;
    
    public SCC(int n) {
        this.g1 = new ArrayList<>();
        this.g2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }
    }
    
    public void add(int from, int to) {
        this.g1.get(from).add(to);
        this.g2.get(to).add(from);
    }
    
    public List<List<Integer>> run() {
        Set<Integer> used1 = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        for (int start = 0; start < this.g1.size(); start++) dfs1(start, used1, order);

        Collections.reverse(order);
        List<List<Integer>> groups = new ArrayList<>();
        Set<Integer> used2 = new HashSet<>();
        for (Integer cur : order) {
            List<Integer> group = new ArrayList<>();
            dfs2(cur, used2, group);
            if (!group.isEmpty()) groups.add(group);
        }
        
        return groups;
    }
    
    private void dfs1(Integer cur, Set<Integer> used, List<Integer> order) {
        if (used.contains(cur)) return ;
        
        used.add(cur);
        for (Integer nxt : this.g1.get(cur)) {
            if (!used.contains(nxt)) dfs1(nxt, used, order);
        }
        order.add(cur);
    }
    
    private void dfs2(Integer cur, Set<Integer> used, List<Integer> group) {
        if (used.contains(cur)) return ;
        
        used.add(cur);
        group.add(cur);
        for (Integer nxt : this.g2.get(cur)) {
            if (!used.contains(nxt)) dfs2(nxt, used, group);
        }
    }
}

