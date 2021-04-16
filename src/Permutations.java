import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://flex.phys.tohoku.ac.jp/~maru/implementations/next_permutation.php
public  class Permutations<T> implements Iterable<List<T>>{
    private List<T> list;
    public Permutations(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new PermutationIterator<>(list);
    }

    private class PermutationIterator<S> implements Iterator<List<S>> {
        private List<S> list;
        private int[] a;
        private int n;

        public PermutationIterator(List<S> list) {
            this.list = list;
            this.n = list.size();
        }
  
        @Override
        public boolean hasNext() {
            if (a==null) {
                this.a = IntStream.range(0, n).toArray();
                return true;
            }
            
            int i = n - 1;
            while (i-1 >= 0 && a[i-1] > a[i]) i--;
            if (i==0) return false;
            
            int j = i;
            while (j+1 < n && a[i-1] < a[j+1]) j++;
            
            swap(i-1, j);
            
            int s = i;
            int t = n-1;
            while (s < t) swap(s++, t--);
            
            return true;
        }
        
        private void swap(int x, int y) {
            int tmp = a[x];
            a[x] = a[y];
            a[y] = tmp;
        }

        @Override
        public List<S> next() {
            return Arrays.stream(a).mapToObj(i -> list.get(i)).collect(Collectors.toList());
        }
    }
}
