import java.util.Objects;

public class Pair<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<Pair<A, B>> {
    private A a;
    private B b;

    private Pair(A a, B b) {
        this.a = Objects.requireNonNull(a);
        this.b = Objects.requireNonNull(b);;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair<?, ?>) {
            Pair<?, ?> other = (Pair<?, ?>)obj;
            return Objects.equals(this.getA(), other.getA()) && Objects.equals(this.getB(), other.getB());
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Pair [a=%s, b=%s]", a, b);
    }

    @Override
    public int compareTo(Pair<A, B> other) {
        int c1 = this.getA().compareTo(other.getA());
        if (c1 == 0) {
            return this.getB().compareTo(other.getB());
        } else {
            return c1;
        }
    }

}