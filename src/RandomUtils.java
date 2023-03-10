import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    // https://sucrose.hatenablog.com/entry/2014/01/11/004615
    // iteratorからk個の要素をランダムに取り出す。
    public <E> List<E> reservoirSample(Random random, Iterator<E> iterator, int k) {
        int n = 0;
        List<E> list = new ArrayList<>();
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (n < k) {
                list.add(e);
            } else {
                int i = random.nextInt(n+1);
                if (i < k) {
                    list.set(i, e);
                }
            }
            n++;
        }
        return list;
    }
}
