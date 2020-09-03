
/**
 * 数列a1, a2, ... anについて
 * - add(i, x) - aiにxを加算
 * - sum(i)    - a1..aiの合計を取得
 */
public class BIT {

    private int n;
    private int[] tree;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n+1];
    }

    public int sum(int i) {
        int s = 0;
        while (i > 0) {
            s += this.tree[i];
            i -= i & -i;
        }
        return s;
    }

    public void add(int i, int x) {
        while (i <= this.n) {
            this.tree[i] += x;
            i += i & -i;
        }
    }
}
