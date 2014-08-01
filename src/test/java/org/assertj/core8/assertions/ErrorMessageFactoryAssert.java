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
package org.assertj.core8.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.error.ErrorMessageFactory;
import org.assertj.core.internal.Objects;

import static java.util.Objects.requireNonNull;

public class ErrorMessageFactoryAssert extends AbstractAssert<ErrorMessageFactoryAssert, ErrorMessageFactory> {

  public ErrorMessageFactoryAssert(ErrorMessageFactory factory) {
    super(factory, ErrorMessageFactoryAssert.class);
  }

  public ErrorMessageFactoryAssert buildErrorMessageEqualsTo(String expected, Object... arguments) {
    requireNonNull(expected, "The expected error message should not be <null>.");
    Objects.instance().assertEqual(info, actual.create(), String.format(expected, arguments));
    return this;
  }
}
