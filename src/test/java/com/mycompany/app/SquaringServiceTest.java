package com.mycompany.app;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SquaringServiceTest {

    private final SquaringService service = new SquaringService();

    @Test
    public void test() {
        commonTest(Arrays.asList(-3, -2, -1, 0, 1, 2, 3), "[0, 1, 1, 4, 4, 9, 9]");
        commonTest(Arrays.asList(0, 1, 2, 3), "[0, 1, 4, 9]");
        commonTest(Arrays.asList(-3, -2, -1, 0), "[0, 1, 4, 9]");
        commonTest(Arrays.asList(-3, -2, -1), "[1, 4, 9]");
        commonTest(Arrays.asList(1, 2, 3), "[1, 4, 9]");
    }

    private void commonTest(final List<Integer> soars, final String expectedString) {
        List<Integer> result = service.squaring(soars);
        assertNotNull(result);
        assertEquals(expectedString, result.toString());
    }
}
