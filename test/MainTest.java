import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testStdin() {
        InputStream is = new ByteArrayInputStream("111 222 333\nABC DEF GHI\r\n444 555\n66.66\r\n-77 -88\n日本語 𩸽".getBytes());
        Main.Stdin stdin = new Main.Stdin(is);
        assertEquals(111, stdin.nextInt());
        assertEquals(222, stdin.nextInt());
        assertEquals(333, stdin.nextInt());
        assertEquals("ABC", stdin.nextString());
        assertEquals("DEF", stdin.nextString());
        assertEquals("GHI", stdin.nextString());
        assertEquals(444, stdin.nextLong());
        assertEquals(555, stdin.nextLong());
        assertEquals(66.66, stdin.nextDouble());
        assertEquals(-77, stdin.nextInt());
        assertEquals(-88, stdin.nextInt());
        assertEquals("日本語", stdin.nextString());
        assertEquals("𩸽", stdin.nextString());
    }
}
