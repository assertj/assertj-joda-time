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
package org.assertj.jodatime.api.datetime;

import static org.assertj.jodatime.api.Assertions.assertThat;
import static org.joda.time.DateTime.now;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

/**
 * Tests specific to {@link org.assertj.jodatime.api.DateTimeAssert#isIn(org.joda.time.DateTime...)} that can't be done
 * in {@link org.assertj.core.api.AbstractAssert#isIn(Object...)} tests.
 * 
 * @author Joel Costigliola
 */
public class DateTimeAssert_isIn_Test extends DateTimeAssertBaseTest {

  @Test
  public void isIn_should_compare_datetimes_in_actual_timezone() {
    DateTime utcDateTime = new DateTime(2013, 6, 10, 0, 0, DateTimeZone.UTC);
    DateTimeZone cestTimeZone = DateTimeZone.forID("Europe/Berlin");
    DateTime cestDateTime = new DateTime(2013, 6, 10, 2, 0, cestTimeZone);
    // cestDateTime and utcDateTime are equals in same timezone
    assertThat(utcDateTime).isIn(cestDateTime, now());
  }

}
