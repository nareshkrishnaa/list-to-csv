package dev.naresh.listtotree.util;

import dev.naresh.listtotree.internal.Utility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void shouldMatchInclusiveRangeBoundaries() {
        assertTrue(Utility.fitsInRange("[0,4]", 0.0));
        assertTrue(Utility.fitsInRange("[0,4]", 4.0));
        assertTrue(Utility.fitsInRange("[0,4]", 2.5));
    }

    @Test
    void shouldMatchLeftExclusiveRightInclusiveRange() {
        assertFalse(Utility.fitsInRange("(4,10]", 4.0));
        assertTrue(Utility.fitsInRange("(4,10]", 4.1));
        assertTrue(Utility.fitsInRange("(4,10]", 10.0));
        assertFalse(Utility.fitsInRange("(4,10]", 10.1));
    }

    @Test
    void shouldMatchLeftInclusiveRightExclusiveRange() {
        assertTrue(Utility.fitsInRange("[4,10)", 4.0));
        assertTrue(Utility.fitsInRange("[4,10)", 9.99));
        assertFalse(Utility.fitsInRange("[4,10)", 10.0));
    }

    @Test
    void shouldMatchExclusiveRange() {
        assertFalse(Utility.fitsInRange("(4,10)", 4.0));
        assertTrue(Utility.fitsInRange("(4,10)", 5.0));
        assertFalse(Utility.fitsInRange("(4,10)", 10.0));
    }

    @Test
    void shouldReturnFalseWhenInputIsOutsideRange() {
        assertFalse(Utility.fitsInRange("[0,4]", -1.0));
        assertFalse(Utility.fitsInRange("[0,4]", 5.0));
    }

    @Test
    void shouldReturnFalseForNullRange() {
        assertFalse(Utility.fitsInRange(null, 5.0));
    }

}


