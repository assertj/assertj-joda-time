/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.jodatime.api.localdate;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

/**
 * @author Evgenii Strepetov
 */
@RunWith(Theories.class)
public class LocalDateAssert_isAfterOrEqualTo_Test extends LocalDateAssertBaseTest {

  @Theory
  public void test_isAfterOrEqual_assertion(LocalDate referenceDate, LocalDate dateBefore, LocalDate dateAfter) {
    // GIVEN
    testAssumptions(referenceDate, dateBefore, dateAfter);
    // WHEN
    assertThat(dateAfter).isAfterOrEqualTo(referenceDate);
    assertThat(dateAfter).isAfterOrEqualTo(referenceDate.toString());
    assertThat(referenceDate).isAfterOrEqualTo(referenceDate);
    assertThat(referenceDate).isAfterOrEqualTo(referenceDate.toString());
    // THEN
    verify_that_isAfterOrEqual_assertion_fails_and_throws_AssertionError(dateBefore, referenceDate);
  }

  @Test
  public void test_isAfterOrEqual_assertion_error_message() {
    try {
      LocalDate actualLocalDate = new LocalDate(2000, 1, 5);
      LocalDate localDateToCheck = new LocalDate(2012, 1, 1);
      assertThat(actualLocalDate).isAfterOrEqualTo(localDateToCheck);
    } catch (AssertionError e) {
      assertThat(e).hasMessage(format("%nExpecting:%n  <2000-01-05>%nto be after or equals to:%n  <2012-01-01>%n"));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_both_actual_and_parameter_are_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDate actual = null;
    assertThat(actual).isAfterOrEqualTo((LocalDate) null);
  }

  @Test
  public void should_fail_if_actual_is_null_and_parameter_is_not() {
    expectException(AssertionError.class, actualIsNull());
    LocalDate actual = null;
    assertThat(actual).isAfterOrEqualTo(new LocalDate());
  }

  @Test
  public void should_fail_if_actual_is_null_and_localDate_as_string_parameter_is_not() {
    expectException(AssertionError.class, actualIsNull());
    LocalDate actual = null;
    assertThat(actual).isAfterOrEqualTo(new LocalDate().toString());
  }

  @Test
  public void should_fail_if_localDate_parameter_is_null_but_actual_is_not() {
    expectException(IllegalArgumentException.class, "The LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isAfterOrEqualTo((LocalDate) null);
  }

  @Test
  public void should_fail_if_localDate_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
                    "The String representing the LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isAfterOrEqualTo((String) null);
    assertThat((LocalDate) null).isAfterOrEqualTo((String) null);
  }

  private static void verify_that_isAfterOrEqual_assertion_fails_and_throws_AssertionError(LocalDate dateToCheck,
                                                                                           LocalDate reference) {
    try {
      assertThat(dateToCheck).isAfterOrEqualTo(reference);
    } catch (AssertionError e) {
      // AssertionError was expected, test same assertion with String based parameter
      try {
        assertThat(dateToCheck).isAfterOrEqualTo(reference.toString());
      } catch (AssertionError e2) {
        // AssertionError was expected (again)
        return;
      }
    }
    fail("Should have thrown AssertionError");
  }

}
