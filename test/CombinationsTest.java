import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class CombinationsTest {

    @Test
    void mが1以上の場合はsrcからm個選んだ組み合わせ一覧を生成する() {
        Set<List<String>> combinations = new HashSet<>();
        for (List<String> strs : new Combinations<>(List.of("A", "B", "C", "D", "E"), 3)) combinations.add(strs);
        assertEquals(10, combinations.size());
        assertTrue(combinations.contains(List.of("A","B","C")));
        assertTrue(combinations.contains(List.of("A","B","D")));
        assertTrue(combinations.contains(List.of("A","B","E")));
        assertTrue(combinations.contains(List.of("A","C","D")));
        assertTrue(combinations.contains(List.of("A","C","E")));
        assertTrue(combinations.contains(List.of("A","D","E")));
        assertTrue(combinations.contains(List.of("B","C","D")));
        assertTrue(combinations.contains(List.of("B","C","E")));
        assertTrue(combinations.contains(List.of("B","D","E")));
        assertTrue(combinations.contains(List.of("C","D","E")));
    }


    @Test
    void mが0以下の場合はすべて組み合わせ一覧を生成する() {
        Set<List<String>> combinations = new HashSet<>();
        for (List<String> strs : new Combinations<>(List.of("A", "B", "C"), -1)) combinations.add(strs);
        assertEquals(8, combinations.size());
        assertTrue(combinations.contains(List.of()));
        assertTrue(combinations.contains(List.of("A")));
        assertTrue(combinations.contains(List.of("B")));
        assertTrue(combinations.contains(List.of("C")));
        assertTrue(combinations.contains(List.of("A","B")));
        assertTrue(combinations.contains(List.of("A","C")));
        assertTrue(combinations.contains(List.of("B","C")));
        assertTrue(combinations.contains(List.of("A", "B","C")));
    }
}
