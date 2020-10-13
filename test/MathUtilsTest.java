import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class MathUtilsTest {
    private MathUtils mathUtils = new MathUtils();

    @Test
    void primeDivisionは与えられた整数の素因数分解を行う() {
        assertEquals(Map.of(2, 1, 5, 1), mathUtils.primeDivision(10));
        assertEquals(Map.of(2, 2, 3, 1), mathUtils.primeDivision(12));
    }

    @Test
    void gcdは与えられた整数の最大公約数を求める_かつ_引数はどちらが大きくてもよい() {
        assertEquals(21, mathUtils.gcd(1071, 1029));
        assertEquals(21, mathUtils.gcd(1029, 1071));
    }
}
