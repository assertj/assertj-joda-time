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
 * Creates an error message indicating that an assertion that verifies a Joda DateTime or LocalDateTime has millis of second
 * equal to a given one failed.
 *
 * @author John Killmer
 */
public class ShouldHaveMillisOfSecondEqualTo extends BasicErrorMessageFactory {

  public static ErrorMessageFactory shouldHaveMillisOfSecondEqualTo(Object actual, int actualMillisOfSecond,
                                                                    int expectedMillisOfSecond) {
    return new ShouldHaveMillisOfSecondEqualTo(actual, actualMillisOfSecond, expectedMillisOfSecond);
  }

  private ShouldHaveMillisOfSecondEqualTo(Object actual, int actualMillisOfSecond, int expectedMillisOfSecond) {
    super("%nExpecting:%n  <%s>%nto have the millis of second equal to:%n  <%s>%nbut was:%n  <%s>", actual,
          expectedMillisOfSecond, actualMillisOfSecond);
  }
}
