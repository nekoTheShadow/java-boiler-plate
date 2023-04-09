import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tsort {
    private int n;
    private int[] count;
    private List<List<Integer>> nexts;
    private List<Integer> result;
    
    public Tsort(int n) {
        this.n = n;
        this.count = new int[n];
        this.nexts = IntStream.range(0, n).mapToObj(unused -> new ArrayList<Integer>()).collect(Collectors.toList());
        this.result = null;
    }
    
    public void add(int from, int to) {
        this.count[to]++;
        this.nexts.get(from).add(to);
    }
    
    public List<Integer> run() {
        if (result != null) {
            return result;
        }
        
        result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                stack.addFirst(i);
            }
        }
       
        
        while (!stack.isEmpty()) {
            Integer cur = stack.removeFirst();
            result.add(cur);
            for (int nxt : nexts.get(cur)) {
               this.count[nxt]--;
               if (this.count[nxt]==0) {
                   stack.addFirst(nxt);
               }
            }
        }
        return result;
    }
    
    public boolean hasCycle() {
        return run().size() != n;
    }
}
