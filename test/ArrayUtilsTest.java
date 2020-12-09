import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayUtilsTest {
    private ArrayUtils arrayUtils = new ArrayUtils();

    @Test
    void bisectLeftは二分探索でもっとも左側の挿入点を探す() {
        assertEquals(2, arrayUtils.bisectLeft(new int[] {111, 222, 333, 333, 333, 444, 555}, 333));
        assertEquals(2, arrayUtils.bisectLeft(Arrays.asList(111, 222, 333, 333, 333, 444, 555), 333));
    }

    @Test
    void bisectRightは二分探索でもっとも右側の挿入点を探す() {
        assertEquals(5, arrayUtils.bisectRight(new int[] {111, 222, 333, 333, 333, 444, 555}, 333));
        assertEquals(5, arrayUtils.bisectRight(Arrays.asList(111, 222, 333, 333, 333, 444, 555), 333));
    }

    @Test
    void sortは配列をマージソートする() {
        long[] a = new long[] {2, 3, 1, 4};
        int[] b = new int[] {3, 1, 6, 7, 9, 5, 8, 4, 2};
        arrayUtils.sort(a);
        arrayUtils.sort(b);
        assertTrue(Arrays.equals(new long[] {1, 2, 3, 4}, a));
        assertTrue(Arrays.equals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, b));
    }
}
