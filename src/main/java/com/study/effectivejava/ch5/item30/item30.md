# Item 30

## 이왕이면 제네릭 메서드로 만들라

- 매개변수화 타입을 받는 정적 유틸리티 메서드
  - 한정적 와일드카드 타입(item 31)을 사용하면 더 유연하게 개선 가능
- 제네릭 싱글턴 팩토리
  - 소거 방식이기 떄문에 불변 객체 하나를 어떤 타입으로든 매개변수화 가능
- 재귀적 타입 한정
  - 자기 자신이 들어간 표현식을 사용하여 타입 매개변수의 허용범위를 한정