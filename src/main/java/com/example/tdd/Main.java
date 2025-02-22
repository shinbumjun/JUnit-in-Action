package com.example.tdd;

class Flight {
    private String flightNumber;
    private String departure;
    private String destination;

    // 1. 정적 내부 클래스 Builder (빌더 패턴을 위한 클래스)
    public static class Builder {
        private String flightNumber;
        private String departure;
        private String destination;

        // 2. 필수 값이 있는 생성자 (항공편 번호 필수)
        public Builder(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        // 3. 선택적 값 설정 (출발지)
        public Builder setDeparture(String departure) {
            this.departure = departure;
            return this; // *현재 Builder 객체 반환 → 메서드 체이닝 가능
        }

        // 4. 선택적 값 설정 (도착지)
        public Builder setDestination(String destination) {
            this.destination = destination;
            return this; // *현재 Builder 객체 반환 → 메서드 체이닝 가능
        }

        // 5. 최종적으로 Flight 객체 생성
        public Flight build() {
            return new Flight(this); // *Flight 생성자 호출하여 객체 생성
        }
    }

    // 추가된 Getter 메서드 (테스트에서 사용하기 위해 추가)
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    // 6. 생성자는 Builder 객체를 통해서만 호출 가능
    private Flight(Builder builder) {
        this.flightNumber = builder.flightNumber;
        this.departure = builder.departure;
        this.destination = builder.destination;
    }

    // 7. 항공편 정보 출력 메서드
    public void displayFlightInfo() {
        System.out.println("항공편: " + flightNumber + ", 출발: " + departure + ", 도착: " + destination);
    }
}

public class Main {
    public static void main(String[] args) {
        // 8. 빌더 패턴을 사용한 객체 생성 과정
        Flight flight = new Flight.Builder("KE123") // 1. Builder 객체 생성 (필수 값 설정)
                .setDeparture("서울") // 2. Builder 객체에서 출발지 설정
                .setDestination("뉴욕") // 3. Builder 객체에서 도착지 설정
                .build(); // 4. build() 호출 → Flight 객체 생성

        // 9. 생성된 Flight 객체 정보 출력
        flight.displayFlightInfo();
    }
}
