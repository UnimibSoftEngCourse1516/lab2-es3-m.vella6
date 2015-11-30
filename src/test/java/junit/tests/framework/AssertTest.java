package junit.tests.framework;

import junit.framework.AssertionFailedError;
import junit.framework.ComparisonFailure;
import junit.framework.TestCase;

public class AssertTest extends TestCase {

    /* In the tests that follow, we can't use standard formatting
      * for exception tests:
      *     try {
      *         somethingThatShouldThrow();
      *         fail();
      *     catch (AssertionFailedError e) {
      *     }
      * because fail() would never be reported.
      */
    
  //NullPointerException - if an argument is null and this comparator does not permit null arguments
    //ClassCastException - if the arguments' types prevent them from being compared by this comparator(VEDERE SE IMPLEMENTARE)
    
    public <T> void assertGreaterThanTest1(T o1, T o2, java.util.Comparator<T> comparator) throws NullPointerException, ClassCastException{
       
        try {
            comparator.compare(null, o2);
            fail("eccezione non lanciata");
        } catch (NullPointerException e){
            //eccezione lanciata
            assertTrue(true);
        }
        
    }
    
    public <T> void assertGreaterThanTest2(T o1, T o2, java.util.Comparator<T> comparator) throws NullPointerException, ClassCastException{
        
        try {
            comparator.compare(o1, null);
            fail("eccezione non lanciata");
        } catch (NullPointerException e){
            //eccezione lanciata
            assertTrue(true);
        }
        
    }
    
    public <T> void assertGreaterThanTest3(T o1, T o2, java.util.Comparator<T> comparator) throws NullPointerException, ClassCastException{
        
        try {
            comparator.compare(null, null);
            fail("eccezione non lanciata");
        } catch (NullPointerException e){
            //eccezione lanciata
            assertTrue(true);
        }
        
    }
    
    public void testFail() {
        // Also, we are testing fail, so we can't rely on fail() working.
        // We have to throw the exception manually.
        try {
            fail();
        } catch (AssertionFailedError e) {
            return;
        }
        throw new AssertionFailedError();
    }

    public void testAssertionFailedErrorToStringWithNoMessage() {
        // Also, we are testing fail, so we can't rely on fail() working.
        // We have to throw the exception manually.
        try {
            fail();
        } catch (AssertionFailedError e) {
            assertEquals("junit.framework.AssertionFailedError", e.toString());
            return;
        }
        throw new AssertionFailedError();
    }

    public void testAssertionFailedErrorToStringWithMessage() {
        // Also, we are testing fail, so we can't rely on fail() working.
        // We have to throw the exception manually.
        try {
            fail("woops!");
        } catch (AssertionFailedError e) {
            assertEquals("junit.framework.AssertionFailedError: woops!", e.toString());
            return;
        }
        throw new AssertionFailedError();
    }

    public void testAssertEquals() {
        Object o = new Object();
        assertEquals(o, o);
        try {
            assertEquals(new Object(), new Object());
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertEqualsNull() {
        assertEquals((Object) null, (Object) null);
    }

    public void testAssertStringEquals() {
        assertEquals("a", "a");
    }

    public void testAssertNullNotEqualsString() {
        try {
            assertEquals(null, "foo");
            fail();
        } catch (ComparisonFailure e) {
        }
    }

    public void testAssertStringNotEqualsNull() {
        try {
            assertEquals("foo", null);
            fail();
        } catch (ComparisonFailure e) {
            e.getMessage(); // why no assertion?
        }
    }

    public void testAssertNullNotEqualsNull() {
        try {
            assertEquals(null, new Object());
        } catch (AssertionFailedError e) {
            e.getMessage(); // why no assertion?
            return;
        }
        fail();
    }

    public void testAssertNull() {
        assertNull(null);
        try {
            assertNull(new Object());
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertNotNull() {
        assertNotNull(new Object());
        try {
            assertNotNull(null);
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertTrue() {
        assertTrue(true);
        try {
            assertTrue(false);
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertFalse() {
        assertFalse(false);
        try {
            assertFalse(true);
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertSame() {
        Object o = new Object();
        assertSame(o, o);
        try {
            assertSame(new Integer(1), new Integer(1));
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertNotSame() {
        assertNotSame(new Integer(1), null);
        assertNotSame(null, new Integer(1));
        assertNotSame(new Integer(1), new Integer(1));
        try {
            Integer obj = new Integer(1);
            assertNotSame(obj, obj);
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }

    public void testAssertNotSameFailsNull() {
        try {
            assertNotSame(null, null);
        } catch (AssertionFailedError e) {
            return;
        }
        fail();
    }
}