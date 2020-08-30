import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

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

    @Test
    void primeDivisionは与えられた整数の素因数分解を行う() {
        assertEquals(Map.of(2, 1, 5, 1), MathUtils.primeDivision(10));
        assertEquals(Map.of(2, 2, 3, 1), MathUtils.primeDivision(12));
    }

    @Test
    void gcdは与えられた整数の最大公約数を求める_かつ_引数はどちらが大きくてもよい() {
        assertEquals(21, MathUtils.gcd(1071, 1029));
        assertEquals(21, MathUtils.gcd(1029, 1071));
    }
}
