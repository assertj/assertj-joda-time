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
package org.assertj.jodatime.api.localdatetime;

import org.assertj.jodatime.api.datetime.DateTimeAssertBaseTest;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.jodatime.api.Assertions.assertThat;

public class LocalDateTimeAssert_shouldHaveSecondOfMinuteEqualTo_Test extends LocalDateTimeAssertBaseTest {

    @Test
    public void should_pass_if_second_of_minute_are_equal(){
        LocalDateTime dateTime = new LocalDateTime(2018,4,6,10,27,33);
        assertThat(dateTime).hasSecondOfMinute(33);
    }

    @Test
    public void test_should_fail_if_actual_is_null(){
        expectException(AssertionError.class, actualIsNull());
        LocalDateTime actualDateTime = null;
        assertThat(actualDateTime).hasSecondOfMinute(2);
    }
}
