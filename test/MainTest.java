import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;

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
    public void testStdout() {
        ByteArrayOutputStream content = new ByteArrayOutputStream();
        Main.Stdout stdout = new Main.Stdout(new PrintStream(content));
        stdout.println(1, "2", 3.4);
        assertTrue(content.size() == 0, "Flushするまでは出力しない");
        stdout.flush();
        assertEquals("1 2 3.4" + System.lineSeparator(), content.toString());
    }
}
