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
package org.assertj.core8.api.predicate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.core8.api.Assertions.assertThat;
import static org.assertj.core8.error.PredicateShouldSatisfy.shouldSatisfy;

public class PredicateAssert_satisfies_Test {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void should_fail_when_actual_is_null() throws Exception {
    thrown.expect(AssertionError.class);
    thrown.expectMessage(actualIsNull());

    assertThat((Object)null).satisfies(name -> true);
  }

  @Test
  public void should_fail_when_condition_is_null() throws Exception {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("The condition should not be <null>.");

    assertThat("Adam").satisfies(null);
  }

  @Test
  public void should_fail_if_condition_is_not_satisfied() {
    String actual = "Adam";
    thrown.expect(AssertionError.class);
    thrown.expectMessage(shouldSatisfy(actual).create());

    assertThat(actual).satisfies(name -> name.length() != 4);
  }
}
