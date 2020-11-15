import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PermutationsTest {

    @Test
    void Permutationsは順列を生成する() {
        Set<List<String>> perms = new HashSet<>();
        for (List<String> perm : new Permutations<>(List.of("A", "B", "C"))) {
            perms.add(perm);
        }

        assertEquals(6, perms.size());
        assertTrue(perms.contains(List.of("A", "B", "C")));
        assertTrue(perms.contains(List.of("A", "C", "B")));
        assertTrue(perms.contains(List.of("B", "A", "C")));
        assertTrue(perms.contains(List.of("B", "C", "A")));
        assertTrue(perms.contains(List.of("C", "A", "B")));
        assertTrue(perms.contains(List.of("C", "B", "A")));
    }

}
