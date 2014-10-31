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
package org.assertj.core8.error;

import org.assertj.core.error.BasicErrorMessageFactory;

public class PredicateShouldSatisfy extends BasicErrorMessageFactory {

  public PredicateShouldSatisfy(Object actual) {
    super("%nExpecting:%n  <%s>%nto satisfy given condition.", actual);
  }

  public static PredicateShouldSatisfy shouldSatisfy(Object actual) {
    return new PredicateShouldSatisfy(actual);
  }
}
