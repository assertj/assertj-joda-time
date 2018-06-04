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
package org.assertj.jodatime.api;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Failures;
import org.assertj.core.internal.Objects;
import org.joda.time.LocalDate;

import static org.assertj.jodatime.error.ShouldBeAfter.shouldBeAfter;
import static org.assertj.jodatime.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.assertj.jodatime.error.ShouldBeBefore.shouldBeBefore;
import static org.assertj.jodatime.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;
import static org.assertj.jodatime.error.ShouldHaveDayOfMonthEqualTo.shouldHaveDayOfMonthEqualTo;
import static org.assertj.jodatime.error.ShouldHaveMonthOfYearEqualTo.shouldHaveMonthOfYearEqualTo;
import static org.assertj.jodatime.error.ShouldHaveYearEqualTo.shouldHaveYearEqualTo;

/**
 * Assertions fot Joda {@link LocalDate} type.
 *
 * @author Evgenii Strepetov
 */
public class LocalDateAssert extends AbstractAssert<LocalDateAssert, LocalDate> {

  public static final String NULL_LOCAL_DATE_PARAMETER_MESSAGE = "The LocalDate to compare actual with should not be null";

  /**
   * Creates a new <code>{@link LocalDateAssert}</code>.
   *
   * @param selfType the "self type"
   * @param actual the actual value to verify
   */
  protected LocalDateAssert(Class<LocalDateAssert> selfType, LocalDate actual) {
    super(actual, selfType);
  }

  // visible for test
  protected LocalDate getActual() {
    return actual;
  }

  /**
   * Verifies that the year of the actual {@code LocalDate} is equal to the given year
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(2018,3,4)).hasYear(2018);</code></pre>
   *
   * @param expectedYear the given year.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws AssertionError if the year of the actual {@code LocalDate} is not equal to the given year.
   */
  public LocalDateAssert hasYear(int expectedYear) {
    isNotNull();
    if (actual.getYear() != expectedYear)
      throw Failures.instance().failure(info, shouldHaveYearEqualTo(actual, actual.getYear(), expectedYear));
    return this;
  }

  /**
   * Verifies that the month of the actual {@code LocalDate} is equal to the given month
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(2018,3,4)).hasMonthOfYear(3);</code></pre>
   *
   * @param expectedMonthOfYear the given month, from 1 to 12
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws AssertionError if the month of the actual {@code LocalDate} is not equal to the given month.
   */
  public LocalDateAssert hasMonthOfYear(int expectedMonthOfYear) {
    isNotNull();
    if (actual.getMonthOfYear() != expectedMonthOfYear)
      throw Failures.instance()
                    .failure(info, shouldHaveMonthOfYearEqualTo(actual, actual.getMonthOfYear(), expectedMonthOfYear));
    return this;
  }

  /**
   * Verifies that the month of the actual {@code LocalDate} is equal to the given month
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(2018,1,1)).hasDayOfMonth(1);</code></pre>
   *
   * @param expectedDayOfMonth the given day of month, from 1 to 31
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws AssertionError if the day of the actual {@code LocalDate} is not equal to the given day.
   */
  public LocalDateAssert hasDayOfMonth(int expectedDayOfMonth) {
    isNotNull();
    if (actual.getDayOfMonth() != expectedDayOfMonth)
      throw Failures.instance()
                    .failure(info, shouldHaveDayOfMonthEqualTo(actual, actual.getDayOfMonth(), expectedDayOfMonth));
    return this;
  }

  /**
   * Verifies that the actual {@code LocalDate} is <b>strictly</b> before the given one.
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(2000,1,1)).isBefore(new LocalDate(2000,1,2));</code></pre>
   *
   * @param other the given {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDate} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDate} is not strictly before the given one.
   */
  public LocalDateAssert isBefore(LocalDate other) {
    isNotNull();
    assertLocalDateParameterIsNotNull(other);
    if (!actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeBefore(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBefore(LocalDate)} but the {@link LocalDate} is built from given String, which
   * must follow ISO8601 format (yyyy-MM-dd) to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)}
   * constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use directly String in comparison to avoid a conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isBefore(&quot;2000-01-02&quot;);</code></pre>
   *
   * @param LocalDateAsString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not strictly before the {@link LocalDate} built
   *           from given String.
   */
  public LocalDateAssert isBefore(String LocalDateAsString) {
    assertLocalDateAsStringParameterIsNotNull(LocalDateAsString);
    return isBefore(new LocalDate(LocalDateAsString));
  }

  /**
   * Verifies that the actual {@code LocalDate} is before or equals to the given one.
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(&quot;2000-01-01&quot;)).isBeforeOrEqualTo(new LocalDate(&quot;2000-01-01&quot;))
   *                                            .isBeforeOrEqualTo(new LocalDate(&quot;2000-01-02&quot;));</code></pre>
   *
   * @param other the given {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDate} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDate} is not before or equals to the given one.
   */
  public LocalDateAssert isBeforeOrEqualTo(LocalDate other) {
    isNotNull();
    assertLocalDateParameterIsNotNull(other);
    if (actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeBeforeOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBeforeOrEqualTo(LocalDate)} but the {@link LocalDate} is built from given
   * String, which must follow ISO8601 format (yyyy-MM-dd) to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)}
   * constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use String in comparison to avoid conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isBeforeOrEqualTo(&quot;2000-01-01&quot;)
   *                                            .isBeforeOrEqualTo(&quot;2000-01-02&quot;);</code></pre>
   *
   * @param LocalDateAsString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not before or equals to the {@link LocalDate}
   *           built from given String.
   */
  public LocalDateAssert isBeforeOrEqualTo(String LocalDateAsString) {
    assertLocalDateAsStringParameterIsNotNull(LocalDateAsString);
    return isBeforeOrEqualTo(new LocalDate(LocalDateAsString));
  }

  /**
   * Verifies that the actual {@code LocalDate} is after or equals to the given one.
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(&quot;2000-01-01&quot;)).isAfterOrEqualTo(new LocalDate(&quot;2000-01-01&quot;))
   *                                            .isAfterOrEqualTo(new LocalDate(&quot;1999-12-31&quot;));</code></pre>
   *
   * @param other the given {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDate} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDate} is not after or equals to the given one.
   */
  public LocalDateAssert isAfterOrEqualTo(LocalDate other) {
    isNotNull();
    assertLocalDateParameterIsNotNull(other);
    if (actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeAfterOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfterOrEqualTo(LocalDate)} but the {@link LocalDate} is built from given
   * String, which must follow ISO8601 format (yyyy-MM-dd) to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)}
   * constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use String in comparison to avoid conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isAfterOrEqualTo(&quot;2000-01-01&quot;)
   *                                            .isAfterOrEqualTo(&quot;1999-12-31&quot;);</code></pre>
   *
   * @param LocalDateAsString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not after or equals to the {@link LocalDate}
   *           built from given String.
   */
  public LocalDateAssert isAfterOrEqualTo(String LocalDateAsString) {
    assertLocalDateAsStringParameterIsNotNull(LocalDateAsString);
    return isAfterOrEqualTo(new LocalDate(LocalDateAsString));
  }

  /**
   * Verifies that the actual {@code LocalDate} is <b>strictly</b> after the given one.
   * <p>
   * Example :
   * <pre><code class='java'> assertThat(new LocalDate(&quot;2000-01-01&quot;)).isAfter(new LocalDate(&quot;1999-12-31&quot;));</code></pre>
   *
   * @param other the given {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDate} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDate} is not strictly after the given one.
   */
  public LocalDateAssert isAfter(LocalDate other) {
    Objects.instance().assertNotNull(info, actual);
    assertLocalDateParameterIsNotNull(other);
    if (!actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeAfter(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfter(LocalDate)} but the {@link LocalDate} is built from given a String that
   * must follow ISO8601 format (yyyy-MM-dd)to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)}
   * constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use String in comparison to avoid conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isAfter(&quot;1999-12-31&quot;);</code></pre>
   *
   * @param localDateAsString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not strictly after the {@link LocalDate} built
   *           from given String.
   */
  public LocalDateAssert isAfter(String localDateAsString) {
    assertLocalDateAsStringParameterIsNotNull(localDateAsString);
    return isAfter(new LocalDate(localDateAsString));
  }

  /**
   * Same assertion as {@link #isEqualTo(Object)} (where Object is expected to be {@link LocalDate}) but here you
   * pass {@link LocalDate} String representation that must follow ISO8601 format (yyyy-MM-dd)
   * to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)} constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use directly String in comparison to avoid a conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isEqualTo(&quot;2000-01-01&quot;);</code></pre>
   *
   * @param localDateString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not equal to the {@link LocalDate} built from
   *           given String.
   */
  public LocalDateAssert isEqualTo(String localDateString) {
    assertLocalDateAsStringParameterIsNotNull(localDateString);
    return isEqualTo(new LocalDate(localDateString));
  }

  /**
   * Same assertion as {@link #isNotEqualTo(Object)} (where Object is expected to be {@link LocalDate}) but here you
   * pass {@link LocalDate} String representation that must follow ISO8601 format (yyyy-MM-dd) to
   * allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)} constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use directly String in comparison to avoid a conversion
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isNotEqualTo(&quot;2000-01-15&quot;);</code></pre>
   *
   * @param localDateAsString String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is equal to the {@link LocalDate} built from given
   *           String.
   */
  public LocalDateAssert isNotEqualTo(String localDateAsString) {
    assertLocalDateAsStringParameterIsNotNull(localDateAsString);
    return isNotEqualTo(new LocalDate(localDateAsString));
  }

  /**
   * Same assertion as {@link #isIn(Object...)} (where Objects are expected to be {@link LocalDate}) but here you
   * pass {@link LocalDate} String representations that must followISO8601 format (yyyy-MM-dd) to allow calling
   * {@link LocalDate#LocalDate(Object) LocalDate(Object)} constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use String based representation of LocalDate
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isIn(&quot;1999-12-31&quot;, &quot;2000-01-01&quot;);</code></pre>
   *
   * @param localDatesAsString String array representing {@link LocalDate}s.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is not in the {@link LocalDate}s built from given
   *           Strings.
   */
  public LocalDateAssert isIn(String... localDatesAsString) {
    checkIsNotNullAndNotEmpty(localDatesAsString);
    return isIn(convertToLocalDateArray(localDatesAsString));
  }

  /**
   * Same assertion as {@link #isNotIn(Object...)} (where Objects are expected to be {@link LocalDate}) but here you
   * pass {@link LocalDate} String representations that must follow ISO8601 format (yyyy-MM-dd)
   * to allow calling {@link LocalDate#LocalDate(Object) LocalDate(Object)} constructor.
   * <p>
   * Example :
   * <pre><code class='java'> // use String based representation of LocalDate
   * assertThat(new LocalDate(&quot;2000-01-01&quot;)).isNotIn(&quot;1999-12-31&quot;, &quot;2000-01-02&quot;);</code></pre>
   *
   * @param localDatesAsString Array of String representing a {@link LocalDate}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDate} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDate}.
   * @throws AssertionError if the actual {@code LocalDate} is in the {@link LocalDate}s built from given
   *           Strings.
   */
  public LocalDateAssert isNotIn(String... localDatesAsString) {
    checkIsNotNullAndNotEmpty(localDatesAsString);
    return isNotIn(convertToLocalDateArray(localDatesAsString));
  }

  private static Object[] convertToLocalDateArray(String... localDatesAsString) {
    LocalDate[] dates = new LocalDate[localDatesAsString.length];
    for (int i = 0; i < localDatesAsString.length; i++) {
      dates[i] = new LocalDate(localDatesAsString[i]);
    }
    return dates;
  }

  private void checkIsNotNullAndNotEmpty(Object[] values) {
    if (values == null) {
      throw new IllegalArgumentException("The given LocalDate array should not be null");
    }
    if (values.length == 0) {
      throw new IllegalArgumentException("The given LocalDate array should not be empty");
    }
  }

  /**
   * Check that the {@link LocalDate} string representation to compare actual {@link LocalDate} to is not null,
   * otherwise throws a {@link IllegalArgumentException} with an explicit message
   *
   * @param localDateAsString String representing the {@link LocalDate} to compare actual with
   * @throws IllegalArgumentException with an explicit message if the given {@link String} is null
   */
  private static void assertLocalDateAsStringParameterIsNotNull(String localDateAsString) {
    if (localDateAsString == null) {
      throw new IllegalArgumentException(
          "The String representing the LocalDate to compare actual with should not be null");
    }
  }

  /**
   * Check that the {@link LocalDate} to compare actual {@link LocalDate} to is not null, in that case throws a
   * {@link IllegalArgumentException} with an explicit message
   *
   * @param other the {@link LocalDate} to check
   * @throws IllegalArgumentException with an explicit message if the given {@link LocalDate} is null
   */
  private static void assertLocalDateParameterIsNotNull(LocalDate other) {
    if (other == null) {
      throw new IllegalArgumentException(NULL_LOCAL_DATE_PARAMETER_MESSAGE);
    }
  }
}