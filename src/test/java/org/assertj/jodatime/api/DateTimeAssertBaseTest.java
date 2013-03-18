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

import static org.junit.Assume.assumeTrue;

import org.joda.time.DateTime;
import org.junit.experimental.theories.DataPoint;

/**
 * 
 * Base test class for {@link DateTimeAssert} tests.
 * 
 * @author Joel Costigliola
 * 
 */
public class DateTimeAssertBaseTest extends JodaTimeBaseTest {

  @DataPoint
  public static DateTime dateTime1 = new DateTime(2000, 12, 14, 0, 0);
  @DataPoint
  public static DateTime dateTime2 = new DateTime(2000, 12, 13, 23, 59, 59, 999);
  @DataPoint
  public static DateTime dateTime3 = new DateTime(2000, 12, 14, 0, 0, 0, 1);
  @DataPoint
  public static DateTime dateTime4 = new DateTime(2000, 12, 14, 22, 15, 15, 875);
  @DataPoint
  public static DateTime dateTime5 = new DateTime(2000, 12, 14, 22, 15, 15, 874);
  @DataPoint
  public static DateTime dateTime6 = new DateTime(2000, 12, 14, 22, 15, 15, 876);

  protected static void testAssumptions(DateTime reference, DateTime dateBefore, DateTime dateAfter) {
    assumeTrue(dateBefore.isBefore(reference));
    assumeTrue(dateAfter.isAfter(reference));
  }

}