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
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.error;

/**
 * Creates an error message indicating that an assertion that verifies that an object is exactly an instance of some
 * type failed.
 * 
 * @author Joel Costigliola
 */
public class ShouldBeExactlyInstanceOf extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldBeExactlyInstanceOf}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param type the type {@code actual} is expected to be.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeExactlyInstance(Object actual, Class<?> type) {
    return new ShouldBeExactlyInstanceOf(actual, type);
  }

  private ShouldBeExactlyInstanceOf(Object actual, Class<?> type) {
    super("%nExpecting:%n <%s>%nto be exactly an instance of:%n <%s>%nbut was an instance of:%n <%s>", actual, type, actual
        .getClass());
  }
}
