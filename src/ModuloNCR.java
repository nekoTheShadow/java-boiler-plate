import java.math.BigInteger;

// 二項係数 nCr
// https://qiita.com/drken/items/3b4fdf0a78e7a138cd9a#5-%E4%BA%8C%E9%A0%85%E4%BF%82%E6%95%B0-ncr
public class ModuloNCR {
    private long[] f;
    private long[] g;
    private long mod;
    
    public ModuloNCR(int n, long mod) {
        this.mod = mod;
        
        f = new long[n+1];
        g = new long[n+1];
        f[0] = f[1] = 1;
        g[0] = g[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1]*i%mod;
            g[i] = BigInteger.valueOf(f[i]).modInverse(BigInteger.valueOf(mod)).longValue();
        }
    }
    
    public long nCr(int n, int r) {
        return f[n]*(g[r]*g[n-r]%mod)%mod;
    }
}
