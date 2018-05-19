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
 * Creates an error message indicating that an assertion that verifies that a {@link Date} is after or equals to another one
 * failed.
 *
 * @author Joel Costigliola
 */
public class ShouldBeAfterOrEqualsTo extends BasicErrorMessageFactory {

  public static ErrorMessageFactory shouldBeAfterOrEqualsTo(Object actual, Object other, ComparisonStrategy comparisonStrategy) {
    return new ShouldBeAfterOrEqualsTo(actual, other, comparisonStrategy);
  }

  public static ErrorMessageFactory shouldBeAfterOrEqualsTo(Object actual, Object other) {
    return new ShouldBeAfterOrEqualsTo(actual, other, StandardComparisonStrategy.instance());
  }

  private ShouldBeAfterOrEqualsTo(Object actual, Object other, ComparisonStrategy comparisonStrategy) {
    super("%nExpecting:%n  <%s>%nto be after or equals to:%n  <%s>%n%s", actual, other, comparisonStrategy);
  }
}
