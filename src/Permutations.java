import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public  class Permutations<T> implements Iterable<List<T>>{
    private List<T> list;
    public Permutations(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new PermutationIterator<>(list);
    }

    private class PermutationIterator<T> implements Iterator<List<T>> {
        private int n;
        private List<T> list;
        private Deque<LinkedHashSet<Integer>> q;
        private List<T> ptr;

        public PermutationIterator(List<T> list) {
            this.n = list.size();
            this.list = list;
            this.q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                LinkedHashSet<Integer> set = new LinkedHashSet<>();
                set.add(i);
                q.add(set);
            }
        }

        @Override
        public boolean hasNext() {
            while (!q.isEmpty()) {
                LinkedHashSet<Integer> set = q.removeFirst();
                if (set.size() == n) {
                    this.ptr = set.stream().map(list::get).collect(Collectors.toList());
                    return true;
                } else {
                    for (int i = 0; i < n; i++) {
                        if (set.contains(i)) continue;
                        LinkedHashSet<Integer> nextSet = new LinkedHashSet<>();
                        nextSet.addAll(set);
                        nextSet.add(i);
                        q.addLast(nextSet);
                    }
                }
            }
            return false;
        }

        @Override
        public List<T> next() {
            return this.ptr;
        }
    }
}
