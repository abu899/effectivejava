# Item 2

## 생성자에 매개변수가 많다면 빌더를 고려하라

- 정적 팩토리와 생성자에 선택적 매개변수가 많을 떄 고려하는 방안
  - 대안 1: 정층적 생성자 패턴 또는 생성자 체이닝
    - 매개변수가 늘어나면 코드작성 및 읽기가 어려움
  - 대안 2: 자바빈즈 패턴
    - 완전한 객체를 만들려면 메서드를 여러번 호출해야함
      - 일관성이 무너질 수 있음
    - 클래스를 불변으로 만들 수 없음

### 빌더 패턴

- 플루언트 API 또는 메서드 체이닝을 함
- 계층적으로 설계된 클래스와 함께 사용하기 편함
- 점층적 생성자(telescoping) 보다 코드를 읽고 쓰기가 간결
- 자바빈즈보다 안정성이 높음

## 완벽 공략

- 자바빈즈, getter, setter
- 객체 얼리기(freeze)
  - 자바에 있는 기능은 아님.
- 빌더 패턴
- IllegalArgumentException
- 재귀적 타입 한정을 이용한 제네릭 타입(hierarchical)
- 가변인수(varargs) 매개변수를 여러개 사용할 수 있음

### 자바빈즈

- java.beans 패키지 안에 있는 모든 것
- 자바빈이 지켜야 할 규약
  - 기본 생성자
    - 리플렉션을 통해 객체를 쉽게 생성하게 하기위해
  - getter, setter 메서드 이름 규약
  - Serializable 인터페이스 구현

### 객체 얼리기

- javascript 에 있는 기능
- Object.freeze() 에 전달한 객체는 그 뒤로 변결될 수 없음
  - 즉 불변객체가 됨
  - 새로운 프로퍼티를 추가하거나 제거하지 못함
  - 기존 프로퍼티 값을 변경하지 못함
  - 프로토타입을 변경하지 못함

### 빌더 패턴

- 복잡한 객체를 만드는 프로세스를 독립적으로 분리할 수 있음

### IllegalArgumentException

- 잘못된 인자를 받았을 떄 사용하는 기본 런타입 예외
- checked, unchecked exception
  - checked
    - 예외 더 상위로 던지거나, 예외를 처리해야함
    - 복구가 가능한 상황
  - unchecked
    - 따로 예외를 catch 로 잡거나 처리할 필요는 없음
    - 복구가 불가능한 상황
- 메소드 선언부에 unchecked exception 을 선언하는 이유는?
  - 클라이언트에게 명시적으로 알려줄 때, 선언이 필요없음에도 선언하여 의도를 표현할 수 있음
- checked exception 은 왜 사용하나
  - 반드시 catch 해야하고 선언도 해야하는데?
  - 에러가 발생했을 시, 클라이언트 단에서 후속처리를 강요해야하는 경우

### 가변인수

- 여러 인자를 받을 수 있는 가변인수
- 메소드에 오직 하나만 선언 가능
- 메소드의 가장 마지막 매개변수가 되어야함