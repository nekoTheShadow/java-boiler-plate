import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {
    public void reverse(int[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            int t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public void reverse(long[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            long t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public <T> void reverse(T[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            T t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public int bisectLeft(int[] a, int x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a[mi] >= x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public int bisectRight(int[] a, int x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a[mi] > x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public int bisectLeft(long[] a, long x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a[mi] >= x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public int bisectRight(long[] a, long x) {
        int ng = -1;
        int ok = a.length;
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a[mi] > x) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public <T> int bisectLeft(List<? extends Comparable<? super T>> a, T x) {
        int ng = -1;
        int ok = a.size();
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a.get(mi).compareTo(x) >= 0) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public <T> int bisectRight(List<? extends Comparable<? super T>> a, T x) {
        int ng = -1;
        int ok = a.size();
        while (Math.abs(ok-ng) > 1) {
            int mi = (ok+ng)/2;
            if (a.get(mi).compareTo(x) > 0) {
                ok = mi;
            } else {
                ng = mi;
            }
        }
        return ok;
    }

    public String join(int[] a, String delimiter) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }

    public String join(long[] a, String delimiter) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }

    public int max(int[] a) {
        return Arrays.stream(a).max().getAsInt();
    }

    public long max(long[] a) {
        return Arrays.stream(a).max().getAsLong();
    }

    public int min(int[] a) {
        return Arrays.stream(a).min().getAsInt();
    }

    public long min(long[] a) {
        return Arrays.stream(a).min().getAsLong();
    }
}
