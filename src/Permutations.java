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

    private class PermutationIterator<S> implements Iterator<List<S>> {
        private int n;
        private List<S> list;
        private Deque<LinkedHashSet<Integer>> q;
        private List<S> ptr;

        public PermutationIterator(List<S> list) {
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
        public List<S> next() {
            return this.ptr;
        }
    }
}
