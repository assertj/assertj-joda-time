/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2013 the original author or authors.
 */
package org.fest.assertions.api.datetime;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.DateTimeAssert.NULL_DATE_TIME_PARAMETER_MESSAGE;
import static org.fest.assertions.api.JODA_TIME.assertThat;
import static org.fest.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.fest.util.FailureMessages.actualIsNull;

import static org.joda.time.DateTimeZone.UTC;

import org.joda.time.DateTime;
import org.junit.Test;

import org.fest.assertions.api.JodaTimeBaseTest;

public class DateTimeAssert_isEqualToIgnoringHours_Test extends JodaTimeBaseTest {

  private final DateTime refDatetime = new DateTime(2000, 1, 2, 0, 0, 0, 0, UTC);

  @Test
  public void should_pass_if_actual_is_equal_to_other_ignoring_hour_fields() {
    assertThat(refDatetime).isEqualToIgnoringHours(refDatetime.plusHours(1));
  }

  @Test
  public void should_fail_if_actual_is_not_equal_to_given_datetime_with_hour_ignored() {
    try {
      assertThat(refDatetime).isEqualToIgnoringHours(refDatetime.minusHours(1));
    } catch (AssertionError e) {
      assertThat(e.getMessage())
          .isEqualTo(
              "\nExpecting:\n  <2000-01-02T00:00:00.000Z>\nto have same year, month and day as:\n  <2000-01-01T23:00:00.000Z>\nbut had not.");
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_as_hours_fields_are_different_even_if_time_difference_is_less_than_a_hour() {
    try {
      assertThat(refDatetime).isEqualToIgnoringHours(refDatetime.minusMillis(1));
    } catch (AssertionError e) {
      assertThat(e.getMessage())
          .isEqualTo(
              "\nExpecting:\n  <2000-01-02T00:00:00.000Z>\nto have same year, month and day as:\n  <2000-01-01T23:59:59.999Z>\nbut had not.");
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    DateTime actual = null;
    assertThat(actual).isEqualToIgnoringHours(new DateTime());
  }

  @Test
  public void should_throw_error_if_given_datetime_is_null() {
    expectIllegalArgumentException(NULL_DATE_TIME_PARAMETER_MESSAGE);
    assertThat(refDatetime).isEqualToIgnoringHours(null);
  }

}
