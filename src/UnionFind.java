import java.util.Arrays;
import java.util.stream.IntStream;

public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.parent = IntStream.range(0, n).toArray();
        this.size = new int[n];
        Arrays.fill(this.size, 1);
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return ;
        }

        if (size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        } else {
            parent[y] = x;
            size[x] += size[y];
        }

    }

    public int size(int x) {
        return size[find(x)];
    }
}
