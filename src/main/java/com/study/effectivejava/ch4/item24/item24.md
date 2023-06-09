# Item 24

## 멤버 클래스(멤버를 구성하는 요소)는 되도록 static 으로 만들라

네 종류의 중첩 클래스와 각각의 쓰임

### 정적 멤버 클래스(static)

- 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스
  - Calculator.Operation.PLUS
- 바깥 클래스와 독립적으로 생성 가능

### 비정적 멤버 클래스(non-static)

- 바깥 클래스의 인스턴스와 `암묵적으로 연결`
- `어댑터`를 정의할 떄 자주 쓰임
- 멤버 클래스에서 바깥 인스턴스를 참조할 필요가 없다면 무조건 정적 멤버 클래스로!!

### 익명 클래스

- 바깥 클래스의 멤버가 아니며, 쓰이는 시점과 동시에 인스턴스가 만들어짐
- 비정적인 문맥에서 사용될 때만 바깥 클래스의 인스턴스를 참조 가능
- 자바에서 람다를 지원하기 전에 작은 함수 객체나 처리 객체를 만들 때 사용 되었었음
- 정적 팩터리 메서드를 만들 때 사용할 수도 있음

### 지역 클래스

- 가장 드물게 사용
- 지역 변수를 선언하는 곳이면 어디든 지역 클래스를 정의할 수 있음
- 가독성을 위해 짧게 작성해야 함

## 완벽 공략

### 어댑터 패턴

- 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
  - 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해줌