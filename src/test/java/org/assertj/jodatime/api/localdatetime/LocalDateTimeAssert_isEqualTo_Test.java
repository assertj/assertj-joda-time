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
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Only test String based assertion (tests with {@link DateTime} are already defined in assertj-core)
 * 
 * @author Joel Costigliola
 */
@RunWith(Theories.class)
public class LocalDateTimeAssert_isEqualTo_Test extends LocalDateTimeAssertBaseTest {

  @Theory
  public void test_isEqualTo_assertion(LocalDateTime referenceDate) {
    // WHEN
    assertThat(referenceDate).isEqualTo(referenceDate.toString());
    // THEN
    verify_that_isEqualTo_assertion_fails_and_throws_AssertionError(referenceDate);
  }

  @Test
  public void test_isEqualTo_assertion_error_message() {
    try {
      assertThat(new LocalDateTime(2000, 1, 5, 3, 0, 5)).isEqualTo(new LocalDateTime(2012, 1, 1, 3, 3, 3).toString());
    } catch (AssertionError e) {
      assertThat(e).hasMessage("expected:<20[12-01-01T03:03:03].000> but was:<20[00-01-05T03:00:05].000>");
      return;
    }
    fail("Should have thrown AssertionError");
  }

  @Test
  public void should_fail_if_dateTime_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
        "The String representing the LocalDateTime to compare actual with should not be null");
    assertThat(new LocalDateTime()).isEqualTo((String) null);
  }

  private static void verify_that_isEqualTo_assertion_fails_and_throws_AssertionError(LocalDateTime reference) {
    try {
      assertThat(reference).isEqualTo(reference.plusDays(1).toString());
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
