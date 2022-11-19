import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 凸包を Andrew's Monotone Chain によって求める。O(NlogN)
// cf1. https://ei1333.github.io/algorithm/convex-hull.html
// cf2. https://leetcode.com/problems/erect-the-fence/discuss/103306/C%2B%2B-and-Python-easy-wiki-solution
public class MonotoneChain {
    private List<int[]> points;
    
    public MonotoneChain() {
        points = new ArrayList<>();
    }
    
    public void add(int x, int y) {
        points.add(new int[] {x, y});
    }
    
    public int[][] run() {
        if (points.size() <= 1) {
            return points.toArray(int[][]::new);
        }

        points.sort(Comparator.comparing((int[] p) -> p[0]).thenComparing(p -> p[1]));

        List<int[]> lower = new ArrayList<>();
        for (int[] p : points) {
            while (lower.size()>=2 && cross(lower.get(lower.size()-2), lower.get(lower.size()-1), p)<0) {
                lower.remove(lower.size()-1);
            }
            lower.add(p);
        }
        
        List<int[]> upper = new ArrayList<>();
        Collections.reverse(points);
        for (int[] p : points) {
            while (upper.size()>=2 && cross(upper.get(upper.size()-2), upper.get(upper.size()-1), p)<0) {
                upper.remove(upper.size()-1);
            }
            upper.add(p);
        }
        
        Set<int[]> ans = new HashSet<>();
        for (int i = 0, len = lower.size(); i < len-1; i++) {
            ans.add(lower.get(i));
        }
        for (int i = 0, len = upper.size(); i< len-1; i++) {
            ans.add(upper.get(i));
        }
        return ans.toArray(int[][]::new);
    }
    
    
    private int cross(int[] o, int[] a, int[] b) {
        return (a[0]-o[0])*(b[1]-o[1]) - (a[1]-o[1])*(b[0]-o[0]);
    }
}
