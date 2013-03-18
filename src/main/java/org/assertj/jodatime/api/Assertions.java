/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2013 the original author or authors.
 */
package org.assertj.jodatime.api;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 * The entry point for all Joda Time assertions.
 * 
 * @author Joel Costigliola
 * @author Paweł Stawicki
 */
public class Assertions {

  public static DateTimeAssert assertThat(DateTime date) {
    return new DateTimeAssert(DateTimeAssert.class, date);
  }

  public static LocalDateTimeAssert assertThat(LocalDateTime localDateTime) {
    return new LocalDateTimeAssert(LocalDateTimeAssert.class, localDateTime);
  }

  /** Creates a new </code>{@link Assertions}</code>. */
  protected Assertions() {
    // empty
  }
}
