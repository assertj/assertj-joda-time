package org.fest.assertions.api.localdatetime;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.fest.assertions.api.JODA_TIME.assertThat;
import static org.fest.util.FailureMessages.actualIsNull;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


/**
 * @author Paweł Stawicki
 * @author Joel Costigliola
 */
@RunWith(Theories.class)
public class LocalDateTimeAssert_isAfter_Test extends LocalDateTimeAssertBaseTest {

  @Theory
  public void test_isAfter_assertion(LocalDateTime referenceDate, LocalDateTime dateBefore, LocalDateTime dateAfter) {
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
      assertThat(new LocalDateTime(2000, 1, 5, 3, 0, 5)).isAfter(new LocalDateTime(2012, 1, 1, 3, 3, 3));
    } catch (AssertionError e) {
      assertThat(e).hasMessage("expected:<2000-01-05T03:00:05.000> to be strictly after:<2012-01-01T03:03:03.000>");
      return;
    }
    fail("Should have thrown AssertionError");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDateTime actual = null;
    assertThat(actual).isAfter(new LocalDateTime());
  }

  @Test
  public void should_fail_if_dateTime_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The LocalDateTime to compare actual with should not be null");
    assertThat(new LocalDateTime()).isAfter(null);
  }

  private static void verify_that_isAfter_assertion_fails_and_throws_AssertionError(LocalDateTime dateToCheck,
      LocalDateTime reference) {
    try {
      assertThat(dateToCheck).isAfter(reference);
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
