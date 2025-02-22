package com.example.tdd;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeoutTest {

    @Test
    void assertTimeoutFailTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000); // 2초 대기 (테스트 실패)
        });
    }

    @Test
    void assertTimeoutTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            Thread.sleep(1000); // 1초 대기 (테스트 성공)
        });
    }


}
