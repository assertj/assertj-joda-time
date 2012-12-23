package org.fest.assertions.api;

import static org.fest.assertions.error.ShouldBeAfter.shouldBeAfter;
import static org.fest.assertions.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.fest.assertions.error.ShouldBeBefore.shouldBeBefore;
import static org.fest.assertions.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;
import static org.fest.util.Objects.areEqual;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.fest.assertions.internal.Failures;
import org.fest.assertions.internal.Objects;

/**
 * @author Paweł Stawicki
 * @author Joel Costigliola
 */
public class DateTimeAssert extends AbstractAssert<DateTimeAssert, DateTime> {

  /**
   * Creates a new <code>{@link org.fest.assertions.api.AbstractAssert}</code>.
   * 
   * @param selfType the "self type"
   * @param actual the actual value to verify
   */
  protected DateTimeAssert(Class<DateTimeAssert> selfType, DateTime actual) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual {@code DateTime} is <b>strictly</b> before the given one.
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is not strictly before the given one.
   */
  public DateTimeAssert isBefore(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeBefore(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBefore(DateTime)} but the {@link DateTime} is built from given String, which must
   * follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not strictly before the {@link DateTime} built from given
   *           String.
   */
  public DateTimeAssert isBefore(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isBefore(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Verifies that the actual {@code DateTime} is before or equals to the given one.
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is not before or equals to the given one.
   */
  public DateTimeAssert isBeforeOrEqualTo(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeBeforeOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBeforeOrEqualTo(DateTime)} but the {@link DateTime} is built from given String, which
   * must follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not before or equals to the {@link DateTime} built from
   *           given String.
   */
  public DateTimeAssert isBeforeOrEqualTo(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isBeforeOrEqualTo(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Verifies that the actual {@code DateTime} is after or equals to the given one.
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is not after or equals to the given one.
   */
  public DateTimeAssert isAfterOrEqualTo(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeAfterOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfterOrEqualTo(DateTime)} but the {@link DateTime} is built from given String, which
   * must follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not after or equals to the {@link DateTime} built from
   *           given String.
   */
  public DateTimeAssert isAfterOrEqualTo(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isAfterOrEqualTo(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Verifies that the actual {@code DateTime} is <b>strictly</b> after the given one.
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is not strictly after the given one.
   */
  public DateTimeAssert isAfter(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeAfter(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfter(DateTime)} but the {@link DateTime} is built from given String, which must follow
   * <a href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not strictly after the {@link DateTime} built from given
   *           String.
   */
  public DateTimeAssert isAfter(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isAfter(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Same assertion as {@link #isEqualTo(DateTime)} but the {@link DateTime} is built from given String, which must
   * follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not equal to the {@link DateTime} built from given String.
   */
  public DateTimeAssert isEqualTo(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isEqualTo(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Same assertion as {@link #isNotEqualTo(DateTime)} but the {@link DateTime} is built from given String, which must
   * follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime} created from the given String is built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is equal to the {@link DateTime} built from given String.
   */
  public DateTimeAssert isNotEqualTo(String dateTimeAsString) {
    assertDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isNotEqualTo(new DateTime(dateTimeAsString, actual.getZone()));
  }

  /**
   * Same assertion as {@link #isIn(DateTime...)} but the {@link DateTime} are built from given String, which must
   * follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime}s created from the given Strings are built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimesAsString String array representing {@link DateTime}s.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not in the {@link DateTime}s built from given Strings.
   */
  public DateTimeAssert isIn(String... dateTimesAsString) {
    checkIsNotNullAndNotEmpty(dateTimesAsString);
    return isIn(convertToDateTimeArray(dateTimesAsString));
  }

  /**
   * Same assertion as {@link #isIn(DateTime)} but the {@link DateTime} is built from given String, which must follow <a
   * href="http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#dateTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link DateTime#DateTime(Object) DateTime(Object)} constructor.
   * <p>
   * Note that the {@link DateTime}s created from the given Strings are built in the {@link DateTimeZone} of actual
   * {@link DateTime}.
   * 
   * @param dateTimeAsString String representing a {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link DateTime}.
   * @throws AssertionError if the actual {@code DateTime} is not equal to the {@link DateTime} built from given String.
   */
  public DateTimeAssert isNotIn(String... dateTimesAsString) {
    checkIsNotNullAndNotEmpty(dateTimesAsString);
    return isNotIn(convertToDateTimeArray(dateTimesAsString));
  }

  private DateTime[] convertToDateTimeArray(String... dateTimesAsString) {
    DateTime[] dates = new DateTime[dateTimesAsString.length];
    for (int i = 0; i < dateTimesAsString.length; i++) {
      // building the DateTime in actual's DateTimeZone
      dates[i] = new DateTime(dateTimesAsString[i], actual.getZone());
    }
    return dates;
  }

  private void checkIsNotNullAndNotEmpty(Object[] values) {
    if (values == null) {
      throw new IllegalArgumentException("The given DateTime array should not be null");
    }
    if (values.length == 0) {
      throw new IllegalArgumentException("The given DateTime array should not be empty");
    }
  }

  /**
   * Check that the {@link DateTime} to compare actual {@link DateTime} to is not null, otherwise throws a
   * {@link IllegalArgumentException} with an explicit message
   * 
   * @param dateTime the {@link DateTime} to check
   * @throws a {@link IllegalArgumentException} with an explicit message if the given {@link DateTime} is null
   */
  private static void assertDateTimeParameterIsNotNull(DateTime dateTime) {
    if (dateTime == null) {
      throw new IllegalArgumentException("The DateTime to compare actual with should not be null");
    }
  }

  /**
   * Check that the {@link DateTime} string representation to compare actual {@link DateTime} to is not null, otherwise
   * throws a {@link IllegalArgumentException} with an explicit message
   * 
   * @param dateTimeAsString String representing the DateTime to compare actual with
   * @throws a {@link IllegalArgumentException} with an explicit message if the given {@link String} is null
   */
  private static void assertDateTimeAsStringParameterIsNotNull(String dateTimeAsString) {
    if (dateTimeAsString == null) {
      throw new IllegalArgumentException(
          "The String representing the DateTime to compare actual with should not be null");
    }
  }

  // only use for tests, we can't use equals as is has been defined to throw an UnsupportedOperationException to avoid
  // using equals insteaf of isEqualTo.
  static boolean areEquals(DateTimeAssert dateTimeAssert1, DateTimeAssert dateTimeAssert2) {
    if (dateTimeAssert1 == null) {
      return dateTimeAssert2 == null;
    }
    if (dateTimeAssert2 == null) {
      // we know that dateTimeAssert1 != null
      return false;
    }
    return areEqual(dateTimeAssert1.actual, dateTimeAssert2.actual)
        && areEqual(dateTimeAssert1.info, dateTimeAssert2.info);
  }

}