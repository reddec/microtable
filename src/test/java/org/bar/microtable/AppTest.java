package org.bar.microtable;

import java.util.LinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testApp() {
        Table<String> t1 = new Table<String>();
        t1.addColumns(8);
        t1.addRow("=");
        t1.addRows(8, ".");
        t1.setCell(4, 3, "*");
        t1.setCell(4, 4, "+");
        t1.setCell(4, 5, "*");
        t1.setCell(3, 4, "@");
        t1.setCell(5, 4, "@");
        t1.addRow("=");
        System.out.println(t1.toString());
        t1.moveRow(9, 8);
        System.out.println(t1.toString());
        t1 = t1.rotateTable();
        System.out.println(t1.toString());
        //Check error handling
        assertFalse(t1.setCell(1000, 1000, null));
        assertFalse(t1.setCell(1000, 1, null));
        assertFalse(t1.setCell(-1, -1, null));
        assertFalse(t1.setCell(-1, 0, null));
        assertFalse(t1.setCell(0, -1, null));

        assertEquals(-1, t1.attachColumn(new LinkedList<String>()));
        assertEquals(-1, t1.attachColumn(new LinkedList<String>()));

        assertNull(t1.getCell(10000, 1000));

        assertEquals("+", t1.getCell(4, 4));

    }
}
