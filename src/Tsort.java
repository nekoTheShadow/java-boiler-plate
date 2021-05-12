import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tsort {
    
    private int[] count;
    private List<List<Integer>> nexts;
    
    public Tsort(int n) {
        this.count = new int[n];
        this.nexts = IntStream.range(0, n).mapToObj(unused -> new ArrayList<Integer>()).collect(Collectors.toList());
    }
    
    public void add(int from, int to) {
        this.count[to]++;
        this.nexts.get(from).add(to);
    }
    
    public List<Integer> run() {
        Deque<Integer> queue = IntStream.range(0, this.count.length)
                                        .filter(i -> count[i]==0)
                                        .boxed()
                                        .collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            Integer cur = queue.removeFirst();
            result.add(cur);
            for (int nxt : nexts.get(cur)) {
               this.count[nxt]--;
               if (this.count[nxt]==0) {
                   queue.add(nxt);
               }
            }
        }
        return result;
    }
}
