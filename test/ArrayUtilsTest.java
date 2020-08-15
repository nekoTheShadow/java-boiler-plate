import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    @Test
    void bisectLeftは二分探索でもっとも左側の挿入点を探す() {
        assertEquals(2, ArrayUtils.bisectLeft(new int[] {111, 222, 333, 333, 333, 444, 555}, 333));
        assertEquals(2, ArrayUtils.bisectLeft(Arrays.asList(111, 222, 333, 333, 333, 444, 555), 333));
    }

    @Test
    void bisectRightは二分探索でもっとも右側の挿入点を探す() {
        assertEquals(5, ArrayUtils.bisectRight(new int[] {111, 222, 333, 333, 333, 444, 555}, 333));
        assertEquals(5, ArrayUtils.bisectRight(Arrays.asList(111, 222, 333, 333, 333, 444, 555), 333));
    }
}
