import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FordFulkerson {
    private class Edge {
        private int from;
        private int to;
        private long cost;
        private int rev;
        private boolean origin;
        public Edge(int from, int to, long cost, int rev, boolean origin) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.rev = rev;
            this.origin = origin;
        }
    }

    private List<List<Edge>> g;
    private boolean[] seen;

    public FordFulkerson(int n) {
        this.g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            this.g.add(new ArrayList<>());
        }
        this.seen = new boolean[n];
    }

    public void addEdge(int from, int to, long cost) {
        int fromRev = this.g.get(from).size();
        int toRev = this.g.get(to).size();
        this.g.get(from).add(new Edge(from, to, cost, toRev, true));
        this.g.get(to).add(new Edge(to, from, 0, fromRev, false));
    }

    private void runFlow(Edge e, long f) {
        e.cost -= f;
        this.g.get(e.to).get(e.rev).cost += f;
    }

    private long dfs(int v, int t, long f) {
        if (v==t) return f;

        this.seen[v] = true;
        for (Edge e : this.g.get(v)) {
            if (this.seen[e.to]) continue;
            if (e.cost == 0) continue;

            long flow = this.dfs(e.to, t, Math.min(f, e.cost));
            if (flow==0) continue;

            this.runFlow(e, flow);

            return flow;
        }

        return 0;
    }

    public long solve(int s, int t) {
        long res = 0;
        while (true) {
            Arrays.fill(this.seen, false);
            long flow = this.dfs(s, t, Long.MAX_VALUE);
            if (flow==0) break;
            res += flow;
        }
        return res;
    }
}
