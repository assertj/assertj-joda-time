package org.fest.assertions.api.datetime;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.fest.assertions.api.JODA_TIME.assertThat;
import static org.fest.util.FailureMessages.actualIsNull;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author Paweł Stawicki
 * @author Joel Costigliola
 */
@RunWith(Theories.class)
public class DateTimeAssert_isAfter_Test extends DateTimeAssertBaseTest {

  @Theory
  public void test_isAfter_assertion(DateTime referenceDate, DateTime dateBefore, DateTime dateAfter) {
    // GIVEN
    testAssumptions(referenceDate, dateBefore, dateAfter);
    // WHEN
    assertThat(dateAfter).isAfter(referenceDate);
    // THEN
    verify_that_isAfter_assertion_fails_and_throws_AssertionError(referenceDate, referenceDate);
    verify_that_isAfter_assertion_fails_and_throws_AssertionError(dateBefore, referenceDate);
  }

  @Test
  public void test_isAfter_assertion_error_message() {
    try {
      assertThat(new DateTime(2000, 1, 5, 3, 0, 5)).isAfter(new DateTime(2012, 1, 1, 3, 3, 3));
    } catch (AssertionError e) {
      assertThat(e).hasMessage(
          "expected:<2000-01-05T03:00:05.000+01:00> to be strictly after:<2012-01-01T03:03:03.000+01:00>");
      return;
    }
    fail("Should have thrown AssertionError");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    DateTime actual = null;
    assertThat(actual).isAfter(new DateTime());
  }

  @Test
  public void should_fail_if_dateTime_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The DateTime to compare actual with should not be null");
    assertThat(new DateTime()).isAfter(null);
  }

  private static void verify_that_isAfter_assertion_fails_and_throws_AssertionError(DateTime dateToCheck,
      DateTime reference) {
    try {
      assertThat(dateToCheck).isAfter(reference);
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
