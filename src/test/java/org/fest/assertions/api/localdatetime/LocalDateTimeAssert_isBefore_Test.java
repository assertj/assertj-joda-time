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
public class LocalDateTimeAssert_isBefore_Test extends LocalDateTimeAssertBaseTest {

  @Theory
  public void test_isBefore_assertion(LocalDateTime referenceDate, LocalDateTime dateBefore, LocalDateTime dateAfter) {
    // GIVEN
    testAssumptions(referenceDate, dateBefore, dateAfter);
    // WHEN
    assertThat(dateBefore).isBefore(referenceDate);
    // THEN
    verify_that_isBefore_assertion_fails_and_throws_AssertionError(referenceDate, referenceDate);
    verify_that_isBefore_assertion_fails_and_throws_AssertionError(dateAfter, referenceDate);
  }

  @Test
  public void test_isBefore_assertion_error_message() {
    try {
      assertThat(new LocalDateTime(2000, 1, 5, 3, 0, 5)).isBefore(new LocalDateTime(1998, 1, 1, 3, 3, 3));
    } catch (AssertionError e) {
      assertThat(e).hasMessage("expected:<2000-01-05T03:00:05.000> to be strictly before:<1998-01-01T03:03:03.000>");
      return;
    }
    fail("Should have thrown AssertionError");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDateTime actual = null;
    assertThat(actual).isBefore(new LocalDateTime());
  }

  @Test
  public void should_fail_if_dateTime_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The LocalDateTime to compare actual with should not be null");
    assertThat(new LocalDateTime()).isBefore(null);
  }

  private static void verify_that_isBefore_assertion_fails_and_throws_AssertionError(LocalDateTime dateToTest,
      LocalDateTime reference) {
    try {
      assertThat(dateToTest).isBefore(reference);
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
