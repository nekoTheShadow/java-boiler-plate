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

    public int gcd(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y= tmp;
        }

        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }

        return x;
    }

}
