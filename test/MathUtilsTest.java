import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MathUtilsTest {
    private MathUtils mathUtils = new MathUtils();

    @Test
    void primeDivisionは与えられた整数の素因数分解を行う() {
        Map<Long, Long> actual = mathUtils.primeDivision(12);
        assertEquals(2, actual.size());
        assertEquals(2, actual.get(2L));
        assertEquals(1, actual.get(3L));
    }

    @Test
    void gcdは与えられた整数の最大公約数を求める_かつ_引数はどちらが大きくてもよい() {
        assertEquals(21, mathUtils.gcd(1071, 1029));
        assertEquals(21, mathUtils.gcd(1029, 1071));
    }
    
    @Test
    void digitsは各桁の数値を配列で返します() {
        assertEquals(List.of(0), mathUtils.digits(0));
        assertEquals(List.of(9, 0, 1, 2, 3), mathUtils.digits(90123));
        assertEquals(List.of(0L), mathUtils.digits(0L));
        assertEquals(List.of(9L, 0L, 1L, 2L, 3L), mathUtils.digits(90123L));
    }
}
