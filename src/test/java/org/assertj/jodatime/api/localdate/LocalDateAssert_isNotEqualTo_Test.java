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

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Only test String based assertion (tests with {@link org.joda.time.LocalDate} are already defined in assertj-core)
 *
 * @author Evgenii Strepetov
 */
@RunWith(Theories.class)
public class LocalDateAssert_isNotEqualTo_Test extends LocalDateAssertBaseTest {

  @Theory
  public void test_isNotEqualTo_assertion(LocalDate referenceDate) {
    // WHEN
    assertThat(referenceDate).isNotEqualTo(referenceDate.plusDays(1).toString());
    // THEN
    verify_that_isNotEqualTo_assertion_fails_and_throws_AssertionError(referenceDate);
  }

  @Test
  public void test_isNotEqualTo_assertion_error_message() {
    assertThatThrownBy(() -> {
      assertThat(new LocalDate(2000, 1, 5)).isNotEqualTo("2000-01-05");
    })
      .isInstanceOf(AssertionError.class)
      .hasMessage(format("%nExpecting:%n <2000-01-05>%nnot to be equal to:%n <2000-01-05>%n"));
  }

  @Test
  public void should_fail_if_localDate_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
                    "The String representing the LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isNotEqualTo((String) null);
  }

  private static void verify_that_isNotEqualTo_assertion_fails_and_throws_AssertionError(LocalDate reference) {
    assertThatThrownBy(() -> assertThat(reference).isNotEqualTo(reference.toString())).isInstanceOf(AssertionError.class);
  }

}
