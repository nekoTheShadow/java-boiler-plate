import static org.junit.jupiter.api.Assertions.*;

import java.util.OptionalLong;

import org.junit.jupiter.api.Test;

/**
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_2_A&lang=ja
 */
class TSPTest {
    @Test
    void _経路が存在する場合() {
        TSP tsp = new TSP(4);
        tsp.add(0, 1, 2);
        tsp.add(1, 2, 3);
        tsp.add(1, 3, 9);
        tsp.add(2, 0, 1);
        tsp.add(2, 3, 6);
        tsp.add(3, 2, 4);;
        assertEquals(OptionalLong.of(16), tsp.run(0));
        assertEquals(OptionalLong.of(16), tsp.run(1));
        assertEquals(OptionalLong.of(16), tsp.run(2));
        assertEquals(OptionalLong.of(16), tsp.run(3));
    }

    @Test
    void _経路が存在しない場合() {
        TSP tsp = new TSP(3);
        tsp.add(0, 1, 1);
        tsp.add(1, 2, 1);
        tsp.add(0, 2, 1);
        assertEquals(OptionalLong.empty(), tsp.run(0));
        assertEquals(OptionalLong.empty(), tsp.run(1));
        assertEquals(OptionalLong.empty(), tsp.run(2));
    }
}
