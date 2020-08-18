
public class MathUtils {
    private MathUtils() {}

    public static long modPow(long x, long y, long mod) {
        long z = 1;
        while (y > 0) {
            if (y % 2 == 0) {
                x = (x * x) % mod;
                y /= 2;
            } else {
                z = (z * x) % mod;
                y--;
            }
        }
        return z;
    }

    public static long modInv(long x, long mod) {
        return modPow(x, mod - 2, mod);
    }

    public static long pow(long x, long y) {
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
}
