import java.util.ArrayList;
import java.util.List;

// cf. https://ei1333.github.io/luzhiled/snippets/math/quotient-range.html
// 自然数nの商 floor(n/i) (1<=i<=n) の値の種類数を求める
// 戻り値: // x<=i<=yを満たす整数の商がz個存在する。
public class QuotientRange {
    public static List<QuotientRange> solve(long n) {
        List<QuotientRange> ranges = new ArrayList<>();
        
        long m;
        for (m = 1; m*m <= n; m++) {
            ranges.add(new QuotientRange(m, m, n/m));
        }
        
        for (long i = m; i >= 1; i--) {
            long l = n / (i + 1) + 1;
            long r = n / i;
            if (l <= r && ranges.get(ranges.size()-1).getY() < l) {
                ranges.add(new QuotientRange(l, r, n/l));
            }
        }
        return ranges;
    }
    
    // x<=i<=yを満たす整数の商がz個存在する。
    private long x;
    private long y;
    private long z;
    
    private QuotientRange(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public long getX() {
        return x;
    }
    public long getY() {
        return y;
    }
    public long getZ() {
        return z;
    }
}
