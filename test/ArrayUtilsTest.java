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
}
