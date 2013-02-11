package org.fest.assertions.api;

import static org.fest.assertions.jodatime.error.ShouldBeAfter.shouldBeAfter;
import static org.fest.assertions.jodatime.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.fest.assertions.jodatime.error.ShouldBeBefore.shouldBeBefore;
import static org.fest.assertions.jodatime.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;
import static org.fest.assertions.jodatime.error.ShouldBeEqualIgnoringHours.shouldBeEqualIgnoringHours;
import static org.fest.assertions.jodatime.error.ShouldBeEqualIgnoringMillis.shouldBeEqualIgnoringMillis;
import static org.fest.assertions.jodatime.error.ShouldBeEqualIgnoringMinutes.shouldBeEqualIgnoringMinutes;
import static org.fest.assertions.jodatime.error.ShouldBeEqualIgnoringSeconds.shouldBeEqualIgnoringSeconds;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.fest.assertions.internal.Failures;
import org.fest.assertions.internal.Objects;

/**
 * Assertions fot Joda {@link DateTime} type.
 * 
 * @author Paweł Stawicki
 * @author Joel Costigliola
 */
public class DateTimeAssert extends AbstractAssert<DateTimeAssert, DateTime> {

  public static final String NULL_DATE_TIME_PARAMETER_MESSAGE = "The DateTime to compare actual with should not be null";

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
   * Verifies that actual and given {@code DateTime} have same year, month, day, hour, minute and second fields,
   * (millisecond fields are ignored in comparison).
   * <p>
   * Assertion can fail with dateTimes in same chronological millisecond time window, e.g :
   * <p>
   * 2000-01-01T00:00:<b>01.000</b> and 2000-01-01T00:00:<b>00.999</b>.
   * <p>
   * Assertion fails as second fields differ even if time difference is only 1ms.
   * <p>
   * Code example :
   * 
   * <pre>
   * // successfull assertions
   * DateTime dateTime1 = new DateTime(2000, 1, 1, 0, 0, 1, 0);
   * DateTime dateTime2 = new DateTime(2000, 1, 1, 0, 0, 1, 456);
   * assertThat(dateTime1).isEqualToIgnoringMillis(dateTime2);
   * 
   * // failing assertions (even if time difference is only 1ms)
   * DateTime dateTimeA = new DateTime(2000, 1, 1, 0, 0, 1, 0);
   * DateTime dateTimeB = new DateTime(2000, 1, 1, 0, 0, 0, 999);
   * assertThat(dateTimeA).isEqualToIgnoringMillis(dateTimeB);
   * </pre>
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is are not equal with milliseconds ignored.
   */
  public DateTimeAssert isEqualToIgnoringMillis(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!areEqualIgnoringMillis(actual, other)) {
      throw Failures.instance().failure(info, shouldBeEqualIgnoringMillis(actual, other));
    }
    return this;
  }

  /**
   * Verifies that actual and given {@link DateTime} have same year, month, day, hour and minute fields (second and
   * millisecond fields are ignored in comparison).
   * <p>
   * Assertion can fail with DateTimes in same chronological second time window, e.g :
   * <p>
   * 2000-01-01T00:<b>01:00</b>.000 and 2000-01-01T00:<b>00:59</b>.000.
   * <p>
   * Assertion fails as minute fields differ even if time difference is only 1s.
   * <p>
   * Code example :
   * 
   * <pre>
   * // successfull assertions
   * DateTime dateTime1 = new DateTime(2000, 1, 1, 23, 50, 0, 0);
   * DateTime dateTime2 = new DateTime(2000, 1, 1, 23, 50, 10, 456);
   * assertThat(dateTime1).isEqualToIgnoringSeconds(dateTime2);
   * 
   * // failing assertions (even if time difference is only 1ms)
   * DateTime dateTimeA = new DateTime(2000, 1, 1, 23, 50, 00, 000);
   * DateTime dateTimeB = new DateTime(2000, 1, 1, 23, 49, 59, 999);
   * assertThat(dateTimeA).isEqualToIgnoringSeconds(dateTimeB);
   * </pre>
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is are not equal with second and millisecond fields ignored.
   */
  public DateTimeAssert isEqualToIgnoringSeconds(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!areEqualIgnoringSeconds(actual, other)) {
      throw Failures.instance().failure(info, shouldBeEqualIgnoringSeconds(actual, other));
    }
    return this;
  }

  /**
   * Verifies that actual and given {@code DateTime} have same year, month, day and hour fields (minute, second and
   * millisecond fields are ignored in comparison).
   * <p>
   * Assertion can fail with dateTimes in same chronological second time window, e.g :
   * <p>
   * 2000-01-01T<b>01:00</b>:00.000 and 2000-01-01T<b>00:59:59</b>.000.
   * <p>
   * Time difference is only 1s but hour fields differ.
   * <p>
   * Code example :
   * 
   * <pre>
   * // successfull assertions
   * DateTime dateTime1 = new DateTime(2000, 1, 1, 23, 50, 0, 0);
   * DateTime dateTime2 = new DateTime(2000, 1, 1, 23, 00, 2, 7);
   * assertThat(dateTime1).isEqualToIgnoringMinutes(dateTime2);
   * 
   * // failing assertions (even if time difference is only 1ms)
   * DateTime dateTimeA = new DateTime(2000, 1, 1, 01, 00, 00, 000);
   * DateTime dateTimeB = new DateTime(2000, 1, 1, 00, 59, 59, 999);
   * assertThat(dateTimeA).isEqualToIgnoringMinutes(dateTimeB);
   * </pre>
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is are not equal ignoring minute, second and millisecond fields.
   */
  public DateTimeAssert isEqualToIgnoringMinutes(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!areEqualIgnoringMinutes(actual, other)) {
      throw Failures.instance().failure(info, shouldBeEqualIgnoringMinutes(actual, other));
    }
    return this;
  }

  /**
   * Verifies that actual and given {@code DateTime} have same year, month and day fields (hour, minute, second and
   * millisecond fields are ignored in comparison).
   * <p>
   * Assertion can fail with dateTimes in same chronological minute time window, e.g :
   * <p>
   * 2000-01-<b>01T23:59</b>:00.000 and 2000-01-02T<b>00:00</b>:00.000.
   * <p>
   * Time difference is only 1min but day fields differ.
   * <p>
   * Code example :
   * 
   * <pre>
   * // successfull assertions
   * DateTime dateTime1 = new DateTime(2000, 1, 1, 23, 59, 59, 999);
   * DateTime dateTime2 = new DateTime(2000, 1, 1, 00, 00, 00, 000);
   * assertThat(dateTime1).isEqualToIgnoringHours(dateTime2);
   * 
   * // failing assertions (even if time difference is only 1ms)
   * DateTime dateTimeA = new DateTime(2000, 1, 2, 00, 00, 00, 000);
   * DateTime dateTimeB = new DateTime(2000, 1, 1, 23, 59, 59, 999);
   * assertThat(dateTimeA).isEqualToIgnoringHours(dateTimeB);
   * </pre>
   * 
   * @param other the given {@link DateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code DateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code DateTime} is {@code null}.
   * @throws AssertionError if the actual {@code DateTime} is are not equal with second and millisecond fields ignored.
   */
  public DateTimeAssert isEqualToIgnoringHours(DateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertDateTimeParameterIsNotNull(other);
    if (!haveSameYearMonthAndDayOfMonth(actual, other)) {
      throw Failures.instance().failure(info, shouldBeEqualIgnoringHours(actual, other));
    }
    return this;
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
      throw new IllegalArgumentException(NULL_DATE_TIME_PARAMETER_MESSAGE);
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

  /**
   * Returns true if both datetime are in the same year, month and day of month, hour, minute and second, false
   * otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year, month and day of month, hour, minute and second, false
   *         otherwise.
   */
  private static boolean areEqualIgnoringMillis(DateTime actual, DateTime other) {
    return areEqualIgnoringSeconds(actual, other) && actual.getSecondOfMinute() == other.getSecondOfMinute();
  }

  /**
   * Returns true if both datetime are in the same year, month, day of month, hour and minute, false otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year, month, day of month, hour and minute, false otherwise.
   */
  private static boolean areEqualIgnoringSeconds(DateTime actual, DateTime other) {
    return areEqualIgnoringMinutes(actual, other) && actual.getMinuteOfHour() == other.getMinuteOfHour();
  }

  /**
   * Returns true if both datetime are in the same year, month, day of month and hour, false otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year, month, day of month and hour, false otherwise.
   */
  private static boolean areEqualIgnoringMinutes(DateTime actual, DateTime other) {
    return haveSameYearMonthAndDayOfMonth(actual, other) && actual.getHourOfDay() == other.getHourOfDay();
  }

  /**
   * Returns true if both datetime are in the same year, month and day of month, false otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year, month and day of month, false otherwise
   */
  private static boolean haveSameYearMonthAndDayOfMonth(DateTime actual, DateTime other) {
    return haveSameYearAndMonth(actual, other) && actual.getDayOfMonth() == other.getDayOfMonth();
  }

  /**
   * Returns true if both datetime are in the same year and month, false otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year and month, false otherwise
   */
  private static boolean haveSameYearAndMonth(DateTime actual, DateTime other) {
    return haveSameYear(actual, other) && actual.getMonthOfYear() == other.getMonthOfYear();
  }

  /**
   * Returns true if both datetime are in the same year, false otherwise.
   * 
   * @param actual the actual datetime. expected not be null
   * @param other the other datetime. expected not be null
   * @return true if both datetime are in the same year, false otherwise
   */
  private static boolean haveSameYear(DateTime actual, DateTime other) {
    return actual.getYear() == other.getYear();
  }

}