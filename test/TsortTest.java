import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TsortTest {

    @Test
    void test() {
        // {0=>[1, 2], 1=>[2], 2=>[], 3	=>[]}
        Tsort tsort = new Tsort(4);
        tsort.add(0, 1);
        tsort.add(0, 2);
        tsort.add(1, 2);
        assertIterableEquals(List.of(3, 0, 1, 2), tsort.run());
    }

}
