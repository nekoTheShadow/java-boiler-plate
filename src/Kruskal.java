import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
        private int n;
        private List<KruskalEdge> edges;
        
        public Kruskal(int n) {
            this.n = n;
            this.edges = new ArrayList<>();
        }
        
        public void add(int x, int y, long weight) {
            this.edges.add(new KruskalEdge(x, y, weight));
        }
        
        public List<KruskalEdge> run() {
            edges.sort(Comparator.comparing(KruskalEdge::getWeight));
            UnionFind uf = new UnionFind(n);
            List<KruskalEdge> ans = new ArrayList<>();
            for (KruskalEdge edge : edges) {
                if (!uf.same(edge.getX(), edge.getY())) {
                    ans.add(edge);
                    uf.union(edge.getX(), edge.getY());
                }
            }
            return ans;
        }
    }