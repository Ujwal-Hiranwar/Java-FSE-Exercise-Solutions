package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);
        // Assert true
        assertTrue(5 > 3);
        // Assert false
        assertFalse(5 < 3);
        // Assert null
        assertNull(null);
        // Assert not null
        assertNotNull(new Object());
        // Assert same reference
        Object ref = new Object();
        assertSame(ref, ref);
        // Assert not same reference
        assertNotSame(new Object(), new Object());

    }
  
}