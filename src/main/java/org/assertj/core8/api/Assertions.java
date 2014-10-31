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

import java.time.LocalDateTime;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * The entry point for all new Date &amp; Time API from Java 8 assertions.
 * 
 * @author Joel Costigliola
 * @author Paweł Stawicki
 * @author Marcin Zajączkowski
 * @author Jean-Christophe Gay
 */
public class Assertions {

  public static ZonedDateTimeAssert assertThat(ZonedDateTime date) {
    return new ZonedDateTimeAssert(ZonedDateTimeAssert.class, date);
  }

  public static LocalDateTimeAssert assertThat(LocalDateTime localDateTime) {
    return new LocalDateTimeAssert(LocalDateTimeAssert.class, localDateTime);
  }

  /**
   * Create assertion for {@link java.util.Optional}.
   *
   * @param optional the actual value.
   * @param <T>      the type of the value contained in the {@link java.util.Optional}.
   * @return the created assertion object.
   */
  public static <T> OptionalAssert<T> assertThat(Optional<T> optional) {
    return new OptionalAssert<>(optional);
  }

  /**
   * Create assertion for condition evaluation.
   *
   * @param actual the actual value
   * @param <T> the type of action value
   * @return the created assertion object
   */
  public static <T> PredicateAssert<T> assertThat(T actual) {
    return new PredicateAssert<T>(actual);
  }

  /** Creates a new <code>{@link Assertions}</code>. */
  protected Assertions() {
    // empty
  }
}
