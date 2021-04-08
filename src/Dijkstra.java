import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    private int n;
    private Map<Integer, List<Edge>> edges;

    public Dijkstra(int n) {
        this.n = n;
        this.edges = new HashMap<>();
    }

    public void add(int from, int to, long cost) {
        this.edges.computeIfAbsent(from, unused -> new ArrayList<>()).add(new Edge(to, cost));
    }

    public long[] run(int start) {
        long[] score = new long[n];
        Arrays.fill(score, Long.MAX_VALUE);
        score[start] = 0;

        PriorityQueue<Tuple> q = new PriorityQueue<>();
        q.add(new Tuple(start, 0));
        while (!q.isEmpty()) {
            Tuple t = q.remove();
            if (!edges.containsKey(t.current)) continue; // 次がない場合
            if (score[t.current] < t.cost) continue; // cost情報が古い場合

            for (Edge e : edges.get(t.current)) {
                if (t.cost + e.cost < score[e.next]) {
                    score[e.next] = t.cost + e.cost;
                    q.add(new Tuple(e.next, score[e.next]));
                }
            }
        }
        return score;
    }

    private class Edge {
        private int next;
        private long cost;

        public Edge(int next, long cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    private class Tuple implements Comparable<Tuple>{
        private int current;
        private long cost;

        public Tuple(int current, long cost) {
            this.current = current;
            this.cost = cost;
        }

        @Override
        public int compareTo(Tuple other) {
            return Long.compare(this.cost, other.cost);
        }
    }
}
