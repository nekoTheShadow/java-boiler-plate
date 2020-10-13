import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {
    private ArrayUtils() {}

    public static void reverse(int[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            int t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public static void reverse(long[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            long t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public static <T> void reverse(T[] a) {
        for (int i = 0, n = a.length; i < n/2; i++) {
            T t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
    }

    public static int bisectLeft(int[] a, int x) {
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

    public static int bisectRight(int[] a, int x) {
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

    public static int bisectLeft(long[] a, long x) {
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

    public static int bisectRight(long[] a, long x) {
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

    public static <T> int bisectLeft(List<? extends Comparable<? super T>> a, T x) {
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

    public static <T> int bisectRight(List<? extends Comparable<? super T>> a, T x) {
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

    public static String join(int[] a, String delimiter) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }

    public static String join(long[] a, String delimiter) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }
}
