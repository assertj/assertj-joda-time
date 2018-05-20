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
package org.assertj.jodatime.error;

import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;

/**
 * Creates an error message indicating that an assertion that verifies a Joda DateTime or LocalDateTime has a minute of hour
 * equal to a given one failed.
 *
 * @author John Killmer
 */
public class ShouldHaveMinuteOfHourEqualTo extends BasicErrorMessageFactory {

  public static ErrorMessageFactory shouldHaveMinuteOfHourEqualTo(Object actual, int actualMinuteOfHour,
                                                                  int expectedMinuteOfHour) {
    return new ShouldHaveMinuteOfHourEqualTo(actual, actualMinuteOfHour, expectedMinuteOfHour);
  }

  private ShouldHaveMinuteOfHourEqualTo(Object actual, int actualMinuteOfHour, int expectedMinuteOfHour) {
    super("%n" +
          "Expecting:%n" +
          "  <%s>%n" +
          "minute of hour to be:%n" +
          "  <%s>%n" +
          "but was:%n" +
          "  <%s>",
          actual, expectedMinuteOfHour, actualMinuteOfHour);
  }
}
