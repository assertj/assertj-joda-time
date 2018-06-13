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
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author Evgenii Strepetov
 */
@RunWith(Theories.class)
public class LocalDateAssert_isBefore_Test extends LocalDateAssertBaseTest {

  @Theory
  public void test_isBefore_assertion(LocalDate referenceDate, LocalDate dateBefore, LocalDate dateAfter) {
    // GIVEN
    testAssumptions(referenceDate, dateBefore, dateAfter);
    // WHEN
    assertThat(dateBefore).isBefore(referenceDate);
    assertThat(dateBefore).isBefore(referenceDate.toString());
    // THEN
    verify_that_isBefore_assertion_fails_and_throws_AssertionError(referenceDate, referenceDate);
    verify_that_isBefore_assertion_fails_and_throws_AssertionError(dateAfter, referenceDate);
  }

  @Test
  public void test_isBefore_assertion_error_message() {
    assertThatThrownBy(() -> {
      LocalDate actualDate = new LocalDate(2000, 1, 5);
      LocalDate dateToCheck = new LocalDate(1998, 1, 1);
      assertThat(actualDate).isBefore(dateToCheck);
    }).isInstanceOf(AssertionError.class)
      .hasMessage(format("%nExpecting:%n  <2000-01-05>%nto be strictly before:%n  <1998-01-01>%n"));
  }

  @Test
  public void should_fail_if_actual_is_null() {
    LocalDate nullLocalDate = null;
    LocalDate other = new LocalDate();

    assertThatThrownBy(() -> assertThat(nullLocalDate).isBefore(other)).as("other=%s", other).hasMessage(actualIsNull());
    assertThatThrownBy(() -> assertThat(nullLocalDate).isBefore(other.toString())).as("other=%s", other)
                                                                                  .hasMessage(actualIsNull());
  }

  @Test
  public void should_fail_if_localDate_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isBefore((LocalDate) null);
  }

  @Test
  public void should_fail_if_localDate_as_string_parameter_is_null() {
    expectException(IllegalArgumentException.class,
                    "The String representing the LocalDate to compare actual with should not be null");
    assertThat(new LocalDate()).isBefore((String) null);
  }

  private static void verify_that_isBefore_assertion_fails_and_throws_AssertionError(LocalDate dateToTest,
                                                                                     LocalDate reference) {
    assertThatThrownBy(() -> assertThat(dateToTest).isBefore(reference)).isInstanceOf(AssertionError.class);
    assertThatThrownBy(() -> assertThat(dateToTest).isBefore(reference.toString())).isInstanceOf(AssertionError.class);
  }
}
