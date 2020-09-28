import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SegtreeTest {
    @Test
    void test() {
        // https://judge.yosupo.jp/problem/staticrmq

        Segtree segtree = new Segtree(4, Long::min, Long.MAX_VALUE);
        segtree.update(0, 2);
        segtree.update(1, 10);
        segtree.update(2, 1);
        segtree.update(3, 100);

        int[][] tt = new int[][]{
            {0, 1, 2},
            {0, 2, 2},
            {0, 3, 1},
            {0, 4, 1},
            {1, 2, 10},
            {1, 3, 1},
            {1, 4, 1},
            {2, 3, 1},
            {2, 4, 1},
            {3, 4, 100}
        };
        for (int[] t : tt) {
            int l = t[0];
            int r = t[1];
            long expected = t[2];
            assertEquals(expected, segtree.get(l, r));
        }
    }
}
