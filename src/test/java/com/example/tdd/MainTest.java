package com.example.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Nested
    @DisplayName("Builder 클래스 테스트") // 1. 빌더 패턴 관련 테스트 그룹
    class BuilderTest {

        @Test
        @DisplayName("필수 값만 설정하여 Flight 객체 생성")
        void buildWithRequiredField() {
            Flight flight = new Flight.Builder("KE123").build();
            assertNotNull(flight);
            assertEquals("KE123", flight.getFlightNumber());
            assertNull(flight.getDeparture());
            assertNull(flight.getDestination());
        }

        @Test
        @DisplayName("출발지를 설정하고 Flight 객체 생성")
        void buildWithDeparture() {
            Flight flight = new Flight.Builder("KE123")
                    .setDeparture("서울")
                    .build();
            assertEquals("서울", flight.getDeparture());
            assertNull(flight.getDestination());
        }

        @Test
        @DisplayName("출발지와 도착지를 설정하고 Flight 객체 생성")
        void buildWithDepartureAndDestination() {
            Flight flight = new Flight.Builder("KE123")
                    .setDeparture("서울")
                    .setDestination("뉴욕")
                    .build();
            assertEquals("서울", flight.getDeparture());
            assertEquals("뉴욕", flight.getDestination());
        }
    }
}
