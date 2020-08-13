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
}
