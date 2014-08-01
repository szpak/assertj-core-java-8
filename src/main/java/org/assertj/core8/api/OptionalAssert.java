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
import org.assertj.core.internal.Failures;

import java.util.Optional;

import static org.assertj.core8.error.OptionalShouldBeEmpty.shouldBeEmpty;
import static org.assertj.core8.error.OptionalShouldBePresent.shouldBePresent;
import static org.assertj.core8.error.OptionalShouldContain.shouldContain;

/**
 * Assertions for {@link java.util.Optional}.
 *
 * @param <T> type of the value contained in the {@link java.util.Optional}.
 * @author Jean-Christophe Gay
 */
public class OptionalAssert<T> extends AbstractAssert<OptionalAssert<T>, Optional<T>> {

  protected OptionalAssert(Optional<T> actual) {
    super(actual, OptionalAssert.class);
  }

  /**
   * Verifies that there is a value present in the actual {@link java.util.Optional}.
   *
   * <blockquote>Assertion will pass,
   * <pre>{@code
   *     assertThat(Optional.of("something")).isPresent();
   * }</pre></blockquote>
   *
   * <blockquote>Assertion will fail,
   * <pre>{@code
   *     assertThat(Optional.empty()).isPresent();
   * }</pre></blockquote>
   *
   * @return this assertion object.
   */
  public OptionalAssert<T> isPresent() {
    isNotNull();
    if (!actual.isPresent()) {
      throw Failures.instance().failure(info, shouldBePresent());
    }
    return this;
  }

  /**
   * Verifies that the actual {@link java.util.Optional} is empty.
   *
   * <blockquote>Assertion will pass,
   * <pre>{@code
   *     assertThat(Optional.empty()).isEmpty();
   * }</pre></blockquote>
   *
   * <blockquote>Assertion will fail,
   * <pre>{@code
   *     assertThat(Optional.of("something")).isEmpty();
   * }</pre></blockquote>
   *
   * @return this assertion object.
   */
  public OptionalAssert<T> isEmpty() {
    isNotNull();
    if (actual.isPresent()) {
      throw Failures.instance().failure(info, shouldBeEmpty(actual));
    }
    return this;
  }

  /**
   * Verifies that the actual {@link java.util.Optional} contains the value in argument.
   *
   * <blockquote>Assertion will pass,
   * <pre>{@code
   *     assertThat(Optional.of("something")).contains("something");
   *     assertThat(Optional.of(10)).contains(10);
   * }</pre></blockquote>
   *
   * <blockquote>Assertion will fail,
   * <pre>{@code
   *     assertThat(Optional.of("something")).contains("something else");
   *     assertThat(Optional.of(20)).contains(10);
   * }</pre></blockquote>
   *
   * @param expectedValue the expected value inside the {@link java.util.Optional}.
   * @return this assertion object.
   */
  public OptionalAssert<T> contains(T expectedValue) {
    isNotNull();
    if (expectedValue == null) {
      throw new IllegalArgumentException("The expected contained value should not be <null>.");
    }
    if (!actual.isPresent()) {
      throw Failures.instance().failure(info, shouldContain(expectedValue));
    }
    if (!actual.get().equals(expectedValue)) {
      throw Failures.instance().failure(info, shouldContain(actual, expectedValue));
    }
    return this;
  }
}
