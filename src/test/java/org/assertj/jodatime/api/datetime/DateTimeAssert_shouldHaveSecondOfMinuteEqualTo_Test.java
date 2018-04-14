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
package org.assertj.jodatime.api.datetime;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

public class DateTimeAssert_shouldHaveSecondOfMinuteEqualTo_Test extends DateTimeAssertBaseTest {

    @Test
    public void should_pass_if_second_of_minute_are_equal(){
        DateTime dateTime = new DateTime(2018,4,6,10,27,33);
        assertThat(dateTime).hasSecondOfMinute(33);
    }

    @Test
    public void test_should_fail_if_secondOfMinute_is_null(){
        expectException(IllegalArgumentException.class,
                "The second of minute to compare actual with should not be null");
        DateTime dateTime = new DateTime(2018,4,6,10,27,33);
        assertThat(dateTime).hasSecondOfMinute(null);
    }

    @Test
    public void test_should_fail_if_actual_isnull(){
        expectException(AssertionError.class, actualIsNull());
        DateTime actualDateTime = null;
        assertThat(actualDateTime).hasSecondOfMinute(2);
    }
}
