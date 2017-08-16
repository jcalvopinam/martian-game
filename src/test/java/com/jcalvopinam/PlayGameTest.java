package com.jcalvopinam;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple PlayGame.
 */
public class PlayGameTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlayGameTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PlayGameTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
