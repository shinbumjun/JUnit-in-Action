package com.example.tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class HamcrestExampleTest {

    @Test
    void testHamcrestMatchers() {
        List<String> values = Arrays.asList("Oliver", "Jack", "Harry");

        assertAll(
                () -> assertThat(values, hasSize(3)), // 리스트 크기 확인
                () -> assertThat(values, hasItem("bumjun")), // 특정 값 포함 여부 확인
                () -> assertThat(values, hasItem(anyOf(equalTo("Oliver"), equalTo("John")))), // 특정 값 포함 여부 확인
                () -> assertThat(values, contains("Oliver", "Harry", "Jack")), // ❌ 실패 → 그래도 나머지 단언 실행됨
                () -> assertThat(values, containsInAnyOrder("Jack", "Harry", "Oliver")) // 순서 상관없이 포함 여부 확인
        );

        // 문자열 관련 Matcher
        assertThat("JUnit in Action", startsWith("JUnit")); // "JUnit"으로 시작하는지 확인
        assertThat("Hamcrest Matchers", endsWith("Matchers")); // "Matchers"로 끝나는지 확인
        assertThat("Hello World", containsString("World")); // "World" 포함 여부 확인

        // 숫자 관련 Matcher
        assertThat(10, greaterThan(5)); // 10 > 5 확인
        assertThat(10, lessThanOrEqualTo(10)); // 10 ≤ 10 확인

        // 논리 연산 Matcher
        assertThat(50, allOf(greaterThan(10), lessThan(100))); // 10보다 크고 100보다 작은지 확인
        assertThat(200, anyOf(equalTo(100), equalTo(300))); // 100 또는 200인지 확인
    }
}
