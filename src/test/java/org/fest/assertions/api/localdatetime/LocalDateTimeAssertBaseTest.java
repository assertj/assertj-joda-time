package org.fest.assertions.api.localdatetime;

import static org.junit.Assume.assumeTrue;

import org.joda.time.LocalDateTime;
import org.junit.experimental.theories.DataPoint;

import org.fest.assertions.api.JodaTimeBaseTest;
import org.fest.assertions.api.LocalDateTimeAssert;

/**
 * 
 * Base test class for {@link LocalDateTimeAssert} tests.
 * 
 * @author Joel Costigliola
 * 
 */
public class LocalDateTimeAssertBaseTest extends JodaTimeBaseTest {

  @DataPoint
  public static LocalDateTime localDateTime1 = new LocalDateTime(2000, 12, 14, 0, 0);
  @DataPoint
  public static LocalDateTime localDateTime2 = new LocalDateTime(2000, 12, 13, 23, 59, 59, 999);
  @DataPoint
  public static LocalDateTime localDateTime3 = new LocalDateTime(2000, 12, 14, 0, 0, 0, 1);
  @DataPoint
  public static LocalDateTime localDateTime4 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 875);
  @DataPoint
  public static LocalDateTime localDateTime5 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 874);
  @DataPoint
  public static LocalDateTime localDateTime6 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 876);

  protected static void testAssumptions(LocalDateTime reference, LocalDateTime dateBefore, LocalDateTime dateAfter) {
    assumeTrue(dateBefore.isBefore(reference));
    assumeTrue(dateAfter.isAfter(reference));
  }

}