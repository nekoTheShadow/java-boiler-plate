import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    private List<int[]> intervals;
    
    public MergeInterval() {
        this.intervals = new ArrayList<>();
    }
    
    public void add(int begin, int end) {
        intervals.add(new int[] {begin, end});
    }
    
    public List<int[]> merge() {
        List<int[]> stack = new ArrayList<>();
        int n = -1;
        Collections.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(a -> a[1]));
        for (int[] cur : intervals) {
            if (n == -1 || stack.get(n)[1]+1 < cur[0]) {
                stack.add(cur);
                n++;
            } else {
                stack.get(n)[1] = Math.max(stack.get(n)[1], cur[1]);
            }
        }
        
        intervals = stack;
        return intervals;
    }
}
