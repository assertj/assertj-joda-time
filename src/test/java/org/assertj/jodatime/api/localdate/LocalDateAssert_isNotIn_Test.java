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
import static org.assertj.jodatime.api.Assertions.assertThat;

/**
 * Only test String based assertion (tests with {@link LocalDate} are already defined in assertj-core)
 * 
 * @author Evgenii Strepetov
 */
@RunWith(Theories.class)
public class LocalDateAssert_isNotIn_Test extends LocalDateAssertBaseTest {

  @Theory
  public void test_isNotIn_assertion(LocalDate referenceDate) {
    // WHEN
    assertThat(referenceDate).isNotIn(referenceDate.plusDays(1).toString(), referenceDate.plusDays(2).toString());
    // THEN
    verify_that_isNotIn_assertion_fails_and_throws_AssertionError(referenceDate);
  }

  @Test
  public void test_isNotIn_assertion_error_message() {
    try {
      LocalDate actualLocalDate = new LocalDate(2000, 1, 5);
      assertThat(actualLocalDate).isNotIn("2000-01-05", "2012-01-01");
    } catch (AssertionError e) {
      assertThat(e).hasMessage(format(
          "%nExpecting:%n <2000-01-05>%nnot to be in:%n <[2000-01-05, 2012-01-01]>%n"));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_localDates_as_string_array_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The given LocalDate array should not be null");
    assertThat(new LocalDate()).isNotIn((String[]) null);
  }

  @Test
  public void should_fail_if_localDates_as_string_array_parameter_is_empty() {
    expectException(IllegalArgumentException.class, "The given LocalDate array should not be empty");
    assertThat(new LocalDate()).isNotIn(new String[]{});
  }

  private static void verify_that_isNotIn_assertion_fails_and_throws_AssertionError(LocalDate reference) {
    try {
      assertThat(reference).isNotIn(reference.toString(), reference.plusDays(1).toString());
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
