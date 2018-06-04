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

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

public class LocalDateAssert_shouldHaveDayOfMonthEqualTo_Test extends LocalDateAssertBaseTest {

  @Test
  public void should_pass_if_day_of_month_is_equal() {
    LocalDate localDate = new LocalDate(2018, 4, 6);
    assertThat(localDate).hasDayOfMonth(6);
  }

  @Test
  public void test_should_fail_if_actual_is_null() {
    expectException(AssertionError.class, actualIsNull());
    LocalDate localDate = null;
    assertThat(localDate).hasDayOfMonth(6);
  }

  @Test
  public void should_fail_when_day_of_month_dont_match() {
    // GIVEN
    LocalDate localDate = new LocalDate(2018, 4, 6);
    // WHEN
    Throwable error = catchThrowable(() -> assertThat(localDate).hasDayOfMonth(5));
    // THEN
    assertThat(error).hasMessage(format("%nExpecting:%n" +
                                        "  <2018-04-06>%n" +
                                        "day of month to be:%n" +
                                        "  <5>%n" +
                                        "but was:%n" +
                                        "  <6>"));
  }

}
