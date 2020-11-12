import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testStdin() {
        InputStream is = new ByteArrayInputStream("111 222 333\nABC DEF GHI\r\n444 555\n66.66\r\n-77 -88\n".getBytes());
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

    @Nested
    public class TestStderr {
        ByteArrayOutputStream content;
        Main.Stderr stderr;

        @BeforeEach
        public void setUp() {
            this.content = new ByteArrayOutputStream();
            this.stderr = new Main.Stderr(new PrintStream(content), true);
        }

        @Test
        public void debugモードの場合はデバッグ出力する() {
            stderr.println(1, "2", 3.4);
            assertEquals("DEBUG: 1 2 3.4" + System.lineSeparator(), content.toString());
        }

        @Test
        public void debugモードではない場合は何も出力しない() {
            stderr = new Main.Stderr(new PrintStream(content), false);
            stderr.println(1, "2", 3.4);
            assertTrue(content.size() == 0);
        }

        @Test
        public void _1次元配列をPrettyPrintする() {
            stderr.println(new int[] {1, 2, 3});
            assertEquals("DEBUG: {1, 2, 3}" + System.lineSeparator(), content.toString());
        }

        @Test
        public void _2次元配列をPrettyPrintする() {
            stderr.println(new int[][] {{1, 2}, {3, 4}});
            assertEquals("DEBUG: {{1, 2}, {3, 4}}" + System.lineSeparator(), content.toString());
        }
    }

}
