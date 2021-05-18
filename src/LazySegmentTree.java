import java.util.Arrays;
import java.util.function.LongBinaryOperator;


/**
 * https://qiita.com/ageprocpp/items/9ea58ac181d31cfdfe02
 *
 */
public class LazySegmentTree {
    
    private int n;
    private LongBinaryOperator op;
    private long e;
    private long[] node;
    private long[] lazy;
    private boolean[] flag;
    
    public LazySegmentTree(int size, LongBinaryOperator op, long e) {
        this.op = op;
        this.e = e;
        
        this.n = 1;
        while (this.n < size) this.n *= 2;

        this.node = new long[2*this.n-1];
        this.lazy = new long[2*this.n-1];
        this.flag = new boolean[2*this.n-1];
        Arrays.fill(this.node, this.e);
        Arrays.fill(this.lazy, this.e);
    }
    
    public void update(int a, int b, long x) {
        update(a, b, x, 0, 0, n);
    }
    
    private void update(int a, int b, long x, int k, int l, int r) {
        eval(k, l, r);
        if(r<=a || b<=l)return;
        if(a<=l && r<=b){
            flag[k] = true;
            lazy[k] = x;
            eval(k, l, r);
        } else {
            update(a, b, x, 2*k+1, l, (l+r)/2);
            update(a, b, x, 2*k+2, (l+r)/2, r);
            node[k] = op.applyAsLong(node[2*k+1],node[2*k+2]);
        }
    }
    
    public long get(int a, int b) {
        return get(a, b, 0, 0, n);
    }
    
    private long get(int a, int b, int k, int l, int r) {
        eval(k, l, r);
        if(r<=a || b<=l) return e;
        if(a<=l && r<=b) return node[k];
        long vl = get(a, b, 2*k+1, l, (l+r)/2);
        long vr = get(a, b, 2*k+2, (l+r)/2, r);
        return op.applyAsLong(vl, vr);
    }
    
    
    private void eval(int k, int l, int r) {
        if (!flag[k]) return;
        
        node[k] = lazy[k];
        if(l+1 < r){
            lazy[2*k+1] = lazy[2*k+2] = lazy[k];
            flag[2*k+1] = flag[2*k+2] = true;
        }
        flag[k] = false;
    }
}
