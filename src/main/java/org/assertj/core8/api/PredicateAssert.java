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
 * Copyright 2012-2014 the original author or authors.
 */
package org.assertj.core8.api;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.error.ErrorMessageFactory;
import org.assertj.core.internal.Failures;
import org.assertj.core8.error.PredicateShouldNotSatisfy;
import org.assertj.core8.error.PredicateShouldSatisfy;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Assertions for condition evaluation with lambda expression.
 *
 * @param <T> type of the actual value.
 *
 * @author Marcin Zajączkowski
 */
public class PredicateAssert<T> extends AbstractAssert<PredicateAssert<T>, T> {

  protected PredicateAssert(T actual) {
    super(actual, PredicateAssert.class);
  }

  public PredicateAssert<T> satisfies(Predicate<T> condition) {
    return verifyCondition(condition, true, PredicateShouldSatisfy::shouldSatisfy);
  }

  public PredicateAssert<T> notSatisfies(Predicate<T> condition) {
    return verifyCondition(condition, false, PredicateShouldNotSatisfy::shouldNotSatisfy);
  }

  private PredicateAssert<T> verifyCondition(Predicate<T> condition, boolean expectedEvaluationResult,
                                             Function<T, ErrorMessageFactory> errorMessageFactoryProducer) {
    isNotNull();
    if (condition == null) {
      throw new IllegalArgumentException("The condition should not be <null>.");
    }
    if (condition.test(actual) != expectedEvaluationResult) {
      throw Failures.instance().failure(info, errorMessageFactoryProducer.apply(actual));
    }
    return this;
  }
}
