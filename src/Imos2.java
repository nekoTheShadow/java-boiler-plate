    
public class Imos2 {
    private int h;
    private int w;
    private long[][] imos;
    
    public Imos2(int h, int w) {
        this.h = h;
        this.w = w;
        this.imos = new long[h+1][w+1];
    }
    
    // 矩形の左上(lx, ly)、矩形の右下(rx, ry)
    public void add(int lx, int ly, int rx, int ry) {
        imos[lx][ly]++;
        imos[lx][ry+1]--;
        imos[rx+1][ly]--;
        imos[rx+1][ry+1]++;
    }
    
    public long[][] run() {
        for (int i = 0; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                imos[i][j] += imos[i][j-1];
            }
        }
        
        for (int i = 1; i <= h; i++) {
            for (int j = 0; j <= w; j++) {
                imos[i][j] += imos[i-1][j];
            }
        }
        
        return imos;
    }
}
