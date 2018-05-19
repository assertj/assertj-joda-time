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

import java.util.Date;

import org.assertj.core.error.BasicErrorMessageFactory;
import org.assertj.core.error.ErrorMessageFactory;
import org.assertj.core.internal.ComparisonStrategy;
import org.assertj.core.internal.StandardComparisonStrategy;

/**
 * Creates an error message indicating that an assertion that verifies that a {@link Date} is before another one failed.
 *
 * @author Joel Costigliola
 */
public class ShouldBeBefore extends BasicErrorMessageFactory {

  public static ErrorMessageFactory shouldBeBefore(Object actual, Object other, ComparisonStrategy comparisonStrategy) {
    return new ShouldBeBefore(actual, other, comparisonStrategy);
  }

  public static ErrorMessageFactory shouldBeBefore(Object actual, Object other) {
    return new ShouldBeBefore(actual, other, StandardComparisonStrategy.instance());
  }

  private ShouldBeBefore(Object actual, Object other, ComparisonStrategy comparisonStrategy) {
    super("%nExpecting:%n  <%s>%nto be strictly before:%n  <%s>%n%s", actual, other, comparisonStrategy);
  }
}
