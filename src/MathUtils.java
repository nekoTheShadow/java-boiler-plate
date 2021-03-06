import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    public Map<Long, Long> primeDivision(long n) {
        Map<Long, Long> d = new HashMap<>();
        for (long k = 2; k*k <= n; k++) {
            while (n % k == 0) {
                d.put(k, d.getOrDefault(k, 0L) + 1);
                n  /= k;
            }
        }

        if (n > 1) {
            d.put(n, d.getOrDefault(n, 0L) + 1);
        }

        return d;
    }
    
    public int[] primes(int n) {
        boolean[] isprime = new boolean[n+1];
        Arrays.fill(isprime, true);
        isprime[0] = isprime[1] = false;
        for (int i = 2; i*i <= n; i++) {
            if (!isprime[i]) continue;
            for (int j = i * 2; j <= n; j+=i) isprime[j] = false;
        }
        
        return IntStream.rangeClosed(2, n).filter(i -> isprime[i]).toArray();
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
    
    public BigInteger gcd(BigInteger x, BigInteger y) {
        if (x.compareTo(y) < 0) {
            BigInteger tmp = x;
            x = y;
            y= tmp;
        }

        while (y.compareTo(BigInteger.ZERO) > 0) {
            BigInteger mod = x.mod(y);
            x = y;
            y = mod;
        }

        return x;
    }

    public BigInteger lcm(BigInteger x, BigInteger y) {
        return x.multiply(y).divide(gcd(x, y));
    }
    
    
    public List<Long> digits(long x) {
        if (x==0) return List.of(0L);

        List<Long> a = new ArrayList<>();
        while (x > 0) {
            a.add(x%10);
            x/=10;
        }
        
        Collections.reverse(a);
        return a;
    }
    
    public List<Integer> digits(int x) {
        if (x==0) return List.of(0);

        List<Integer> a = new ArrayList<>();
        while (x > 0) {
            a.add(x%10);
            x/=10;
        }
        
        Collections.reverse(a);
        return a;
    }
}
