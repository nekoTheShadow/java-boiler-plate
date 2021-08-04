import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtils {
    public int[][] rotateClockWise(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[n-1-j][i];
            }
        }
        return b;
    }

    public long[][] rotateClockWise(long[][] a) {
        int n = a.length;
        int m = a[0].length;

        long[][] b = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[n-1-j][i];
            }
        }
        return b;
    }

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

    public void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[x] = tmp;
    }

    public void swap(long[] a, int x, int y) {
        long tmp = a[x];
        a[x] = a[y];
        a[x] = tmp;
    }

    public void sort(int[] a) {
        int len = a.length;
        if (len < 2) {
            return ;
        }

        int[] a1 = Arrays.copyOfRange(a, 0, len/2);
        int[] a2 = Arrays.copyOfRange(a, len/2, len);
        sort(a1);
        sort(a2);

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (p2==a2.length || (p1<a1.length && a1[p1]<=a2[p2])) {
                a[i] = a1[p1++];
            } else {
                a[i] = a2[p2++];
            }
        }
    }

    public void sort(long[] a) {
        int len = a.length;
        if (len < 2) {
            return ;
        }

        long[] a1 = Arrays.copyOfRange(a, 0, len/2);
        long[] a2 = Arrays.copyOfRange(a, len/2, len);
        sort(a1);
        sort(a2);

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (p2==a2.length || (p1<a1.length && a1[p1]<=a2[p2])) {
                a[i] = a1[p1++];
            } else {
                a[i] = a2[p2++];
            }
        }
    }

    public long[] lis(long[] a) {
        int n = a.length;
        List<Long> b = new ArrayList<>();
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            int x = bisectLeft(b, a[i]);
            if (b.size() == x) {
                b.add(a[i]);
            } else {
                b.set(x, a[i]);
            }
            c[i] = x+1;
        }
        return c;
    }

}
