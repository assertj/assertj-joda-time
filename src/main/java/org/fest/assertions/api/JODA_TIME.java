package org.fest.assertions.api;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 * The entry point for all Joda Time assertions.
 * 
 * @author Joel Costigliola
 * @author Paweł Stawicki
 */
public class JODA_TIME {

  public static DateTimeAssert assertThat(DateTime date) {
    return new DateTimeAssert(DateTimeAssert.class, date);
  }

  public static LocalDateTimeAssert assertThat(LocalDateTime localDateTime) {
    return new LocalDateTimeAssert(LocalDateTimeAssert.class, localDateTime);
  }

}
