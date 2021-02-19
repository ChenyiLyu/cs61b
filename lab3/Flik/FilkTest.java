import org.junit.Test;

import static org.junit.Assert.*;

public class FilkTest {

    @Test
    public void testIsSameNumber() {
        int a = 128; int b = 10; int c = 128;
        int d = 129; int e = 129;
        int f = 127; int g = 127;
        assertTrue(Flik.isSameNumber(f, g));
        assertTrue(Flik.isSameNumber(a, c));
        assertTrue(Flik.isSameNumber(d, e));
        assertFalse(Flik.isSameNumber(a, b));

    }
}
// bug在flik lib里
