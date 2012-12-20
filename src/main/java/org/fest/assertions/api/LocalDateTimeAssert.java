package org.fest.assertions.api;

import static org.fest.assertions.error.ShouldBeAfter.shouldBeAfter;
import static org.fest.assertions.error.ShouldBeAfterOrEqualsTo.shouldBeAfterOrEqualsTo;
import static org.fest.assertions.error.ShouldBeBefore.shouldBeBefore;
import static org.fest.assertions.error.ShouldBeBeforeOrEqualsTo.shouldBeBeforeOrEqualsTo;

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