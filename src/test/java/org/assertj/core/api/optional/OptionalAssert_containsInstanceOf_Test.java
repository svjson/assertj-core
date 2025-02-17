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
 * Copyright 2012-2019 the original author or authors.
 */
package org.assertj.core.api.optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.error.OptionalShouldBePresent.shouldBePresent;
import static org.assertj.core.error.OptionalShouldContainInstanceOf.shouldContainInstanceOf;
import static org.assertj.core.util.AssertionsUtil.expectAssertionError;

import java.util.Optional;

import org.assertj.core.api.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OptionalAssert containsInstanceOf")
public class OptionalAssert_containsInstanceOf_Test extends BaseTest {

  @Test
  public void should_fail_if_optional_is_empty() {
    // GIVEN
    Optional<Object> actual = Optional.empty();
    // WHEN
    AssertionError assertionError = expectAssertionError(() -> assertThat(actual).containsInstanceOf(Object.class));
    // THEN
    assertThat(assertionError).hasMessage(shouldBePresent(actual).create());
  }

  @Test
  public void should_pass_if_optional_contains_required_type() {
    // GIVEN
    Optional<String> optional = Optional.of("something");
    // THEN
    assertThat(optional).containsInstanceOf(String.class)
                        .containsInstanceOf(Object.class);
  }

  @Test
  public void should_pass_if_optional_contains_required_type_subclass() {
    // GIVEN
    Optional<SubClass> optional = Optional.of(new SubClass());
    // THEN
    assertThat(optional).containsInstanceOf(ParentClass.class);
  }

  @Test
  public void should_fail_if_optional_contains_other_type_than_required() {
    // GIVEN
    Optional<ParentClass> actual = Optional.of(new ParentClass());
    // WHEN
    AssertionError assertionError = expectAssertionError(() -> assertThat(actual).containsInstanceOf(OtherClass.class));
    // THEN
    assertThat(assertionError).hasMessage(shouldContainInstanceOf(actual, OtherClass.class).create());
  }

  private static class ParentClass {
  }
  private static class SubClass extends ParentClass {
  }
  private static class OtherClass {
  }
}
