package org.fest.assertions.api;

import static org.fest.assertions.error.ShouldBeAfter.shouldBeAfter;
import static org.fest.assertions.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.fest.assertions.error.ShouldBeBefore.shouldBeBefore;
import static org.fest.assertions.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;

import org.joda.time.DateTime;

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
   * Check that the {@link DateTime} to compare actual {@link DateTime} to is not null, in that case throws a
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

}