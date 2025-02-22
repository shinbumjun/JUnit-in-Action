package com.example.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test; // JUnit 5

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("기능 개발 중")
public class CalculatorTest { // 1. 테스트 클래스 정의

    @Test // 2. 단위 메서드
    @Tag("bumjun") // 그룹으로 태그 지정 -> mvn test -Dgroups=bumjun
    @DisplayName("덧셈 테스트")
    void testAdd() {
        Calculator calculator = new Calculator(); // 3. 테스트 대상 객체 생성
        double result = calculator.add(10, 50); // 4. 파라미터 전달
        assertEquals(59, result, 1); // 5. 예상 값, 실제 실행 결과, 허용 오차
    }
}