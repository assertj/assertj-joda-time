package org.fest.assertions.api;

import static org.fest.assertions.error.ShouldBeAfter.shouldBeAfter;
import static org.fest.assertions.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.fest.assertions.error.ShouldBeBefore.shouldBeBefore;
import static org.fest.assertions.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import org.fest.assertions.internal.Failures;
import org.fest.assertions.internal.Objects;

/**
 * TODO javadoc !
 * 
 * @author Paweł Stawicki
 */
public class LocalDateTimeAssert extends AbstractAssert<LocalDateTimeAssert, LocalDateTime> {

  /**
   * Creates a new <code>{@link org.fest.assertions.api.LocalDateTimeAssert}</code>.
   * 
   * @param selfType the "self type"
   * @param actual the actual value to verify
   */
  protected LocalDateTimeAssert(Class<LocalDateTimeAssert> selfType, LocalDateTime actual) {
    super(actual, selfType);
  }

  /**
   * Verifies that the actual {@code LocalDateTime} is <b>strictly</b> before the given one.
   * 
   * @param other the given {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDateTime} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not strictly before the given one.
   */
  public LocalDateTimeAssert isBefore(LocalDateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertLocalDateTimeParameterIsNotNull(other);
    if (!actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeBefore(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBeforeOrEqualTo(LocalDateTime)} but the {@link LocalDateTime} is built from given
   * String, which must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param localDateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not strictly before the {@link LocalDateTime} built
   *           from given String.
   */
  public LocalDateTimeAssert isBefore(String localDateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(localDateTimeAsString);
    return isBefore(new LocalDateTime(localDateTimeAsString));
  }

  /**
   * Verifies that the actual {@code LocalDateTime} is before or equals to the given one.
   * 
   * @param other the given {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDateTime} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not before or equals to the given one.
   */
  public LocalDateTimeAssert isBeforeOrEqualTo(LocalDateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertLocalDateTimeParameterIsNotNull(other);
    if (actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeBeforeOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isBeforeOrEqualTo(LocalDateTime)} but the {@link LocalDateTime} is built from given
   * String, which must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param localDateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not before or equals to the {@link LocalDateTime}
   *           built from given String.
   */
  public LocalDateTimeAssert isBeforeOrEqualTo(String localDateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(localDateTimeAsString);
    return isBeforeOrEqualTo(new LocalDateTime(localDateTimeAsString));
  }

  /**
   * Verifies that the actual {@code LocalDateTime} is after or equals to the given one.
   * 
   * @param other the given {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDateTime} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not after or equals to the given one.
   */
  public LocalDateTimeAssert isAfterOrEqualTo(LocalDateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertLocalDateTimeParameterIsNotNull(other);
    if (actual.isBefore(other)) {
      throw Failures.instance().failure(info, shouldBeAfterOrEqualsTo(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfterOrEqualTo(LocalDateTime)} but the {@link LocalDateTime} is built from given
   * String, which must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param localDateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not after or equals to the {@link LocalDateTime}
   *           built from given String.
   */
  public LocalDateTimeAssert isAfterOrEqualTo(String localDateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(localDateTimeAsString);
    return isAfterOrEqualTo(new LocalDateTime(localDateTimeAsString));
  }

  /**
   * Verifies that the actual {@code LocalDateTime} is <b>strictly</b> after the given one.
   * 
   * @param other the given {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if other {@code LocalDateTime} is {@code null}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not strictly after the given one.
   */
  public LocalDateTimeAssert isAfter(LocalDateTime other) {
    Objects.instance().assertNotNull(info, actual);
    assertLocalDateTimeParameterIsNotNull(other);
    if (!actual.isAfter(other)) {
      throw Failures.instance().failure(info, shouldBeAfter(actual, other));
    }
    return this;
  }

  /**
   * Same assertion as {@link #isAfter(LocalDateTime)} but the {@link LocalDateTime} is built from given String, which
   * must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param localDateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not strictly after the {@link LocalDateTime} built
   *           from given String.
   */
  public LocalDateTimeAssert isAfter(String localDateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(localDateTimeAsString);
    return isAfter(new LocalDateTime(localDateTimeAsString));
  }

  /**
   * Same assertion as {@link #isEqualTo(LocalDateTime)} but the {@link LocalDateTime} is built from given String, which
   * must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param dateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not equal to the {@link LocalDateTime} built from
   *           given String.
   */
  public LocalDateTimeAssert isEqualTo(String dateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isEqualTo(new LocalDateTime(dateTimeAsString));
  }

  /**
   * Same assertion as {@link #isNotEqualTo(LocalDateTime)} but the {@link LocalDateTime} is built from given String,
   * which must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param dateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is equal to the {@link LocalDateTime} built from given
   *           String.
   */
  public LocalDateTimeAssert isNotEqualTo(String dateTimeAsString) {
    assertLocalDateTimeAsStringParameterIsNotNull(dateTimeAsString);
    return isNotEqualTo(new LocalDateTime(dateTimeAsString));
  }

  /**
   * Same assertion as {@link #isIn(LocalDateTime...)} but the {@link LocalDateTime} are built from given String, which
   * must follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param dateTimesAsString String array representing {@link LocalDateTime}s.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not in the {@link LocalDateTime}s built from given
   *           Strings.
   */
  public LocalDateTimeAssert isIn(String... dateTimesAsString) {
    checkIsNotNullAndNotEmpty(dateTimesAsString);
    return isIn(convertToLocalDateTimeArray(dateTimesAsString));
  }

  /**
   * Same assertion as {@link #isIn(LocalDateTime)} but the {@link LocalDateTime} is built from given String, which must
   * follow <a href=
   * "http://joda-time.sourceforge.net/api-release/org/joda/time/format/ISODateTimeFormat.html#localDateOptionalTimeParser()"
   * >ISO DateTime format</a> to allow calling {@link LocalDateTime#LocalDateTime(Object) LocalDateTime(Object)}
   * constructor.
   * 
   * @param dateTimeAsString String representing a {@link LocalDateTime}.
   * @return this assertion object.
   * @throws AssertionError if the actual {@code LocalDateTime} is {@code null}.
   * @throws IllegalArgumentException if given String is null or can't be converted to a {@link LocalDateTime}.
   * @throws AssertionError if the actual {@code LocalDateTime} is not equal to the {@link LocalDateTime} built from
   *           given String.
   */
  public LocalDateTimeAssert isNotIn(String... dateTimesAsString) {
    checkIsNotNullAndNotEmpty(dateTimesAsString);
    return isNotIn(convertToLocalDateTimeArray(dateTimesAsString));
  }

  private static LocalDateTime[] convertToLocalDateTimeArray(String... dateTimesAsString) {
    LocalDateTime[] dates = new LocalDateTime[dateTimesAsString.length];
    for (int i = 0; i < dateTimesAsString.length; i++) {
      dates[i] = new LocalDateTime(dateTimesAsString[i]);
    }
    return dates;
  }

  private void checkIsNotNullAndNotEmpty(Object[] values) {
    if (values == null) {
      throw new IllegalArgumentException("The given LocalDateTime array should not be null");
    }
    if (values.length == 0) {
      throw new IllegalArgumentException("The given LocalDateTime array should not be empty");
    }
  }

  /**
   * Check that the {@link DateTime} string representation to compare actual {@link DateTime} to is not null, otherwise
   * throws a {@link IllegalArgumentException} with an explicit message
   * 
   * @param localDateTimeAsString String representing the {@link LocalDateTime} to compare actual with
   * @throws a {@link IllegalArgumentException} with an explicit message if the given {@link String} is null
   */
  private static void assertLocalDateTimeAsStringParameterIsNotNull(String localDateTimeAsString) {
    if (localDateTimeAsString == null) {
      throw new IllegalArgumentException(
          "The String representing the LocalDateTime to compare actual with should not be null");
    }
  }

  /**
   * Check that the {@link LocalDateTime} to compare actual {@link LocalDateTime} to is not null, in that case throws a
   * {@link IllegalArgumentException} with an explicit message
   * 
   * @param other the {@link LocalDateTime} to check
   * @throws a {@link IllegalArgumentException} with an explicit message if the given {@link LocalDateTime} is null
   */
  private static void assertLocalDateTimeParameterIsNotNull(LocalDateTime other) {
    if (other == null) {
      throw new IllegalArgumentException("The LocalDateTime to compare actual with should not be null");
    }
  }

}