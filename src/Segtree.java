import java.util.Arrays;
import java.util.function.LongBinaryOperator;

/**
 * https://tsutaj.hatenablog.com/entry/2017/03/29/204841
 * https://atcoder.github.io/ac-library/document_ja/segtree.html
 */
public class Segtree {
    private long[] node;
    private int n;
    private LongBinaryOperator op;
    private long e;


    public Segtree(int size, LongBinaryOperator op, long e) {
        this.n = 1;
        while (this.n < size) this.n *= 2;

        this.node = new long[2*this.n-1];
        Arrays.fill(this.node, e);
        this.op = op;
        this.e = e;
    }

    public void update(int x, long v) {
        x += (n - 1);
        node[x] = v;
        while(x > 0) {
            x = (x - 1) / 2;
            node[x] = op.applyAsLong(node[2*x+1], node[2*x+2]);
        }
    }

    // 要求区間 [a, b) 中の要素の最小値を答える
    public long get(int a, int b) {
        return get(a, b, 0, 0, n);
    }

    private long get(int a, int b, int k, int l, int r) {
        if(r <= a || b <= l) return e;
        if(a <= l && r <= b) return node[k];

        long vl = get(a, b, 2*k+1, l, (l+r)/2);
        long vr = get(a, b, 2*k+2, (l+r)/2, r);
        return op.applyAsLong(vl, vr);
    }
}
