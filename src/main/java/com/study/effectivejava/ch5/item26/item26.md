# Item 26

## Raw 타입은 사용하지 말라

### 용어 정리

- Raw Type
  - ex) List
- Generic Type
  - ex) List<E>
- 매개변수화 타입
  - ex) List<String>
- 타입 매개변수
  - ex) E
- 실제 타입 매개변수
  - ex) String
- 한정적 타입 매개변수
  - ex) List<E extends Number>
- 비한정적 와일드카드 타입
  - ex) Class<?>
- 한정적 와일드 카드 타입
  - ex) Class<? extends Annotation>

### 매개변수화 타입을 사용해야하는 이유

- 런타임이 아닌 컴파일 타임에 문제를 찾을 수 있음
  - 안정성
- 제네릭을 활용하면 타입선언 자체에 정보를 보여줄 수 있음
  - 표현력
- Raw 타입을 사용하면 안정성과 표현력을 잃게 됨
- 왜 Raw 타입을 지원할까?
  - 매개변수화 타입을 사용하더라도 컴파일한 바이트코드에서는 raw type 형태로 되어있고 타입 매개변수에 따라 형변환 하는 과정이 추가로 들어간다
  - 즉, 내부에서는 실제로 raw type 을 사용하는 것처럼 동작함(하위타입 호환성)
  - List vs List<Object>
  - Set vs Set<?>
    - 위 두개 모두 안정성에 문제가 있음(+ 표현력)
- 예외
  - class literal(.class) 과 instance of

## 완벽공략

- 마이그레이션 호환성을 위해 Raw 타입을 지원하고 제네릭 구현에는 소거 방식을 사용하기로 함(Item 28)
- 제네릭 메서드(Item 30)
- 한정적 와일드 카드 타입(Item 31)
- Generic DAO 만들기

### GenericRepository, GenericDAO

