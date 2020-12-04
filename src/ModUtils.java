import java.math.BigInteger;

public class ModUtils {
    public long modPow(long x, long y, long mod) {
        return BigInteger.valueOf(x).modPow(BigInteger.valueOf(y), BigInteger.valueOf(mod)).longValue();
    }

    public long modInv(long x, long mod) {
        return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(mod)).longValue();
    }
}
