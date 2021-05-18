
public class Imos2 {
    private long[][] imos;
    
    public Imos2(int h, int w) {
        this.imos = new long[h+1][w+1];
    }
    
    public void add(int lx, int ly, int rx, int ry) {
        imos[lx][ly]++;
        imos[lx][ry]--;
        imos[rx][ly]--;
        imos[rx][ry]++;
    }
    
    public long[][] run() {
        for (int y = 0; y <= 1000; y++) {
            for (int x = 1; x <= 1000; x++) {
                imos[y][x] += imos[y][x - 1];
            }
        }
        
        for (int y = 1; y <= 1000; y++) {
            for (int x = 0; x <= 1000; x++) {
                imos[y][x] += imos[y - 1][x];
            }
        }
        return imos;
    }
}
