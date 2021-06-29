
    public class KruskalEdge {
        private int x;
        private int y;
        private long weight;
        
        public KruskalEdge(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
 
        public int getX() {
            return x;
        }
 
        public int getY() {
            return y;
        }
 
        public long getWeight() {
            return weight;
        }
    }