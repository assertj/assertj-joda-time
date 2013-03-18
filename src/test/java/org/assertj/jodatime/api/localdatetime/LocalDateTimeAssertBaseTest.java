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
package org.assertj.jodatime.api.localdatetime;

import static org.junit.Assume.assumeTrue;

import org.assertj.jodatime.api.JodaTimeBaseTest;
import org.assertj.jodatime.api.LocalDateTimeAssert;
import org.joda.time.LocalDateTime;
import org.junit.experimental.theories.DataPoint;


/**
 * 
 * Base test class for {@link LocalDateTimeAssert} tests.
 * 
 * @author Joel Costigliola
 * 
 */
public class LocalDateTimeAssertBaseTest extends JodaTimeBaseTest {

  @DataPoint
  public static LocalDateTime localDateTime1 = new LocalDateTime(2000, 12, 14, 0, 0);
  @DataPoint
  public static LocalDateTime localDateTime2 = new LocalDateTime(2000, 12, 13, 23, 59, 59, 999);
  @DataPoint
  public static LocalDateTime localDateTime3 = new LocalDateTime(2000, 12, 14, 0, 0, 0, 1);
  @DataPoint
  public static LocalDateTime localDateTime4 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 875);
  @DataPoint
  public static LocalDateTime localDateTime5 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 874);
  @DataPoint
  public static LocalDateTime localDateTime6 = new LocalDateTime(2000, 12, 14, 22, 15, 15, 876);

  protected static void testAssumptions(LocalDateTime reference, LocalDateTime dateBefore, LocalDateTime dateAfter) {
    assumeTrue(dateBefore.isBefore(reference));
    assumeTrue(dateAfter.isAfter(reference));
  }

}