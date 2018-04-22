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


public class DateTimeAssert_shouldHaveYearEqualTo_Test extends DateTimeAssertBaseTest {

    @Test
    public void should_pass_if_years_are_equal(){
        DateTime dateTime = new DateTime(2018,4,6,10,27,33);
        assertThat(dateTime).hasYear(2018);
    }

    @Test
    public void test_should_fail_if_actual_is_null(){
        expectException(AssertionError.class, actualIsNull());
        DateTime actualDateTime = null;
        assertThat(actualDateTime).hasYear(2018);
    }
}
