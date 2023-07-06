# Item 31

## 한정적 와일드카드를 사용해 API 유연성을 높여라

### 핵심 정리 1 - Chooser 와 Union API 개선

- PECS(Producer-Extends, Consumer-Super)
  - Producer-Extends
    - Object 의 컬렉션에 Number 나 Integer 를 넣을 수 있음
    - Number 의 컬렉션에 Integer 를 넣을 수 있음
  - Consumer-Super
    - Integer 컬렉션의 객체를 꺼내 Number 컬렉션에 담을 수 있음
    - Number 나 Integer 컬렉션의 객체를 꺼내 Object 의 컬렉션에 담을 수 있음

### 핵심 정리 2 - Comparator 와 Comparable 은 Consumer

- Comparable 을 직접 구현하지 않고 직접 구현한 다른 타입을 확장한 타입을 지원하려면 와일드 카드가 필요
- `ScheduledFutre`는 Comparable 을 직접 구현하지 않고, 그 상위 타입(Delayed)이 구현하고 있음

### 핵심 정리 3 - 와일드 카드 활용 팁

- 메서드 선언에 타입 매개변수가 한 번만 나오면 와일드 카드로 대체
  - 한정적 타입이라면 한정적 와일드 카드로
  - 비한정적 타입이라면 비한정적 와일드 카드로
- 주의할 점
  - 비한정적 와일드카드(?)로 정의한 타입에는 null 을 제외한 아무것도 넣을 수 없음

## 핵심 공략

### 타입 추론(Type Inference)

- 타입을 추론하는 컴파일러의 기능
- 모든 인자의 가장 구체적인 공통타입
- 제네릭 메서드와 타입 추론
  - 메서드 매개변수를 기반으로 타입 매개변수를 추론 가능
- 제네릭 클래스 생성자를 호출할 때 다이아몬트 연산자(`<>`)를 사용하면 타입을 추론
- 자바 컴파일러는 타겟 타입을 기반으로 호출하는 제네릭 메서드의 타입 매개변수를 추론
  - Java 8 에서` 타겟 타입이 메서드의 인자까지 확장`되면서 이전에 비해 타입 추론이 강화