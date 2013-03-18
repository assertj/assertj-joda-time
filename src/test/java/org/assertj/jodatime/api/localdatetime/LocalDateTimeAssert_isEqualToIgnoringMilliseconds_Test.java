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
package org.assertj.jodatime.api.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;
import static org.assertj.jodatime.api.LocalDateTimeAssert.NULL_LOCAL_DATE_TIME_PARAMETER_MESSAGE;

import org.assertj.jodatime.api.JodaTimeBaseTest;
import org.joda.time.LocalDateTime;
import org.junit.Test;


public class LocalDateTimeAssert_isEqualToIgnoringMilliseconds_Test extends JodaTimeBaseTest {

  private final LocalDateTime refLocalDateTime = new LocalDateTime(2000, 1, 1, 0, 0, 1, 0);

  @Test
  public void should_pass_if_actual_is_equal_to_other_ignoring_millisecond_fields() {
    assertThat(refLocalDateTime).isEqualToIgnoringMillis(refLocalDateTime.millisOfSecond().setCopy(55));
    assertThat(refLocalDateTime).isEqualToIgnoringMillis(refLocalDateTime.plusMillis(1));
  }

  @Test
  public void should_fail_if_actual_is_not_equal_to_given_localdatetime_with_milliseconds_ignored() {
    try {
      assertThat(refLocalDateTime).isEqualToIgnoringMillis(refLocalDateTime.plusSeconds(1));
    } catch (AssertionError e) {
      assertThat(e.getMessage())
          .isEqualTo(
              "\nExpecting:\n  <2000-01-01T00:00:01.000>\nto have same year, month, day, hour, minute and second as:\n  <2000-01-01T00:00:02.000>\nbut had not.");
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_as_seconds_fields_are_different_even_if_time_difference_is_less_than_a_second() {
    try {
      assertThat(refLocalDateTime).isEqualToIgnoringMillis(refLocalDateTime.minusMillis(1));
    } catch (AssertionError e) {
      assertThat(e.getMessage())
          .isEqualTo(
              "\nExpecting:\n  <2000-01-01T00:00:01.000>\nto have same year, month, day, hour, minute and second as:\n  <2000-01-01T00:00:00.999>\nbut had not.");
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDateTime actual = null;
    assertThat(actual).isEqualToIgnoringMillis(new LocalDateTime());
  }

  @Test
  public void should_throw_error_if_given_localdatetime_is_null() {
    expectIllegalArgumentException(NULL_LOCAL_DATE_TIME_PARAMETER_MESSAGE);
    assertThat(refLocalDateTime).isEqualToIgnoringMillis(null);
  }

}
