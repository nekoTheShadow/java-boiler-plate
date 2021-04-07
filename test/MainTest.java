import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testStdin() {
        InputStream is = new ByteArrayInputStream("111 222 333\nABC DEF GHI\r\n444 555\n66.66\r\n-77 -88\n99999999999999999999999999".getBytes());
        Main.Stdin stdin = new Main.Stdin(is);
        assertEquals(111, stdin.nextInt());
        assertEquals(222, stdin.nextInt());
        assertEquals(333, stdin.nextInt());
        assertEquals("ABC", stdin.nextString());
        assertEquals("DEF", stdin.nextString());
        assertEquals("GHI", stdin.nextString());
        assertEquals(444, stdin.nextLong());
        assertEquals(555, stdin.nextLong());
        assertEquals(66.66, stdin.nextDouble(), 0.0);
        assertEquals(-77, stdin.nextInt());
        assertEquals(-88, stdin.nextInt());
        assertEquals(new BigInteger("99999999999999999999999999"), stdin.nextBigInteger());
    }
    
    @Test
    public void testArrayStdin() {
        InputStream is = new ByteArrayInputStream("1 2 3 4 5 6 A B C 7 8 9".getBytes());
        Main.Stdin stdin = new Main.Stdin(is);
        assertArrayEquals(new int[] {1, 2, 3}, stdin.nextIntArray(3));
        assertArrayEquals(new long[] {4, 5, 6}, stdin.nextLongArray(3));
        assertArrayEquals(new String[] {"A", "B", "C"}, stdin.nextStringArray(3));
        assertArrayEquals(new BigInteger[] {BigInteger.valueOf(7), BigInteger.valueOf(8), BigInteger.valueOf(9)}, stdin.nexBigIntegerArray(3));
    }

    @Test
    public void testListStdin() {
        InputStream is = new ByteArrayInputStream("1 2 3 4 5 6 A B C 7 8 9 1.1 1.2 1.3".getBytes());
        Main.Stdin stdin = new Main.Stdin(is);
        assertEquals(new ArrayList<>(List.of(1, 2, 3)), stdin.nextIntegerList(3));
        assertEquals(new ArrayList<>(List.of(4L, 5L, 6L)), stdin.nextLongList(3));
        assertEquals(new ArrayList<>(List.of("A", "B", "C")), stdin.nextStringList(3));
        assertEquals(new ArrayList<>(List.of(BigInteger.valueOf(7), BigInteger.valueOf(8), BigInteger.valueOf(9))), stdin.nextBigIntegerList(3));
        assertEquals(new ArrayList<>(List.of(1.1, 1.2, 1.3)), stdin.nextDoubleList(3));
    }
    
    @Test
    public void testStdout() {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        Main.Stdout stdout = new Main.Stdout(new PrintStream(content));
        stdout.println(1, "2", 3.4);
        assertTrue(content.size() == 0, "Flushするまでは出力しない");
        stdout.flush();
        assertEquals("1 2 3.4" + System.lineSeparator(), content.toString());
    }
}
