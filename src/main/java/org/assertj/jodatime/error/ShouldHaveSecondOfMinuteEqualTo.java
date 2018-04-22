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
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.jodatime.error;

import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;
import org.joda.time.DateTime;

/**
 * Creates an error message indicating that an assertion that verifies a {@link DateTime} or {@Link LocalDateTime} has a second of minute
 * equal to a given one failed.
 *
 * @author John Killmer
 */
public class ShouldHaveSecondOfMinuteEqualTo extends BasicErrorMessageFactory {

    /**
     * Creates a new </code>{@link ShouldHaveHourOfDayEqualTo }</code>.
     *
     * @param actual the actual date object in the failed assertion.
     * @param actualSecondOfMinute the actual value of the specific date field under test.
     * @param expectedSecondOfMinute the value used in the failed assertion to compare the actual value to.
     * @return the created {@code ErrorMessageFactory}.
     */
    public static ErrorMessageFactory shouldHaveSecondOfMinuteEqualTo(Object actual, int actualSecondOfMinute, int expectedSecondOfMinute) {
        return new ShouldHaveSecondOfMinuteEqualTo(actual, actualSecondOfMinute, expectedSecondOfMinute);
    }

    private ShouldHaveSecondOfMinuteEqualTo(Object actual, int actualSecondOfMinute, int expectedSecondOfMinute) {
        super("%nExpecting:%n  <%s>%nto have the second of minute equal to:%n  <%s>%nbut was:%n  <%s>", actual, expectedSecondOfMinute,
                actualSecondOfMinute);
    }
}
