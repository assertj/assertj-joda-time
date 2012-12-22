package org.fest.assertions.api;

import static org.junit.Assume.assumeTrue;

import org.joda.time.DateTime;
import org.junit.experimental.theories.DataPoint;

/**
 * 
 * Base test class for {@link DateTimeAssert} tests.
 * 
 * @author Joel Costigliola
 * 
 */
public class DateTimeAssertBaseTest extends JodaTimeBaseTest {

  @DataPoint
  public static DateTime dateTime1 = new DateTime(2000, 12, 14, 0, 0);
  @DataPoint
  public static DateTime dateTime2 = new DateTime(2000, 12, 13, 23, 59, 59, 999);
  @DataPoint
  public static DateTime dateTime3 = new DateTime(2000, 12, 14, 0, 0, 0, 1);
  @DataPoint
  public static DateTime dateTime4 = new DateTime(2000, 12, 14, 22, 15, 15, 875);
  @DataPoint
  public static DateTime dateTime5 = new DateTime(2000, 12, 14, 22, 15, 15, 874);
  @DataPoint
  public static DateTime dateTime6 = new DateTime(2000, 12, 14, 22, 15, 15, 876);

  protected static void testAssumptions(DateTime reference, DateTime dateBefore, DateTime dateAfter) {
    assumeTrue(dateBefore.isBefore(reference));
    assumeTrue(dateAfter.isAfter(reference));
  }

  /**
   * give acces to actual instance under test to perform some checks
   */
  protected DateTime getActual(DateTimeAssert assertion) {
    return assertion.actual;
  }

}