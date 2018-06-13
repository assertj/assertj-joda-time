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

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Only test String based assertion (tests with {@link LocalDate} are already defined in assertj-core)
 *
 * @author Evgenii Strepetov
 */
@RunWith(Theories.class)
public class LocalDateAssert_isEqualTo_Test extends LocalDateAssertBaseTest {

  @Theory
  public void test_isEqualTo_assertion(LocalDate referenceDate) {
    // WHEN
    assertThat(referenceDate).isEqualTo(referenceDate.toString());
    // THEN
    verify_that_isEqualTo_assertion_fails_and_throws_AssertionError(referenceDate);
  }

  @Test
  public void test_isEqualTo_assertion_error_message() {
    assertThatThrownBy(() -> {
      assertThat(new LocalDate(2002, 1, 5)).isEqualTo("2012-01-05");
    })
      .isInstanceOf(AssertionError.class)
      .hasMessage("expected:<20[1]2-01-05> but was:<20[0]2-01-05>");
  }

  @Test
  public void should_fail_if_localDate_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
                    "The String representing the LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isEqualTo(null);
  }

  private static void verify_that_isEqualTo_assertion_fails_and_throws_AssertionError(LocalDate reference) {

    assertThatThrownBy(() -> {
      assertThat(reference).isEqualTo(reference.plusDays(1).toString());
    }).isInstanceOf(AssertionError.class);
  }

}
