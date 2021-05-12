import java.util.HashMap;
import java.util.Map;

public class MathUtils {
    public long pow(long x, long y) {
        long z = 1;
        while (y > 0) {
            if (y % 2 == 0) {
                x = (x * x);
                y /= 2;
            } else {
                z = (z * x);
                y--;
            }
        }
        return z;
    }

    public Map<Integer, Integer> primeDivision(int n) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int k = 2; k*k <= n; k++) {
            while (n % k == 0) {
                d.put(k, d.getOrDefault(k, 0) + 1);
                n  /= k;
            }
        }

        if (n > 1) {
            d.put(n, d.getOrDefault(n, 0) + 1);
        }

        return d;
    }

    public long gcd(long x, long y) {
        if (x < y) {
            long tmp = x;
            x = y;
            y= tmp;
        }

        while (y > 0) {
            long mod = x % y;
            x = y;
            y = mod;
        }

        return x;
    }

    public long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }

    public long ceilDiv(long x, long y) {
        if (x%y == 0) {
            return x/y;
        } else {
            return x/y + 1;
        }
    }
    
    /**
     * 度数法からラジアンに変換します。
     * @param a 度数法
     * @return ラジアン
     */
    public double rad(double a) {
        return Math.PI * a / 180;
    }
    
    /**
     * ラジアンから度数法に変換します。
     * @param b ラジアン
     * @return 度数法
     */
    public double deg(double b) {
        return b * 180 / Math.PI;
    }
}
