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
package org.assertj.jodatime.api.localdate;

import org.assertj.jodatime.api.JodaTimeBaseTest;
import org.assertj.jodatime.api.LocalDateAssert;
import org.joda.time.LocalDate;
import org.junit.experimental.theories.DataPoint;

import static org.junit.Assume.assumeTrue;

/**
 * Base test class for {@link LocalDateAssert} tests.
 *
 * @author Evgenii Strepetov
 */
public class LocalDateAssertBaseTest extends JodaTimeBaseTest {

  @DataPoint
  public static LocalDate localDate1 = new LocalDate(2000, 12, 14);
  @DataPoint
  public static LocalDate localDate2 = new LocalDate(1999, 12, 14);
  @DataPoint
  public static LocalDate localDate3 = new LocalDate(1999, 12, 15);
  @DataPoint
  public static LocalDate localDate4 = new LocalDate(1999, 11, 14);

  protected static void testAssumptions(LocalDate reference, LocalDate dateBefore, LocalDate dateAfter) {
    assumeTrue(dateBefore.isBefore(reference));
    assumeTrue(dateAfter.isAfter(reference));
  }
}
