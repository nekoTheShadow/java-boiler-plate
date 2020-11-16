import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations<T> implements Iterable<List<T>>{
    private List<T> src;
    private int n;

    public Combinations(List<T> src, int n) {
        this.src = src;
        this.n = n;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new CombinationsIterator<>(src, n);
    }

    private class CombinationsIterator<S> implements Iterator<List<S>> {
        private List<S> src;
        private int m;

        private int len;
        private int bit;
        private List<S> ptr;

        public CombinationsIterator(List<S> src, int m) {
            this.src = src;
            this.len = src.size();
            this.m = m;
            this.bit = 0;
        }

        @Override
        public boolean hasNext() {
            while (bit < (1<<len)) {
                if (m<=0 || Integer.bitCount(bit)==m) {
                    this.ptr = new ArrayList<>();
                    for (int i = 0; i < len; i++) {
                        if ((bit&(1<<i))!=0) ptr.add(src.get(i));
                    }
                    bit++;
                    return true;
                } else {
                    bit++;
                }
            }
            return false;
        }

        @Override
        public List<S> next() {
            return this.ptr;
        }
    }
}
